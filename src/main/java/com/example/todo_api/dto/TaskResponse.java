package com.example.todo_api.dto;


/**
 * タスクのエンティティ
 */

public class TaskResponse {
    // ID
    private Long id;
    // 名前
    private String name;

    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
