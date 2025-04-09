This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.<br/>

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:<br/>
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.<br/>
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,<br/>
    `iosMain` would be the right folder for such calls.<br/>

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.<br/>


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…#   c m p S m t h <br/>
 
 #   W e a t h e r C m p <br/>
 
 weatherapi.com<br/>

source Phillip lackner https://github.com/philipplackner/WeatherApp
