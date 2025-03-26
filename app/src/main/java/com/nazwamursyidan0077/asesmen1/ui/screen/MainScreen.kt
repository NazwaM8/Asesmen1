package com.nazwamursyidan0077.asesmen1.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding ->
        ScreenContent(Modifier.padding(innerPadding), navController)
    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier, navController: NavHostController) {
    var name by remember { mutableStateOf("") }


    Column (
        modifier = modifier.fillMaxSize().padding(16.dp),
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
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        RentalCalculator()

        Row (
            modifier = Modifier.padding(top = 16.dp),
        ) {
            OutlinedButton(
                onClick = {
                    navController.navigate(Screen.ListPS2.route)
                },
                modifier = Modifier.padding(top = 4.dp, end = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.list_game) + " PS2"
                )
            }

            OutlinedButton(
                onClick = {

                },
                modifier = Modifier.padding(top = 4.dp, start = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.list_game) + " PS3"
                )
            }
        }

        Row (
            modifier = Modifier.padding(top = 6.dp)
        ) {
            OutlinedButton(
                onClick = {

                },
                modifier = Modifier.padding(top = 4.dp, end = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.list_game) + " PS4"
                )
            }

            OutlinedButton(
                onClick = {

                },
                modifier = Modifier.padding(top = 4.dp, start = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.list_game) + " PS5"
                )
            }
        }

        Button(
            onClick = {

            },
            modifier = Modifier.padding(top = 24.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.print_receipt)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RentalCalculator() {
    val item = listOf("PS2", "PS3", "PS4", "PS5")
    var selectedPS by rememberSaveable { mutableStateOf(item[0]) }
    var isExpanded by remember { mutableStateOf(false) }

    var hours by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
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
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
        )
        Text(
            text = stringResource(R.string.total_price) + totalPrice(selectedPS, hours.toIntOrNull() ?:0)
        )
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



@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    Asesmen1Theme {
        MainScreen(rememberNavController())
    }
}