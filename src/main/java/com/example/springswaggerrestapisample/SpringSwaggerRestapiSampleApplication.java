package com.example.springswaggerrestapisample;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// この記述で上部のタイトルや説明を指定できる
@OpenAPIDefinition(info = @Info(
  title = "Task API",
  version = "1.0.0",
  description = "これは、Taskアプリケーションに関するAPIです"
))

@SpringBootApplication
public class SpringSwaggerRestapiSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSwaggerRestapiSampleApplication.class, args);
  }

}
