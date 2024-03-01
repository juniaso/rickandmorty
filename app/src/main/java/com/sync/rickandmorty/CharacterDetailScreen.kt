package com.sync.rickandmorty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

@Composable
fun CharacterDetailScreen(navController: NavHostController, characterId: Int) {
    val viewModel: MainViewModel = viewModel()

    // Trigger data fetching for the character when CharacterDetailScreen is called
    LaunchedEffect(key1 = characterId) {
        viewModel.fetchCharacterById(characterId)
    }

    // Observe changes in characterDetail LiveData from the ViewModel
    val character by viewModel.characterDetail.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        character?.let { char ->
            // Display character details if character data is available
            CharacterDetails(character = char)
        } ?: Text("Loading character details...", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation buttons
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = {
                    // Ensure characterId is greater than 1 before navigating back
                    if (characterId > 1) navController.navigate("characterDetail/${characterId - 1}")
                },
                enabled = characterId > 1  // Disable "Back" button if on the first character
            ) {
                Text("Back")
            }

            Button(
                onClick = {
                    // Navigate to the Welcome screen and clear back stack
                    navController.navigate("welcome") {
                        popUpTo("welcome") { inclusive = true }
                    }
                }
            ) {
                Text("Home")
            }

            Button(
                onClick = {
                    // Navigate to the next character detail screen
                    navController.navigate("characterDetail/${characterId + 1}")
                }
            ) {
                Text("Next")
            }
        }
    }
}

@Composable
fun CharacterDetails(character: Character) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberAsyncImagePainter(model = character.image),
            contentDescription = "Character image",
            modifier = Modifier
                .size(200.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )
        Text("Name: ${character.name}", style = MaterialTheme.typography.bodyLarge)
        Text("Status: ${character.status}", style = MaterialTheme.typography.bodyLarge)
        Text("Species: ${character.species}", style = MaterialTheme.typography.bodyLarge)
        // Include additional character details as needed
    }
}