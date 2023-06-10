object Version {
    const val androidXCoreKTX = "1.8.10"
    const val androidXLifecycleRuntimeKTX = "2.3.1"
    const val composeActivity = "1.3.1"
    const val composeUI = "1.4.3"
    const val composeLifecycleViewModel = "2.6.1"
    const val composeNavigation = "2.5.3"
    const val composeIcons = "1.4.3"
    const val coroutinesCore = "1.6.4"
    const val retrofitCore = "2.9.0"
    const val okhttp3LoggingInterceptor = "4.10.0"
    const val daggerHiltCore = "2.45"
    const val daggerHiltAndroidXCompiler = "1.0.0"
    const val androidXAppCompat = "1.6.1"
    const val testImplementationJunit = "4.13.2"
    const val androidTestImplementationJunit = "1.1.5"
    const val androidTestImplementationEspresso = "3.5.1"
    const val daggerHiltNavigationCompose = "1.0.0"
    const val composeMaterial3 = "1.2.0-alpha02"
    const val coilCore = "2.0.0-rc01"
}

object AndroidX {
    const val coreKTX = "androidx.core:core-ktx:${Version.androidXCoreKTX}"
    const val lifecycleRuntimeKTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.androidXLifecycleRuntimeKTX}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.androidXAppCompat}"
}

object Coil {
    const val core = "io.coil-kt:coil-compose:${Version.coilCore}"
}

object Compose {
    const val activity = "androidx.activity:activity-compose:${Version.composeActivity}"
    const val ui = "androidx.compose.ui:ui:${Version.composeUI}"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.composeUI}"
    const val material = "androidx.compose.material:material:${Version.composeUI}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.composeLifecycleViewModel}"
    const val navigation = "androidx.navigation:navigation-compose:${Version.composeNavigation}"
    const val icons = "androidx.compose.material:material-icons-extended:${Version.composeIcons}"
    const val material3 = "androidx.compose.material3:material3:${Version.composeIcons}"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutinesCore}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesCore}"
}

object Retrofit {
    const val core = "com.squareup.retrofit2:retrofit:${Version.retrofitCore}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofitCore}"
    const val okhttp3LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3LoggingInterceptor}"
}

object DaggerHilt {
    const val core = "com.google.dagger:hilt-android:${Version.daggerHiltCore}"
    const val compiler = "com.google.dagger:hilt-android-compiler:${Version.daggerHiltCore}"
    const val androidXCompiler = "androidx.hilt:hilt-compiler:${Version.daggerHiltAndroidXCompiler}"
    const val navigationCompose = "androidx.hilt:hilt-navigation-compose:${Version.daggerHiltNavigationCompose}"
}

object TestImplementation {
    const val junit = "junit:junit:${Version.testImplementationJunit}"
}

object AndroidTestImplementation {
    const val junit = "androidx.test.ext:junit:${Version.androidTestImplementationJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.androidTestImplementationEspresso}"
}

