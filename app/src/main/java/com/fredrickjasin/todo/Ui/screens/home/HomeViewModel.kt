package com.fredrickjasin.todo.Ui.screens.home

import androidx.lifecycle.ViewModel
import com.fredrickjasin.todo.data.models.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {

    //    State
    private val _alltodos = MutableStateFlow<Todo>(Todo())
    val alltodos = _alltodos.asStateFlow()

    //    "CRUD" methods
    fun createalltodos(id: Int, createdAt: String,title: String,description: String,media: String, isComplete: Boolean,dueDate: String ){
        _alltodos.value = Todo(id=id, title=title, description = description)
    }



}