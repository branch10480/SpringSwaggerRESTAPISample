package com.example.springswaggerrestapisample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
// データの入れ物であるEntityであることを示します
@Entity
public class Task {
  // 主キー
  @Id
  // 主キーの自動採番をします。＠Idとともに使います。
  @GeneratedValue
  private Long id;

  @NotBlank
  @Size(max = 255)
  private String name;

  @NotNull
  private Boolean completed = false;
}
