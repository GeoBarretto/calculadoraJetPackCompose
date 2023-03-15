package com.example.calculadorinha

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadorinha.ui.theme.CalculadorinhaTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatoraScreen()
        }
    }
}//fecha class MainActivity : ComponentActivity() {

@Composable
fun CalculatoraScreen() {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        TextField(
            value = value1,
            onValueChange = { value1 = it },
            label = { Text("Value 1") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = value2,
            onValueChange = { value2 = it },
            label = { Text("Value 2") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            Modifier
                .padding(vertical = 16.dp)
                .align(CenterHorizontally)) {
            Button(onClick = { operator = "+"}, Modifier.padding(5.dp)) {
                Text("+")
            }
            Button(onClick = { operator = "-"}, Modifier.padding(5.dp)) {
                Text("-")
            }
            Button(onClick = { operator = "*"}, Modifier.padding(5.dp)) {
                Text("*")
            }
            Button(onClick = { operator = "/"}, Modifier.padding(5.dp)) {
                Text("/")
            }

        }

        Button(onClick = {
            if (value1.isNotEmpty() && value2.isNotEmpty() && operator.isNotEmpty()){
                result = when (operator) {
                        "+" ->  (value1.toDouble() + value2.toDouble()).toString()
                        "-" ->  (value1.toDouble() - value2.toDouble()).toString()
                        "*" ->  (value1.toDouble() * value2.toDouble()).toString()
                        "/" ->  (value1.toDouble() / value2.toDouble()).toString()
                    else -> ""

                }
            }
        }) {
            Text("=")
        } //linha dos botoes

        Button(modifier = Modifier.padding(5.dp), onClick = {
            value1 = ""
            value2 = ""
            operator = ""
            result = ""

        }) {
            Text("Clear")
        }
        if (result.isNotEmpty()) {
            Text("Resultado: $result", Modifier.padding(vertical = 16.dp))
        }
        Text("a operação selecionada foi: $operator", Modifier.padding(vertical = 16.dp))


}// a gente vai terminar fazer a tela da calculadora mais pra frente nesse tutorial...

} //fecha fun CalculatoraScreen() {

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    CalculatoraScreen()
}








