package com.nazwamursyidan0077.asesmen1.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nazwamursyidan0077.asesmen1.R
import com.nazwamursyidan0077.asesmen1.model.Game
import com.nazwamursyidan0077.asesmen1.ui.theme.Asesmen1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListGameScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                title = {
                    Text(text = stringResource(id = R.string.list_game))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding ->
        ScreenContentList(Modifier.padding(innerPadding))
    }
}

@Composable
fun ScreenContentList(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = stringResource(R.string.list_ps2),
            style = MaterialTheme.typography.headlineSmall
        )
        ListGamePS2()

        Text(
            text = stringResource(R.string.list_ps3),
            style = MaterialTheme.typography.headlineSmall
        )
        ListGamePS3()

        Text(
            text = stringResource(R.string.list_ps4),
            style = MaterialTheme.typography.headlineSmall
        )
        ListGamePS4()

        Text(
            text = stringResource(R.string.list_ps5),
            style = MaterialTheme.typography.headlineSmall
        )
        ListGamePS5()
    }
}

@Composable
fun ListGamePS2() {
    val gameList = listOf(
        Game("God Hand", R.drawable.ps2god),
        Game("God of War 2", R.drawable.ps2gow2),
        Game("Need For Speed: Most Wanted", R.drawable.ps2nfsmw),
        Game("Mortal Kombat: Shaolin Monks", R.drawable.ps2mortal),
        Game("Rumble Racing", R.drawable.ps2rumble),
        Game("Harvest Moon: A Wonderful Life", R.drawable.ps2harvest),
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(gameList) { game ->
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = game.imageResId),
                    contentDescription = game.name,
                    modifier = Modifier.size(150.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text =  game.name,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(150.dp),
                )
            }
        }
    }
}

@Composable
fun ListGamePS3() {
    val gameList = listOf(
        Game("Tom Clancy's: Ghost Recon", R.drawable.ps3tom),
        Game("Tomb Raider", R.drawable.ps3tomb),
        Game("Watch Dogs", R.drawable.ps3watch),
        Game("Prototype 2", R.drawable.ps3prototype2),
        Game("Uncharted 3: Drake's Deception", R.drawable.ps3uncharted),
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(gameList) { game ->
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = game.imageResId),
                    contentDescription = game.name,
                    modifier = Modifier.size(150.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text =  game.name,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(150.dp),
                )
            }
        }
    }
}

@Composable
fun ListGamePS4() {
    val gameList = listOf(
        Game("A Way Out", R.drawable.ps4a),
        Game("Red Dead Redemption 2", R.drawable.ps4rdr2),
        Game("It Takes Two", R.drawable.ps4it),
        Game("GTA V", R.drawable.ps4gtav),
        Game("Marvel Spiderman", R.drawable.ps4spiderman),
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(gameList) { game ->
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = game.imageResId),
                    contentDescription = game.name,
                    modifier = Modifier.size(150.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text =  game.name,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(150.dp),
                )
            }
        }
    }
}

@Composable
fun ListGamePS5() {
    val gameList = listOf(
        Game("Gran Turismo 7", R.drawable.ps5gt7),
        Game("Ghost of Tsushima", R.drawable.ps5got),
        Game("Lies of P", R.drawable.ps5lies),
        Game("Horizon Forbidden West", R.drawable.ps5horizon),
        Game("Resident Evil 4", R.drawable.ps5re4r),
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(gameList) { game ->
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = game.imageResId),
                    contentDescription = game.name,
                    modifier = Modifier.size(150.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text =  game.name,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(150.dp),
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ListGameScreenPreview() {
    Asesmen1Theme {
        ListGameScreen(rememberNavController())
    }
}