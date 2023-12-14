package com.zms.sensdoor.ui.setup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zms.sensdoor.ui.theme.Monorale

@Composable
fun Setup(
    navController: NavController
) {
    var text by remember {
        mutableStateOf("")
    }

    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 48.dp)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Connect to your " +
                        "control center",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = Monorale,
                    fontWeight = FontWeight.SemiBold,
                ),
            )
            Spacer(modifier = Modifier.weight(1f))
            TextField(
                textFieldValue = text,
                onTextFieldValueChange = { text = it },
                hintText = "Enter your control center's IP"
            )
            SimpleButton(
                onClick = {
                    navController.navigate("home") {
                        popUpTo("setup") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 48.dp)
            )
        }
    }
}

@Composable
fun TextField(
    textFieldValue: String,
    onTextFieldValueChange: (String) -> Unit,
    maxLines: Int = 1,
    hintText: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Done
    ),
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.surface,
                    RoundedCornerShape(16.dp)
                )
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(16.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = textFieldValue,
                onValueChange = { onTextFieldValueChange(it) },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 8.dp, top = 12.dp, bottom = 12.dp),
                maxLines = maxLines,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground),
                decorationBox = { innerTextField ->
                    Box {
                        if (textFieldValue.isEmpty()) {
                            Text(
                                text = hintText,
                                color = MaterialTheme.colorScheme.outline,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        innerTextField()
                    }
                }

            )
        }
    }
}

@Composable
fun SimpleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
    ) {
        Text(
            text = "Connect",
            fontSize = 20.sp,
            style = TextStyle(
                color = MaterialTheme.colorScheme.onPrimary,
                fontFamily = Monorale,
                fontWeight = FontWeight.SemiBold,
            ),
        )
    }
}