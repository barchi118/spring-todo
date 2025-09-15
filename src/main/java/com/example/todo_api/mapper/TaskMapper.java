package com.example.todo_api.mapper;

import java.util.List;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.example.todo_api.entity.Task;

@Mapper // MyBatisにこのインターフェースをMapperとして認識させる
public interface TaskMapper {
    /**
     * データベースのtasksテーブルに新しいタスクを1件挿入する
     * 
     * @param task 保存するタスクのデータ
     */
    @Insert("INSERT INTO tasks (title, completed) VALUES (#{title}, #{completed})")
    // INSERT後に生成されたidが、引数で渡されたtaskオブジェクトのidフィールドに自動的にセット
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(com.example.todo_api.entity.Task task);


    // ★★★ 全てのタスクを取得するメソッドを追加 ★★★
    @Select("SELECT * FROM tasks ORDER BY id")
    List<Task> findAll();
}
