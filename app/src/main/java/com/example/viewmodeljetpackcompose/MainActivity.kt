package com.example.viewmodeljetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.viewmodeljetpackcompose.ui.theme.ViewmodelJetpackComposeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel by viewModels<com.example.viewmodeljetpackcompose.ViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory{
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return com.example.viewmodeljetpackcompose.ViewModel(number = 4) as T
                    }
                }
            }
        )
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewmodelJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        val text  = viewModel.text.collectAsState()
                        Spacer(modifier = Modifier.height(30.dp))

                        Text(text = text.value)
                        Spacer(modifier = Modifier.height(30.dp))
                        TextField(value = text.value,
                            onValueChange = {
                            viewModel.changeText(it)
                        },
                            label = {
                                Text(text = "Enter Text")
                            })
                    }
                }
            }
        }
    }
}

