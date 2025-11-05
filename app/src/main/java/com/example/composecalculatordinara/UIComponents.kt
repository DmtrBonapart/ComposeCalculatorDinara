package com.example.composecalculatordinara

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Дизайн дисплея ввода и вывода
@Composable
fun CalculatorDisplay(
    value: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.DarkGray, RoundedCornerShape(10.dp))
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            maxLines = 1
        )
    }
}

// Общий дизайн кнопок
@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF333333),
    textColor: Color = Color.White,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = symbol,
            style = MaterialTheme.typography.headlineMedium,
            color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorDisplayPreview() {
    MaterialTheme {
        CalculatorDisplay(
            value = "123.45",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorButtonPreview() {
    MaterialTheme {
        CalculatorButton(
            symbol = "7",
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp),
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorOperationButtonPreview() {
    MaterialTheme {
        CalculatorButton(
            symbol = "+",
            color = Color(0xFFFF9500),
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp),
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorClearButtonPreview() {
    MaterialTheme {
        CalculatorButton(
            symbol = "C",
            color = Color(0xFFFF9500),
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp),
            onClick = {}
        )
    }
}