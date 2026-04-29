package com.fredrickjasin.todo.Ui.screens.home

import android.R.attr.description
import android.R.attr.id
import android.R.id.title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomScreen(
    modifier: Modifier,
    HomeViewModel: HomeViewModel = viewModel(),
){
    val alltodos = HomeViewModel.alltodos.collectAsState()
    var todoid by  remember { mutableStateOf(TextFieldValue("")) }
    var todotitle by remember { mutableStateOf(TextFieldValue("")) }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = todoid,
            onValueChange = { todoid = it },
            label = { Text(text = "Todo Id") },
            maxLines = 1
        )
        OutlinedTextField(
            value = todotitle,
            onValueChange = { todotitle = it },
            label = { Text(text = "Todo title") },
            minLines = 1
        )

        OutlinedButton(
            onClick = {
                HomeViewModel.createalltodos(
                    id = todoid.hashCode())
            }
        ) {
            Text(text = "Create Todo")
        }
        HorizontalDivider()
        Text(
            text = alltodos.value.title
        )
        Text(text = alltodos.value.description)


    }


}
//fun createHobby(name:String, description:String): HobbyDataModel{
//    return HobbyDataModel(name= name, description = description)
//}


