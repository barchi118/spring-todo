package com.example.todo_api.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.todo_api.entity.Task;
import java.util.Optional;

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
    void insert(Task task);


    // 全てのタスクを取得するメソッドを追加
    List<Task> findAll();

    // 特定の1件のタスクを取得
    Optional<Task> findById(Long id); // データが見つからない可能性があるのでOptionalで囲む

    // 更新
    // @Update("UPDATE tasks SET title = #{title}, completed = #{completed} WHERE id = #{id}")
    int update(Task task);

    // 削除
    // @Delete("DELETE FROM tasks WHERE id = #{id}")
    int deleteById(Task task);
}
