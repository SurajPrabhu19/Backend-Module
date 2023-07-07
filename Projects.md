# Backend Module Projects

## 01 To-Do List API

### Features

- We have **Tasks** and **Notes**

- Tasks

  - We can see all existing tasks
  - We can create new Tasks as per our requirements
    - Every task will have following params
      - Title for the task
      - Due date to complete the task
      - A variable to check if the task status (Completed/ In progress/ New/ On Hold)
    - A task can be marked as completed (or undo completed too)
    - Due date and status of the tasks can be changed
    - Tasks can be deleted

- Notes
  - Multiple notes exist inside each task
  - Each note will have following params
    - Title of the Note
    - Body or the Content of the Note
  - Once a note is added it should have a unique Id as well

> NOTE: Take other necessary assumptions

## Blogging App

### Features

- We have **Users**, **Articles** & **Comments**

- User

  - Signup users using following details
    - Username, email, password, bio and avatar(url of the image)
  - login user
    - Enter username and password
    - Return the response in terms of token

- Articles

  - Each article will be written by an Author(existing user)
  - Articles have
    - title and a subtitle (use appropriate max length)
    - body or content (can be upto 5000 char)
    - tags (array of tags like tech, DSA, Backend, etc)
  - We can see all articles on the site
    - There can be many articles, so pagination is requried
    - User can search article by Author name and tags
    - e.g display articles with tag = backend
    - e.g display articles with author = "Suraj"
  - Articles can be edited by the author - any param can be edited from (title, subtitle, body, tags)
  - Articles can be deleted by the author

- Comments
  - Comments are written within an article
  - Comments can also have an author
  - Comments can be deleted by the author of the article

> NOTE: Take other necessary assumptions
