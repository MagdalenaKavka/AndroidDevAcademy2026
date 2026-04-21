package com.kavkamagdalena.notes.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun TitleText(text: String = "Naslov", function: () -> Unit = {}) {
    Text(
        text = text,
        fontSize = 21.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        color = Color.Black
    )
}

@Composable
fun AppTitle(text: String = "Naslov") {
    Text(
        text = text,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        color = Color.Black
    )
}

@Preview
@Composable
fun DescriptionText(text: String = "Opis") {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        color = Color.DarkGray
    )
}

@Preview
@Composable
fun CustomButton(text: String = "Click",
                 onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xB4FFFFFF),
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = text)
    }
}