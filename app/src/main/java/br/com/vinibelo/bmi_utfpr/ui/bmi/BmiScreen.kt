package br.com.vinibelo.bmi_utfpr.ui.bmi

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BmiScreen(
    modifier: Modifier = Modifier,
    viewModel: BmiViewModel = viewModel()
) {
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }

    Scaffold (
        modifier = modifier.fillMaxSize()
    ) {
        Column (
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("height") },
                modifier = Modifier.testTag("heightField")
                    .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            )

            TextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Weight") },
                modifier = Modifier.testTag("weightField")
                    .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            )

            Button(
                onClick = {
                    viewModel.calculateBmi(height.toDoubleOrNull() ?: 0.0, weight.toDoubleOrNull() ?: 0.0)
                    height = ""
                    weight = ""
                },
                modifier = Modifier.testTag("calculateButton")
                    .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {
                Text("Calculate")
            }

            Text(
                text = viewModel.uiState.result.label,
                modifier = Modifier.testTag("resultText")
            )
        }
    }
}