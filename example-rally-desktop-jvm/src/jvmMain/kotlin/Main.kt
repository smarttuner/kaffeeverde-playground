import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.example.compose.rally.RallyApp
import net.smarttuner.kaffeeverde.application.KVComposeWindow
import net.smarttuner.kaffeeverde.application.KVLifecycleWindowHolder
import net.smarttuner.kaffeeverde.lifecycle.Lifecycle

data class WindowInfo(val windowName: String, val windowState: WindowState)

@OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class)
fun main() {
    application {
        var initialized by remember { mutableStateOf(false) }
        var windowCount by remember { mutableStateOf(1) }
        val windowList = remember { SnapshotStateList<WindowInfo>() }

        val lifecycleHolder = remember {
            KVLifecycleWindowHolder()
        }

        // Add initial window
        if (!initialized) {
            windowList.add(WindowInfo("Compose - Window ${windowCount}", rememberWindowState()))
            initialized = true
        }
        windowList.forEachIndexed { i, window ->
            KVComposeWindow(
                onCloseRequest = {
                    windowList.removeAt(i)
                },
                state = windowList[i].windowState,
                title = windowList[i].windowName,
                lifecycleHolder = lifecycleHolder
            ) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RallyApp()
                }
            }
        }

        LaunchedEffect(Unit){
            lifecycleHolder.lifecycle.currentState = Lifecycle.State.CREATED
            lifecycleHolder.lifecycle.currentState = Lifecycle.State.STARTED
            lifecycleHolder.lifecycle.currentState = Lifecycle.State.RESUMED
        }

    }
}
