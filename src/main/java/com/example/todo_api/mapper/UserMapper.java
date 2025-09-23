package com.example.todo_api.mapper;

import com.example.todo_api.entity.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserMapper {


    /**
     * ユーザー登録
     * 
     * @param task
     */
    @Insert("INSERT INTO users (name) VALUES (#{name})")
    // INSERT後に生成されたidが、引数で渡されたtaskオブジェクトのidフィールドに自動的にセット
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insertUser(com.example.todo_api.entity.User user);

    /** タスクと担当者を中間テーブルで紐付ける */
    @Insert("INSERT INTO task_assignees (task_id, user_id) VALUES (#{taskId}, #{userId})")
    void assignToTask(@Param("taskId") Long taskId, @Param("userId") Long userId);
    

     @Delete("DELETE FROM task_assignees WHERE task_id = #{taskId}")
    void detachAllFromTask(@Param("taskId") Long taskId);

}
