package com.zms.sensdoor.ui.setup

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Setup() {
    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            Text(
                text = "Connect to your control center",
            )
        }
    }
}

//@Composable
//fun TextField(
//    textFieldValue: String,
//    onTextFieldValueChange: (String) -> Unit,
//    maxLines: Int = 1,
//    hintText: String,
//    keyboardOptions: KeyboardOptions = KeyboardOptions(
//        keyboardType = KeyboardType.Text,
//        imeAction = ImeAction.Search
//    ),
//    keyboardActions: KeyboardActions = KeyboardActions.Default,
//    actionIcon: ImageVector,
//    onActionClick: () -> Unit
//) {
//    Surface(
//        shadowElevation = 4.dp,
//        shape = RoundedCornerShape(15.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(
//                    Gray70,
////                    when {
////                        isSystemInDarkTheme() -> Gray70
////                        else -> Gray30
////                    },
//                    RoundedCornerShape(15.dp)
//                ),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            BasicTextField(
//                value = textFieldValue,
//                onValueChange = { onTextFieldValueChange(it) },
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(start = 16.dp, end = 8.dp),
//                maxLines = maxLines,
//                keyboardOptions = keyboardOptions,
//                keyboardActions = keyboardActions,
//                cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
//                textStyle = TextStyle(
//                    color = MaterialTheme.colorScheme.onBackground,
//                    fontFamily = museoRegular,
//                    fontSize = 16.sp
//                ),
//                decorationBox = { innerTextField ->
//                    Box {
//                        if (textFieldValue.isEmpty()) {
//                            Text(
//                                text = hintText,
//                                color = MaterialTheme.colorScheme.onBackground,
//                                modifier = Modifier
//                                    .alpha(0.5f),
//                                fontFamily = museoRegular
//                            )
//                        }
//                        innerTextField()
//                    }
//                }
//
//            )
//            Column(
//                modifier = Modifier
//                    .padding(vertical = 4.dp, horizontal = 5.dp)
//                    .size(40.dp)
//                    .background(MaterialTheme.colorScheme.background, RoundedCornerShape(12.dp))
//                    .clickable {
//                        onActionClick()
//                    },
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Icon(
//                    imageVector = actionIcon,
//                    contentDescription = "",
//                    modifier = Modifier
//                        .size(24.dp)
//                        .align(Alignment.CenterHorizontally)
//                )
//            }
//        }
//    }
//}

@Composable
fun Button() {
    
}