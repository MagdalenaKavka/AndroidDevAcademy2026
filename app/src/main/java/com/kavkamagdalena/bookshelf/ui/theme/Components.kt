package com.kavkamagdalena.bookshelf.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TitleText(text: String = "Title") {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF50305EL)
    )
}

@Preview(showBackground = true)
@Composable
fun DescriptionText(text: String = "Description") {
    Text(
        text = text,
        fontSize = 14.sp,
        maxLines = 3,
        fontStyle = FontStyle.Italic
    )
}

@Preview(showBackground = true)
@Composable
fun CustomButton(text: String = "Click",
                 onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        colors =  ButtonDefaults.buttonColors(
            containerColor = Color(0xB04F1B2D),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = text)
    }
}