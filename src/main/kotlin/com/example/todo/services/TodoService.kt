package com.example.todo.services

import com.example.todo.models.Todo
import com.example.todo.repositories.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoService {
    @Autowired
    lateinit var todoRepo: TodoRepository

    fun saveTodo(todoEntity: Todo) : Todo{
        return todoRepo.save(todoEntity)
    }

    fun updateTodo(todoEntity: Todo, todoId: Long) : Todo{

        val newTodo: Todo = todoRepo.getReferenceById(todoId)

        newTodo.title = todoEntity.title
        newTodo.description = todoEntity.description
        newTodo.progress = todoEntity.progress

        return todoRepo.save(newTodo)
    }

    fun retrieveAllTodo(): List<Todo>? {
        return todoRepo.findAll()
    }

    fun deleteTodoById(todoId: Long) : String {
        todoRepo.deleteById(todoId)

        return "${todoId}Todo Deleted"
    }

}
