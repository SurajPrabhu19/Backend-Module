package com.scaler.todolistwithdb.notes;

import com.scaler.todolistwithdb.common.BaseEntity;
import com.scaler.todolistwithdb.tasks.TasksEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class NotesEntity extends BaseEntity {
    // since we dont want the base entity to create its object we make it abstract
    // Also people can extend it to get the attributes
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "body", nullable = false, length = 1000) // len(1000) converts varchar to text dtype
    private String body;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TasksEntity task;
}
