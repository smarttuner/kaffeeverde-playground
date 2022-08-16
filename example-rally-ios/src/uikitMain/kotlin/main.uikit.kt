/*
 * Copyright 2020-2022 JetBrains s.r.o. and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

// Use `xcodegen` first, then `open ./ComposeMinesweeper.xcodeproj` and then Run button in XCode.
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.compose.rally.RallyApp
import kotlinx.cinterop.*
import net.smarttuner.kaffeeverde.application.KVLifecycleHolder
import net.smarttuner.kaffeeverde.application.KVUiKitApplication
import net.smarttuner.kaffeeverde.lifecycle.Lifecycle
import platform.Foundation.*
import platform.UIKit.*


fun main() {
    val args = emptyArray<String>()
    memScoped {
        val argc = args.size + 1
        val argv = (arrayOf("skikoApp") + args).map { it.cstr.ptr }.toCValues()
        autoreleasepool {
            UIApplicationMain(argc, argv, null, NSStringFromClass(SkikoAppDelegate))
        }
    }
}

class SkikoAppDelegate : UIResponder, UIApplicationDelegateProtocol {
    companion object : UIResponderMeta(), UIApplicationDelegateProtocolMeta

    @ObjCObjectBase.OverrideInit
    constructor() : super()

    private var _window: UIWindow? = null
    override fun window() = _window
    override fun setWindow(window: UIWindow?) {
        _window = window
    }

    override fun application(application: UIApplication, didFinishLaunchingWithOptions: Map<Any?, *>?): Boolean {
        window = UIWindow(frame = UIScreen.mainScreen.bounds).apply {

            rootViewController = KVUiKitApplication("MLOG", KVLifecycleHolder()) { lifecycleHolder ->


                Surface(modifier = Modifier.fillMaxSize()) {
                    RallyApp()
                }
                LaunchedEffect(Unit){
                    lifecycleHolder._lifecycle.currentState = Lifecycle.State.CREATED
                    lifecycleHolder._lifecycle.currentState = Lifecycle.State.STARTED
                    lifecycleHolder._lifecycle.currentState = Lifecycle.State.RESUMED

                }
            }
            makeKeyAndVisible()
        }
        return true
    }
}

