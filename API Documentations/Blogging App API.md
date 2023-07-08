# Blogging App API Documentation

## JSON Entities

### Author

```
    {
        "id" : "31",
        "name" : "Suraj Prabhu",
        "emailId" : "sp@gmail.com",
        "password" : "xxxxxxxx",
        "bio" : "Hi my name is Suraj Prabhu",
        "avatarUrl" : "https://imgur.com/ahkbtqe.png",
        "createdAt" : "03-12-2022"
    }
```

### Comment

```
    {
        "id" : "20",
        "comment" : "Amazing Article!",
        "date" : "03-12-2022"
    }
```

### Tag

```
    "id" : "12",
    "name" : "Backend"
```

### Article

```
    {
        "id" : "10",
        "title" : "Getting started with Backend Module",
        "subtitle" : "Backend Module",
        "content" : "Hi, this article is all about .....",
        "publishDate" : "03-14-2022",
        "rating" : "4"
    }
```

### Sponsor

```
    {
        "id" : "7",
        "name" : "xyz"
    }
```

## API Endpoints

## Users

### `POST/users`

create a new user

### `POST/users/login`

## Articles

### `GET/articles` 📄

get all articles (default page size 10)
available filters

- `/articles?tag=stocks`
- `/articles?author=arnavg`
- `/articles?page=3&size=10`

### `POST /articles` 🔐

create a new article

### `GET /articles/{article-slug}`

### `PATCH /articles/{article-slug}` 🔐👤

edit an article

### `GET /article/{article-slug}/comments` 📄

get all comments of an article

### `POST /article/{article-slug}/comments` 🔐

### `DELETE /article/{article-slug}/comments/{comment-id}` 🔐👤
