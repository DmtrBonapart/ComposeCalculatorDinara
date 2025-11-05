package com.example.composecalculatordinara

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen() {
    val calculator = remember { CalculatorLogic() }
    val displayValue = remember { mutableStateOf(calculator.getCurrentDisplay()) }

    fun updateDisplay() {
        displayValue.value = calculator.getCurrentDisplay()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Фоновое изображение
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Контент калькулятора
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(150.dp))

            CalculatorDisplay(value = displayValue.value)

            // Первый ряд: Очистка и деление
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                CalculatorButton(
                    symbol = "C",
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFFF9500)
                ) {
                    calculator.clear()
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "CE",
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFFF9500)
                ) {
                    calculator.clearEntry()
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFFF9500)
                ) {
                    calculator.inputOperation("/")
                    updateDisplay()
                }
            }

            // Второй ряд: 7, 8, 9, умножение
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDigit("7")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDigit("8")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDigit("9")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "×",
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFFF9500)
                ) {
                    calculator.inputOperation("*")
                    updateDisplay()
                }
            }

            // Третий ряд: 4, 5, 6, вычитание
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDigit("4")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDigit("5")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDigit("6")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFFF9500)
                ) {
                    calculator.inputOperation("-")
                    updateDisplay()
                }
            }

            // Четвертый ряд: 1, 2, 3, сложение
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDigit("1")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDigit("2")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDigit("3")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFFF9500)
                ) {
                    calculator.inputOperation("+")
                    updateDisplay()
                }
            }

            // Пятый ряд: 0, десятичная дробь, равно
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier.weight(2f)
                ) {
                    calculator.inputDigit("0")
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier.weight(1f)
                ) {
                    calculator.inputDecimal()
                    updateDisplay()
                }
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFFF9500)
                ) {
                    calculator.calculateResult()
                    updateDisplay()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen()
    }
}