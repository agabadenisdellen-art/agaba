package com.example.agabadenisclinic

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.agabadenisclinic.ui.theme.AgabaDenisClinicTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

// Application class to provide the database and scope
class ClinicApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ClinicDatabase.getDatabase(this, applicationScope) }
    val dao by lazy { database.clinicDao() }
}

class MainActivity : ComponentActivity() {

    private val clinicViewModel: ClinicViewModel by viewModels {
        ClinicViewModelFactory((application as ClinicApplication).dao)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgabaDenisClinicTheme { // Using the correct theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // AppScreen will be the main UI container
                    AppScreen(viewModel = clinicViewModel)
                }
            }
        }
    }
}