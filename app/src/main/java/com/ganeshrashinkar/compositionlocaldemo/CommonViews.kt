package com.ganeshrashinkar.compositionlocaldemo

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ganeshrashinkar.compositionlocaldemo.ui.theme.CompositionLocalDemoTheme
import com.ganeshrashinkar.compositionlocaldemo.ui.theme.HostGrotestSemiBold

@Composable
fun ViewPagerButton(
    text: String,
    isSelected: Boolean,
    onClick:()-> Unit
){

    Button(onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if(isSelected) LocalColors.current.Surface
            else Color.Transparent
        ),
        shape = CircleShape.copy(CornerSize(8.dp)),
        modifier = Modifier.wrapContentWidth()
        ) {
        Text(text,
            color =if(isSelected) LocalColors.current.TextPrimary
            else LocalColors.current.TextSecondary,
            fontFamily = HostGrotestSemiBold,
            fontSize = 12.sp,
            modifier = Modifier.wrapContentWidth()
            )
    }
}

@Preview
@Composable
private fun ViewPagerButtonPreview() {
    CompositionLocalDemoTheme {
        ViewPagerButton(
            "Compact",
            isSelected = true,
            {}
            )
    }
}


enum class ViewType{
    Compact,
    Comfortable,
    Expanded
}