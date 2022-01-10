package com.example.springswaggerrestapisample.controller.v1;

import com.example.springswaggerrestapisample.model.Task;
import com.example.springswaggerrestapisample.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/tasks")
// コンストラクタを自動生成します。対象は final フィールドになります。
@RequiredArgsConstructor
// このクラスがREST用のコントローラーであることをしめします。
@RestController
public class TaskController {

  private final TaskRepository repository;

  // CORS - Cross Origin Resource Sharing
  // オリジン間リソース共有
  // 通常だと、異なるオリジン（ドメイン、プロトコル、ポート）間ではリソースのやり取りが制限されます。
  // @CrossOrigin を指定することで成約を外すことができます（引数なしだと全許可）
  @CrossOrigin
  @Operation(summary = "タスクを全件取得します")
  @GetMapping("/")
  public List<Task> findAll() {
    return repository.findAll();
  }

  @Operation(summary = "タスクを登録します")
  @PostMapping("/")
  // @RequestBody ... リクエストのbody部を格納します
  public Task save(@RequestBody Task task) {
    // taskに値が格納してあるのでそのまま保存できます
    return repository.save(task);
  }

  @Operation(summary = "タスクを1件取得します")
  @GetMapping("/{id}")
  // @PathVariable ... パスの値 "{...}" を変数に格納します
  public Task findById(@PathVariable Long id) {
    // idに値が格納してあるので、そのまま検索に利用できます
    return repository.findById(id).get();
  }

  @Operation(summary = "タスクを更新します")
  @PutMapping("/{id}")
  public Task save(@RequestBody Task newTask, @PathVariable Long id) {
    return repository.findById(id).map(task -> {
      // 該当IDが存在する場合、更新します
      task.setName(newTask.getName());
      task.setCompleted(newTask.getCompleted());
      return repository.save(task);
    })
    // orElseGet ... findById の返り値は Optional で null の場合にこの分岐に入ります。
    .orElseGet(() -> {
      // 該当IDが存在しない場合、登録します
      newTask.setId(id);
      return repository.save(newTask);
    });
  }

  @Operation(summary = "タスクを削除します")
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    repository.deleteById(id);
  }
}

/*
REST API のバージョンアップをするときに移行期間を設けたいことがあります。
この場合、バージョン別のコントローラを作ることで解決できます。
 */
