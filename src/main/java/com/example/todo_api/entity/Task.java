package com.example.todo_api.entity; // パッケージ名が正しいか確認

import java.util.List;
import lombok.Data;

@Data
public class Task {

    // フィールド
    private Long id;
    private String title;
    private boolean completed;
    private int version;

    /** このタスクの担当者リスト (結果を格納するためのポケット) */
    private List<User> assignees;



}
