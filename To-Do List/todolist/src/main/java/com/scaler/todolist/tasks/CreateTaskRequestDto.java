package com.scaler.todolist.tasks;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateTaskRequestDto {
    private String name;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dueDate;
}
