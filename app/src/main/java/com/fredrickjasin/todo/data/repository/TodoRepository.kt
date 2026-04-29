package com.fredrickjasin.todo.data.repository

import com.fredrickjasin.todo.data.models.Todo
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.storage.Storage


class TodoRepository : TodoService {

    private val supabase = createSupabaseClient(
        supabaseUrl = "https://pweitsumlvptipuizwpe.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InB3ZWl0c3VtbHZwdGlwdWl6d3BlIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Nzc0MTMzMjEsImV4cCI6MjA5Mjk4OTMyMX0.OpU9Ypqe3gx5eVIWrPtpQteVw5Nr1j7g8q1L7DiOVOA"
    ) {
        install(Auth)
        install(Postgrest)
        install(Storage)
    }

    private val table = "todo" // make sure this matches your Supabase table name

    override suspend fun createTask(todo: Todo): Todo? {
        return try {
            val result = supabase.from(table)
                .insert(todo) {
                    select()
                }
                .decodeSingle<Todo>()

            result
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getAllTasks(): List<Todo> {
        return try {
            supabase.from(table)
                .select()
                .decodeList<Todo>()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun getTask(id: Int): Todo? {
        return try {
            supabase.from(table)
                .select {
                    filter {
                        eq("id", id)
                    }
                }
                .decodeSingleOrNull<Todo>()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun updateTask(todo: Todo): Todo? {
        return try {
            val result = supabase.from(table)
                .update(todo) {
                    filter {
                        eq("id", todo.id!!)
                    }
                    select()
                }
                .decodeSingle<Todo>()

            result
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun deleteTask(id: Int): Boolean {
        return try {
            supabase.from(table)
                .delete {
                    filter {
                        eq("id", id)
                    }
                }

            // verify deletion
            getTask(id) == null
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}