package com.scaler.todolistwithdb.tasks;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scaler.todolistwithdb.common.BaseEntity;
import com.scaler.todolistwithdb.notes.NotesEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TasksEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "due_date", nullable = false) // preferred to avoid camel case in SQL Col names
    private Date dueDate;

    @Column(name = "status", nullable = false, columnDefinition = "number default 0") // (varchar default OPEN)
    // Not
    // working
    private TaskStatusEnum status;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL) // maps "task" object in NotesEntity
    private List<NotesEntity> notes;

}

//
// NOTE: use the following to launch H2 base : http://localhost:8282/h2-console
