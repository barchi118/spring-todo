package com.example.todo_api.dto;

import java.util.List;

import com.example.todo_api.entity.Task;



public class TaskPostResponse {

    /** 作成されたタスクのURL */
    private String createdTaskUrl;

    /** 作成されたタスクの情報 */
    private Task createdTask;

    /** 全てのタスクの情報 */
    private List<Task> allTasks;

    public String getCreatedTaskUrl() {
        return createdTaskUrl;
    }

    public void setCreatedTaskUrl(String createdTaskUrl) {
        this.createdTaskUrl = createdTaskUrl;
    }

    public Task getCreatedTask() {
        return createdTask;
    }

    public void setCreatedTask(Task createdTask) {
        this.createdTask = createdTask;
    }

    public List<Task> getAllTasks() {
        return allTasks;
    }

    public void setAllTasks(List<Task> allTasks) {
        this.allTasks = allTasks;
    }


}
