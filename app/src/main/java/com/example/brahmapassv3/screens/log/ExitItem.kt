
package com.example.brahmapassv3.screens.log

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brahmapassv3.R.drawable as AppIcon
import com.example.brahmapassv3.common.composable.DropdownContextMenu
import com.example.brahmapassv3.common.ext.contextMenu
import com.example.brahmapassv3.model.Exit
import java.lang.StringBuilder
@Composable
@ExperimentalMaterialApi
fun ExitItem(
    exit: Exit,
    options: List<String>,
) {
    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            /*Checkbox(
                checked = exit.completed,
                onCheckedChange = { onCheckChange() },
                modifier = Modifier.padding(8.dp, 0.dp)
            )*/

            Column(modifier = Modifier.weight(1f)) {
                    Text(text = exit.studentId.toString(), style = MaterialTheme.typography.h6)
                    Text(text = exit.time.toDate().toString(), style = MaterialTheme.typography.subtitle1)

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = "Reason: " + exit.reason, fontSize = 14.sp)
                }
            }

            /*DropdownContextMenu(options, Modifier.contextMenu(), onActionClick)*/
        }
    }
}

