[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

![badge-Android](https://img.shields.io/badge/Platform-Android-brightgreen)
![badge-iOS](https://img.shields.io/badge/Platform-iOS-lightgray)
![badge-JVM](https://img.shields.io/badge/Platform-JVM-orange)

# Rally Multiplatform

This is the same app described inside the Jetpack Compose Codelab available here: https://github.com/googlecodelabs/android-compose-codelabs/tree/main/NavigationCodelab

This app has been ported on other platform in order to test some of KaffeeVerde libraries (navigation-*).

## Pre-requisite

This project uses a set of libraries that are not available through popular artifacts repositories.

You can download, build and deploy the artifacts to your Maven Local repo using the instructions available here: https://github.com/smarttuner/kaffeeverde

This project was tested with **Android Studio Electric Eel**.

## How to build and run it

Use these commands in order to build and run this app:
* as an Android app:
  * From Android Studio, select the "example-rally-android" configuration and press the _run_ or _debug_ button
* as a Desktop (JVM) application:.
  * Open a terminal and go to the root path of this project
  * Type `./gradlew run`
  * Hit "Enter"
* as an iOS app (KMP via Kotlin/Native, alpha):
  * Open a terminal and go to the root path of this project
  * Type `./gradlew iosDeployIPhone7Debug`
  * Hit "Enter"


## License

``` 
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.