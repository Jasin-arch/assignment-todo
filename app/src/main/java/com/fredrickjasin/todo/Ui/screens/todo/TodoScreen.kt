package com.fredrickjasin.todo.Ui.screens.todo

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentDataType.Companion.Date
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fredrickjasin.todo.data.models.Todo
import io.ktor.http.HttpHeaders.Date
import java.util.Date


@Composable
fun TodoScreen(
    todo: Todo,
    TodoscreenViewModel: TodoViewModel = viewModel(),
    modifier: Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        val state = TodoscreenViewModel.state.collectAsState()

        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Checkbox(
                    checked = todo.isComplete,
                    onCheckedChange = { onToggleComplete(todo) }
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = todo.description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = todo.dueDate,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}
