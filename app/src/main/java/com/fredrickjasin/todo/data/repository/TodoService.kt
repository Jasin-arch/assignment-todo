package com.fredrickjasin.todo.data.repository

import com.fredrickjasin.todo.data.models.Todo

interface TodoService {

    // CREATE
    suspend fun createTask(todo: Todo): Todo?

    // READ (all tasks)
    suspend fun getAllTasks(): List<Todo>

    // READ (single task)
    suspend fun getTask(id: Int): Todo?

    // UPDATE
    suspend fun updateTask(todo: Todo): Todo?

    // DELETE
    suspend fun deleteTask(id: Int): Boolean
}