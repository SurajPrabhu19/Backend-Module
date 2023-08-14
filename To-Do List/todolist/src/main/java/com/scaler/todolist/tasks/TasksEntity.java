package com.scaler.todolist.tasks;

import java.util.Date;
import java.util.List;

import com.scaler.todolist.notes.NotesEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TasksEntity {
    private Integer id;
    private String name;
    private Date dueDate;
    private TasksStatusEnum status;
    private List<NotesEntity> notes;
}
