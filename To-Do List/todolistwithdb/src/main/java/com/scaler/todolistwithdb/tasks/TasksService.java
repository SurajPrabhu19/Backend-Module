package com.scaler.todolistwithdb.tasks;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.scaler.todolistwithdb.tasks.exceptions.TaskExceptions.TaskInvalidException;
import com.scaler.todolistwithdb.tasks.exceptions.TaskExceptions.TaskNotFoundException;

@Service
public class TasksService {
    // DEPENDENCY INJECTION:
    // ---------------------------------------------------------------------------------
    // @Autowired - this is dependency injection, the same is done via constructor
    // looking taskRepository
    // the annotations like @Sevice @Controller @Repository help inject dependecies
    // automatically by either looking at the ctor or @Autowired annotation
    // NOTE: use dependency inj using ctor since
    // 1. booting is faster
    // 2. while testing you can directly pass a new object as arg - which cannot be
    // done with @Autowired
    // -----------------------------------------------------------------------------------
    private TasksRepository tasksRepository;
    ModelMapper modelMapper;

    // dependency Inj via ctor
    public TasksService(TasksRepository tasksRepository, ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.modelMapper = modelMapper;
    }

    public List<TasksEntity> getAllTasks() {
        return tasksRepository.findAll();
    }

    public TasksEntity getTaskById(long id) {
        return tasksRepository.findById((long) id).orElseThrow(() -> new TaskNotFoundException((long) id));
        // if you pass int it will give compile time error therefore typecast to long ->
        // (long) id
    }
    // public Optional<TasksEntity> getTaskById(int id) {
    // return tasksRepository.findById((long) id);
    // }

    public TasksEntity createNewTask(TasksEntity tasksEntity) {
        if (tasksEntity == null)
            throw new TaskInvalidException("Task is Null");

        if (tasksEntity.getDueDate() == null || tasksEntity.getDueDate().before(new Date()))
            throw new TaskInvalidException("Task is having Invalid Due Date");
        // type conversion not required but have just kept it in case the dtype changes
        // in the tasksEntity

        TasksEntity savedTaskEntity = tasksRepository.save(tasksEntity);
        return savedTaskEntity;
    }
}
