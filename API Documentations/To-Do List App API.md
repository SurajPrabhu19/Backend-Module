# Blogging App API Documentation

## JSON Entities

### Task

```
    {
        "id" : "7",
        "title" : "Complete the Assignments",
        "description" : "Submit the Solution",
        "taskStatus" : "Completed",
        "dueDate" : "01-07-2023",
        "priority" : "4"
    }
```

### Note

```
    {
        "id" : "97",
        "note" : "Task needs knowledge of backend"
    }
```

## API Endpoints

### `GET/tasks/{task-id}`

### `POST/tasks`

create a new task

### `DELETE/tasks/{task-id}`

delete a task

### `GET/tasks/{task-id}/notes`

get notes by task-id

### GET/tasks/{task-id}/notes/{notes-id}

get notes by task-id and note-id

### `POST/tasks/{task-id}/notes`

create a new note inside a task

### DELETE /tasks/{task_id}/notes/{notes_id}

Delete a note
