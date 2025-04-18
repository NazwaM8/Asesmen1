package com.nazwamursyidan0077.asesmen1.ui.screen

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nazwamursyidan0077.asesmen1.R
import com.nazwamursyidan0077.asesmen1.navigation.Screen
import com.nazwamursyidan0077.asesmen1.ui.theme.Asesmen1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {

    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(
                            imageVector = Icons.Outlined.MoreVert,
                            contentDescription = stringResource(R.string.menu),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.about_app)) },
                            leadingIcon = {Icon(Icons.Outlined.Info, contentDescription = null)},
                            onClick = {
                                expanded = false
                                navController.navigate(Screen.About.route)
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.about_me)) },
                            leadingIcon = {Icon(Icons.Outlined.Person, contentDescription = null)},
                            onClick = {
                                expanded = false
                                navController.navigate(Screen.Me.route)
                            }
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        ScreenContent(Modifier.padding(innerPadding), navController)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent(modifier: Modifier = Modifier, navController: NavHostController) {
    var name by rememberSaveable { mutableStateOf("") }
    val item = listOf("PS2", "PS3", "PS4", "PS5")
    var selectedPS by rememberSaveable { mutableStateOf(item[0]) }
    var isExpanded by remember { mutableStateOf(false) }
    var hours by rememberSaveable { mutableStateOf("") }

    var errorName by remember { mutableStateOf(false) }
    var errorHours by remember { mutableStateOf(false) }

    var showReceipt by rememberSaveable { mutableStateOf(false) }
    var receiptName by rememberSaveable { mutableStateOf("") }
    var receiptPS by rememberSaveable { mutableStateOf("") }
    var receiptHours by rememberSaveable { mutableIntStateOf(0) }

    val context = LocalContext.current

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.rental_intro),
            style = MaterialTheme.typography.bodyLarge,
            modifier =  Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = stringResource(R.string.customer_name)) },
            trailingIcon = {IconPicker(errorName)},
            supportingText = { ErrorHint(errorName) },
            isError = errorName,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedButton(
            onClick = {
                navController.navigate(Screen.ListGame.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.list_game)
            )
        }

        Column (
            modifier = Modifier.fillMaxWidth()
        ) {
            ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange = { isExpanded = !isExpanded}
            ) {
                OutlinedTextField(
                    value = selectedPS,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(text = stringResource(R.string.ps_type)) },
                    trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(isExpanded)},
                    modifier = Modifier
                        .menuAnchor(MenuAnchorType.PrimaryNotEditable, enabled = true)
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = {isExpanded = false}, modifier = Modifier.fillMaxWidth()) {
                    item.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            text = { Text(text = text) },
                            onClick = {
                                selectedPS = item[index]
                                isExpanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }

            OutlinedTextField(
                value = hours,
                onValueChange = { hours = it },
                label = { Text(text = stringResource(R.string.total_hours)) },
                trailingIcon = {IconPicker(errorHours)},
                supportingText = { ErrorHint(errorHours) },
                isError = errorHours,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            )
        }
        Button(
            onClick = {
                errorName = (name == "")
                errorHours = (hours == "" || hours == "0")
                if (errorName || errorHours) return@Button

                if (name.isNotEmpty() && hours.isNotEmpty()) {
                    receiptName = name
                    receiptPS = selectedPS
                    receiptHours = hours.toIntOrNull() ?: 0
                    showReceipt = true
                }
            },
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.print_receipt)
            )
        }

        if (showReceipt) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.receipt),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    HorizontalDivider()
                    Text(
                        text = stringResource(R.string.customer_name) + ": $receiptName",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = stringResource(R.string.ps_type) + ": $receiptPS",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = stringResource(R.string.total_hours) + ": $receiptHours",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    HorizontalDivider()
                    Text(
                        text = stringResource(R.string.total_price) + "${totalPrice(receiptPS, receiptHours)}",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Button(
                onClick = {
                    shareData(
                        context = context,
                        message = context.getString(R.string.share_template, name, selectedPS, hours, totalPrice(receiptPS, receiptHours))
                    )
                },
                modifier = Modifier.padding(top = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(text = stringResource(R.string.share_receipt))
            }
        }
    }
}

fun totalPrice(selectedPS: String, totalHours: Int): Int {
    val pricePerHours = when (selectedPS) {
        "PS2" -> 2000
        "PS3" -> 4000
        "PS4" -> 7000
        "PS5" -> 10000
        else -> 0
    }
    return pricePerHours * totalHours
}

private fun shareData(context: Context, message: String) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, message)
    }
    if (shareIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(shareIntent)
    }
}


@Composable
fun IconPicker(isError: Boolean) {
    if (isError) {
        Icon(imageVector = Icons.Filled.Warning, contentDescription = null)
    } else {
        Text(text = "")
    }
}

@Composable
fun ErrorHint(isError: Boolean) {
    if (isError) {
        Text(text = stringResource(R.string.input_invalid))
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    Asesmen1Theme {
        MainScreen(rememberNavController())
    }
}