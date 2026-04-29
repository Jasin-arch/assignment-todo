package com.fredrickjasin.todo.Ui.screens.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.fredrickjasin.todo.data.models.Todo
import com.fredrickjasin.todo.data.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

//data class TodoUiState(
//    val isLoading: Boolean = false,
//    val todos: List<Todo> = emptyList(),
//    val selectedTodo: Todo? = null,
//    val error: String? = null
//)

//class TodoViewModel(
//    private val repository: TodoRepository = TodoRepository()
//) : ViewModel() {
//
//    private val _state = MutableStateFlow(TodoUiState())
//    val state: StateFlow<TodoUiState> = _state.asStateFlow()
//
//    // 🔹 GET ALL TASKS
//    fun loadTodos() {
//        viewModelScope.launch {
//            _state.value = _state.value.copy(isLoading = true)
//
//            try {
//                val todos = repository.getAllTasks()
//                _state.value = _state.value.copy(
//                    isLoading = false,
//                    todos = todos,
//                    error = null
//                )
//            } catch (e: Exception) {
//                _state.value = _state.value.copy(
//                    isLoading = false,
//                    error = e.message
//                )
//

    // 🔹 CREATE TASK
//    fun createTodo(todo: Todo) {
//        viewModelScope.launch {
//            _state.value = _state.value.copy(isLoading = true)
//
//            try {
//                val newTodo = repository.createTask(todo)
//
//                _state.value = _state.value.copy(
//                    isLoading = false,
//                    todos = _state.value.todos + listOfNotNull(newTodo),
//                    error = null
//                )
//            } catch (e: Exception) {
//                _state.value = _state.value.copy(
//                    isLoading = false,
//                    error = e.message
//                )
//            }
//        }
//    }
//
//    // 🔹 UPDATE TASK
//    fun updateTodo(todo: Todo) {
//        viewModelScope.launch {
//            _state.value = _state.value.copy(isLoading = true)
//
//            try {
//                val updated = repository.updateTask(todo)
//
//                val updatedList = _state.value.todos.map {
//                    if (it.id == updated?.id) updated else it
//                }
//
//                _state.value = _state.value.copy(
//                    isLoading = false,
//                    todos = updatedList.filterNotNull(),
//                    error = null
//                )
//            } catch (e: Exception) {
//                _state.value = _state.value.copy(
//                    isLoading = false,
//                    error = e.message
//                )
//            }
//        }
//    }
//
//    // 🔹 DELETE TASK
//    fun deleteTodo(id: Int) {
//        viewModelScope.launch {
//            _state.value = _state.value.copy(isLoading = true)
//
//            try {
//                val success = repository.deleteTask(id)
//
//                if (success) {
//                    val updatedList = _state.value.todos.filter { it.id != id }
//
//                    _state.value = _state.value.copy(
//                        isLoading = false,
//                        todos = updatedList,
//                        error = null
//                    )
//                } else {
//                    _state.value = _state.value.copy(
//                        isLoading = false,
//                        error = "Failed to delete task"
//                    )
//                }
//            } catch (e: Exception) {
//                _state.value = _state.value.copy(
//                    isLoading = false,
//                    error = e.message
//                )
//            }
//        }
//    }
//}

class TodoViewModel: ViewModel() {
    //    State
    private val _todo = MutableStateFlow<Todo>(Todo())
    val todo = _todo.asStateFlow()

    //    "CRUD" methods
    fun createtodo(id: String, title: String){
        _todo.value = TodoViewModel(id = id, title = title,)
    }



}