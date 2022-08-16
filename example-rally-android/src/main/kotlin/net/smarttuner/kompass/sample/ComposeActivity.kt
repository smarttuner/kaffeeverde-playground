package net.smarttuner.kompass.sample

import android.os.Bundle
import androidx.core.view.WindowCompat
import com.example.compose.rally.RallyApp
import net.smarttuner.kaffeeverde.application.KVActivity
import net.smarttuner.kaffeeverde.application.setContent

class ComposeActivity : KVActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            RallyApp()
        }
    }
}