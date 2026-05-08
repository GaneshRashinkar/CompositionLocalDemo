package com.ganeshrashinkar.compositionlocaldemo

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ganeshrashinkar.compositionlocaldemo.ui.theme.HostGrotestMedium
import com.ganeshrashinkar.compositionlocaldemo.ui.theme.HostGrotestRegular
import com.ganeshrashinkar.compositionlocaldemo.ui.theme.HostGrotestSemiBold
import com.ganeshrashinkar.compositionlocaldemo.ui.theme.TextPrimary
import com.ganeshrashinkar.compositionlocaldemo.ui.theme.TextSecondary

data class LocalColor(
    val Bg: Color=Color(0xfff3f5f6),
    val Surface:Color=Color(0xffffffff),
    val SurfaceLower:Color=Color(0xffe1e7ea),
    val Primary:Color=Color(0xff8f36fd),
    val OnPrimary:Color=Color(0xffffffff),
    val TextPrimary:Color=Color(0xff071121),
    val TextSecondary:Color=Color(0xff546175),
    val Overlay:Color=Color(0xff071121)
    )

val LocalColors = compositionLocalOf{LocalColor()}

data class LocalSize(
    val title: Dp=24.dp,
    val body: Dp=16.dp,
    val status: Dp=20.dp,
    val label: Dp=12.dp,
    val padding: Dp=16.dp,
    val gapVertical1: Dp=16.dp,
    val gapVertical2: Dp=4.dp,
    val gapHorizontal: Dp=12.dp,
    val avatar: Dp=56.dp,
    val btn: Dp=42.dp,
)

val LocalSizes = compositionLocalOf { LocalSize() }


data class LocalTypography(
    val title: TextStyle = TextStyle(
        fontFamily = HostGrotestSemiBold,
        fontSize = 24.sp,
        color = TextPrimary
    ),
    val status: TextStyle = TextStyle(
        fontFamily = HostGrotestSemiBold,
        fontSize = 20.sp,
        color = TextPrimary,
    ),
    val button: TextStyle = TextStyle(
        fontFamily = HostGrotestSemiBold,
    ),
    val body: TextStyle = TextStyle(
        fontFamily = HostGrotestRegular,
        fontSize = 16.sp,
        color = TextSecondary,
    ),
    val label: TextStyle = TextStyle(
        fontFamily = HostGrotestMedium,
        fontSize = 12.sp,
        color = TextSecondary,
    ),
    )


val LocalTypographys = compositionLocalOf { LocalTypography() }

object LocalCompositions{
    val compactSize: LocalSize = LocalSize(
         title=24.dp,
     body=16.dp,
     status=20.dp,
     label=12.dp,
     padding=16.dp,
     gapVertical1=16.dp,
     gapVertical2=4.dp,
     gapHorizontal=12.dp,
     avatar=56.dp,
     btn=42.dp,
    )

    val comfortableSize: LocalSize = LocalSize(
        title=26.dp,
        body=17.dp,
        status=24.dp,
        label=12.dp,
        padding=20.dp,
        gapVertical1=20.dp,
        gapVertical2=4.dp,
        gapHorizontal=16.dp,
        avatar=64.dp,
        btn=44.dp,
    )
    val expandedSize: LocalSize = LocalSize(
        title=28.dp,
        body=18.dp,
        status=26.dp,
        label=14.dp,
        padding=24.dp,
        gapVertical1=20.dp,
        gapVertical2=6.dp,
        gapHorizontal=20.dp,
        avatar=72.dp,
        btn=48.dp,
    )

    val comfortableTypography : LocalTypography = LocalTypography(
     title = TextStyle(
        fontFamily = HostGrotestSemiBold,
        fontSize = 26.sp,
        color = TextPrimary
    ),
     status = TextStyle(
        fontFamily = HostGrotestSemiBold,
        fontSize = 24.sp,
        color = TextPrimary,
    ),
     button= TextStyle(
        fontFamily = HostGrotestSemiBold,
    ),
     body = TextStyle(
        fontFamily = HostGrotestRegular,
        fontSize = 17.sp,
        color = TextSecondary,
    ),
     label = TextStyle(
        fontFamily = HostGrotestMedium,
        fontSize = 12.sp,
        color = TextSecondary,
    ),
    )

    val expandedTypography : LocalTypography = LocalTypography(
        title = TextStyle(
            fontFamily = HostGrotestSemiBold,
            fontSize = 28.sp,
            color = TextPrimary
        ),
        status = TextStyle(
            fontFamily = HostGrotestSemiBold,
            fontSize = 26.sp,
            color = TextPrimary,
        ),
        button= TextStyle(
            fontFamily = HostGrotestSemiBold,

        ),
        body = TextStyle(
            fontFamily = HostGrotestRegular,
            fontSize = 18.sp,
            color = TextSecondary,
        ),
        label = TextStyle(
            fontFamily = HostGrotestMedium,
            fontSize = 14.sp,
            color = TextSecondary,
        ),
    )

}

