package com.example.myinstagramapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * First class executed when application runs.
 * (Declared on AndroidManifest, inside of application in label "name")
 */

@HiltAndroidApp //DAGGER HILT DECLARATION
class JetpackComposeApp : Application() {
}