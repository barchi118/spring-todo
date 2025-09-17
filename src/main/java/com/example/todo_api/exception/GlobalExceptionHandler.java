package com.example.todo_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * アプリケーション全体で発生する例外をハンドリングし、 適切なHTTPレスポンスを生成するためのクラス。
 */
@RestControllerAdvice // 全ての@RestControllerで発生した例外を捕まえる
public class GlobalExceptionHandler {

    /**
     * バリデーションエラー(@Valid)をハンドリングし、400 Bad Requestを返す。
     * 
     * @param ex 発生した例外
     * @return エラー詳細を含むResponseEntity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * データが見つからない場合のエラー(TaskNotFoundException)をハンドリングし、404 Not Foundを返す。
     * 
     * @param ex 発生した例外
     * @return エラーメッセージを含むResponseEntity
     */
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTaskNotFoundException(
            TaskNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * 楽観ロックの競合エラー(OptimisticLockException)をハンドリングし、409 Conflictを返す。
     * 
     * @param ex 発生した例外
     * @return エラーメッセージを含むResponseEntity
     */
    @ExceptionHandler(OptimisticLockException.class)
    public ResponseEntity<Map<String, String>> handleOptimisticLockException(
            OptimisticLockException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}

