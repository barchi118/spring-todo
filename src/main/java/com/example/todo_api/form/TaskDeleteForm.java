package com.example.todo_api.form;

import jakarta.validation.constraints.NotNull;


/**
 * タスク削除リクエストでバージョンを受け取るためのフォームクラス
 */
public class TaskDeleteForm {
    @NotNull
    private Integer version;

    // GetterとSetter
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
