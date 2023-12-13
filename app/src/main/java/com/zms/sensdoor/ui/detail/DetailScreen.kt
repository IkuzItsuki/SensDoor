package com.zms.sensdoor.ui.detail

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zms.sensdoor.R
import com.zms.sensdoor.ui.theme.darkGreen
import com.zms.sensdoor.ui.theme.lightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detail() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.round_arrow_forward_ios_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {

                            }
                    )

                },
                title = {
                    Text(text = "Detalj")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        containerColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Status(
                icon = painterResource(R.drawable.ic_door),
                isOpened = true
            )
            Name(
                name = "Entré"
            )
            Alert()
            Schedule(
                onAddClick = {

                }
            )
        }
    }
}

@Composable
fun Status(
    icon: Painter,
    isOpened: Boolean
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 64.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(96.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isOpened) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(lightGreen)
            ) {
                Text(
                    text = "Öppen",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp),
                    color = darkGreen,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colorScheme.errorContainer)
            ) {
                Text(
                    text = "Stängd",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp),
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Name(
    name: String
) {
    ColumnCard {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Namn",
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 1.dp, end = 8.dp)
            )
            Icon(
                painter = painterResource(R.drawable.round_arrow_forward_ios_24),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun Alert(
    notiChecked: Boolean = true,
    alarmChecked: Boolean = false,
    onNotiCheckedChange: (Boolean) -> Unit = {},
    onAlarmCheckedChange: (Boolean) -> Unit = {}
) {
    ColumnCard {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Avisering",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Switch(checked = notiChecked) {
                    onNotiCheckedChange(it)

                }
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Larm",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Switch(checked = alarmChecked) {
                    onAlarmCheckedChange(it)
                }
            }
        }
    }
}

@Composable
fun Schedule(
    onAddClick: () -> Unit
) {
    ColumnCard {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(schedule) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = it.day,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = it.time,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
                Divider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
            }
            item {
                Column(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .clickable {
                            onAddClick()
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(R.drawable.round_add_24),
                        contentDescription = "",
                        modifier = Modifier
                            .size(32.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnCard(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(MaterialTheme.colorScheme.surface)
            .clip(MaterialTheme.shapes.small)
            .border(1.dp, MaterialTheme.colorScheme.outlineVariant, MaterialTheme.shapes.small)
    ) {
        content()
    }
}

@Composable
fun Switch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val background: Color by animateColorAsState(
        targetValue = if (checked) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.outlineVariant
        }
    )

    val padding: Dp by animateDpAsState(
        targetValue = if (checked) 20.dp else 2.dp
    )

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(100))
            .clickable {
                onCheckedChange(checked)
            }
    ) {
        Column(
            modifier = Modifier
                .width(42.dp)
                .height(24.dp)
                .clip(RoundedCornerShape(100))
                .background(background)
        ) {

        }
        Column(
            modifier = Modifier
                .padding(start = padding, top = 2.dp, end = 2.dp, bottom = 2.dp)
                .width(20.dp)
                .height(20.dp)
                .clip(RoundedCornerShape(100))
                .background(MaterialTheme.colorScheme.surface)
        ) {

        }
    }
}

val schedule = listOf(
    ScheduleItem("Måndag", "08:00 - 16:00"),
    ScheduleItem("Tisdag", "08:00 - 16:00"),
)

data class ScheduleItem(
    val day: String,
    val time: String
)