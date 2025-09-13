package com.example.todo_api.dto;

/**
 * タスクのエンティティ
 */
public class Task {
    // ID
    private Long id;
    // 名前
    private String name;
    // tagのID
    private Integer tagId;

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

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }



}
