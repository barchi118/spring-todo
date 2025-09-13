package com.example.todo_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * spring Bootアプリケーションを起動するエントリーポイント
 */
@SpringBootApplication
@MapperScan("com.example.todo_api.mapper") // mapperパッケージを探すように指示

public class TodoApiApplication {

	/**
	 * アプリケーションを起動するメインメソッドです。
	 *
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}

}
