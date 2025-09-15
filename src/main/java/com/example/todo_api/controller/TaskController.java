package com.example.todo_api.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.todo_api.dto.TaskCreateForm;
import com.example.todo_api.dto.TaskPostResponse;
import com.example.todo_api.entity.Task;
import com.example.todo_api.service.TaskService;

// @RestControllerはJSONやXMLを返す．例のように，文字列を返すこともできるし，オブジェクトを返すこともできる．
@RestController
// React用
@CrossOrigin(origins = "http://localhost:3000")

// http://localhost:8080/tasksというURLへのリクエストを受け取ったときに実行
@RequestMapping("/tasks")


/**
 * タスク用のコントローラー
 */
public class TaskController {

    // TaskServiceを自動的に使う準備
    @Autowired
    private TaskService taskService;

    /**
     * POSTリクエストを検知しこのcreateTaskメソッドを呼びだす JSONデータが自動的にTaskCreateFormオブジェクトに変換され、formという変数に格納
     * 
     * @RequestBodyは HTTPリクエストのボディ部分に入っているJSONデータを、Javaオブジェクトに変換
     * 
     * @param form
     * @return
     */

    // 、HTTP POSTリクエストを処理するコントローラーメソッドを定義するためのアノテーション
    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskCreateForm form) {
        Task createdTask = taskService.createTask(form);

        // 2全てのタスクのリストを取得する
        List<Task> allTasks = taskService.getAllTasks();
        // HTTPステータス201 Createdと一緒に返却
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest() // 現在のリクエストURL
                // (http://localhost:8080/tasks)
                .path("/{id}") // パスに "/{id}" を追加
                .buildAndExpand(createdTask.getId()) // "{id}" の部分に実際のIDを埋め込む
                .toUri(); // URIに変換


        // レスポンスボディ用のオブジェクトを作成し、情報を詰める
        TaskPostResponse responseBody = new TaskPostResponse();
        responseBody.setCreatedTaskUrl(locationUri.toString());
        responseBody.setCreatedTask(createdTask);
        responseBody.setAllTasks(allTasks);
        // HTTPステータスコードを自動で 201 Created
        // HTTPレスポンスの**Locationヘッダー**に、先ほど組み立てたURL (locationUri) を設定す
        // .build(): レスポンスオブジェクトを最終的に確定させ、Springに「これを応答として返してください」と渡す
        return ResponseEntity.created(locationUri).build();

    }
}
