package com.arman.myapplication.ui.resources

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp
import com.arman.myapplication.R

// Set of Material typography styles to start with

val font = FontFamily(

    Font(R.font.yekan_regular, FontWeight.Medium),
    Font(R.font.yekan_bold, FontWeight.Bold),
    Font(R.font.yekan_black, FontWeight.Black),
    Font(R.font.yekan_light, FontWeight.Light),
    Font(R.font.yekan_extrabold, FontWeight.ExtraBold),
    Font(R.font.yekan_semibold, FontWeight.SemiBold)
)

val Typography = Typography(

    //label

    labelLarge = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        textDirection = TextDirection.Rtl
    ),
    labelMedium = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        textDirection = TextDirection.Rtl
    ),
    labelSmall = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        textDirection = TextDirection.Rtl
    ),

    // body

    bodyLarge = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        textDirection = TextDirection.Rtl
    ),

    bodyMedium = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),
    bodySmall = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),

    //display

    displayLarge = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 57.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),
    displayMedium = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Medium,
        fontSize = 45.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),
    displaySmall = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Light,
        fontSize = 36.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),

    //headline

    headlineLarge = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),
    headlineMedium = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),
    headlineSmall = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Light,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),

    //title

    titleLarge = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),
    titleMedium = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),
    titleSmall = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl
    ),
)