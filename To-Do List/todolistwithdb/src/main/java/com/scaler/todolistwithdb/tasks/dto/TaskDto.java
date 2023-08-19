package com.scaler.todolistwithdb.tasks.dto;

import java.util.Date;

import org.springframework.lang.Nullable;

import com.scaler.todolistwithdb.tasks.TaskStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    @Nullable
    // @GeneratedValue(strategy = GenerationType.SEQUENCE) // generate incremental
    // id values
    private Long id;
    @Nullable
    private String name;
    @Nullable
    private Date dueDate;
    @Nullable
    private TaskStatusEnum status;
}
