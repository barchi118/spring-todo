package com.example.todo_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.todo_api.form.TaskUpdateForm;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.todo_api.dto.TaskCreateForm;
import com.example.todo_api.entity.Task;
import com.example.todo_api.mapper.TaskMapper;
import com.example.todo_api.exception.TaskNotFoundException;
import com.example.todo_api.exception.OptimisticLockException;
import java.util.List;
import com.example.todo_api.form.TaskDeleteForm;

@Service // このクラスがサービス層のコンポーネントであることを示す
public class TaskService {

    @Autowired // TaskMapperを自動的に使う準備
    private TaskMapper taskMapper;

    /**
     * フォームから受け取った情報でタスクを作成する ビジネスロジック
     * 
     * @param form Controllerから渡されたフォームデータ
     */
    @Transactional // このメソッド内のデータベース操作を一つの処理単位として扱う
    public Task createTask(TaskCreateForm form) {
        // 1. FormからEntityにデータを詰め替える
        Task task = new Task();
        task.setTitle(form.getTitle());
        task.setCompleted(form.isCompleted());
        taskMapper.insert(task);
        // 2. Mapperを呼び出してデータベースに保存する
        taskMapper.insert(task);

        return task;
    }

    /**
     * 全てのタスクを取得
     * 
     * @return
     */
    public List<Task> getAllTasks() {
        return taskMapper.findAll();
    }

    /**
     * orElseThrowで、もしデータが見つからなければ例外を発生させる
     * 
     * @param id
     * @return
     */
    public Task findById(Long id) {

        return taskMapper.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    /**
     * Serviceファイルの下部、または別ファイルに専用の例外クラスを作成
     */
    @ResponseStatus(HttpStatus.NOT_FOUND) // この例外が投げられたらHTTP 404を返す
    class TaskNotFoundException extends RuntimeException {
        public TaskNotFoundException(String message) {
            super(message);
        }
    }


    /**
     * 更新処理
     * 
     * @param id
     * @param form
     * @return
     */
    public Task updateTask(Long id, TaskUpdateForm form) {
        // まず更新対象のタスクが存在するかチェック
        Task task = findById(id);
        if (task == null) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }

        // Formから受け取った値で上書き
        task.setTitle(form.getTitle());
        task.setCompleted(form.isCompleted());
        task.setVersion(form.getVersion());

        // 更新を実行し、実際に更新された行数を取得
        int affectedRows = taskMapper.update(task);

        // 4楽観ロックの競合をチェック
        if (affectedRows == 0) {
            // 更新件数が0件の場合、WHERE句のversionが一致しなかったことを意味する
            throw new OptimisticLockException(
                    "Optimistic lock conflict: The task was updated by another user.");
        }

        return task;
    }


    /**
     * 削除用ビジネスロジック
     * 
     * @param id
     */
    public void deleteTask(Long id, TaskDeleteForm form) {
        // 存在チェック（なければfindByIdが例外を投げる）
        Task task = findById(id);
        if (task == null) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        task.setVersion(form.getVersion());
        task.setId(id);
        int affectedRows = taskMapper.deleteById(task);

        if (affectedRows == 0) {
            // 更新件数が0件の場合、WHERE句のversionが一致しなかったことを意味する
            throw new OptimisticLockException(
                    "Optimistic lock conflict: The task was updated by another user.");
        }

    }
}


