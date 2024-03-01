# Rick and Morty Character Explorer

## Introduction
This Android app allows users to explore characters from the popular TV show "Rick and Morty," utilizing the Rick and Morty API. Users can navigate through character details, including names, statuses, and images. This project levarages the https://rickandmortyapi.com/ API

## Architecture
The app is built using the Model-View-ViewModel (MVVM) architecture, leveraging LiveData for reactive UI updates. It uses Retrofit for API calls, Coil for image loading, and Jetpack Compose for the UI.

## Contributions
Contributions are welcome! Please feel free to submit pull requests or open issues for any improvements or fixes.


# Build and Run Instructions for the Rick and Morty Project

This guide provides instructions on how to build and run the Rick and Morty Android app, a project showcasing character details from the Rick and Morty API.

## Prerequisites

- Android Studio Arctic Fox 2020.3.1 or newer.
- An Android device or emulator running Android SDK version 21 (Lollipop) or higher.

## Cloning the Repository

1. Open a terminal or command prompt.
2. Clone the Rick and Morty project repository by executing the following command:
   ```bash
   git clone https://github.com/juniaso/rickandmorty.git



## Build and Run Instructions for the Rick and Morty Project
This guide provides instructions on how to build and run the Rick and Morty Android app, a project showcasing character details from the Rick and Morty API.

### Opening the Project in Android Studio
1.	Launch Android Studio.
2.	On the welcome screen, select Open an Existing Project.
3.	Navigate to the directory where you cloned the project, select it, and click OK.

### Configuring the Project
•	The project should automatically use the Gradle wrapper for its configuration. Wait for Android Studio to finish syncing the project.

### Running the Project
1.	After the sync is complete, select a run configuration at the top (usually, your app module).
2.	Connect an Android device to your computer or start an Android emulator.
3.	Click the Run button (a green triangle) or press Shift + F10 to build and run the project.
4.	The app should now launch on your device or emulator, displaying the welcome screen of the Rick and Morty app.

### Navigating the App
•	Tap the "Start" button to view details of the first character.
•	Use the "Next" and "Back" buttons to navigate through character details.
•	Tap the "Home" button at any time to return to the welcome screen.

