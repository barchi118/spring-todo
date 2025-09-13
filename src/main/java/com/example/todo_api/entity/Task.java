package com.example.todo_api.entity; // パッケージ名が正しいか確認

public class Task {

    // フィールド
    private Long id;
    private String title;
    private boolean completed;

    // --- ここから下が重要 ---

    // ゲッターとセッター
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    // エラーの原因となっているメソッド
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    // エラーの原因となっているメソッド
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
