package com.example.agabadenisclinic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

// --- Navigation Sealed Class ---
sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object PatientList : Screen("patient_list", "Patients", Icons.Default.List)
    object DoctorList : Screen("doctor_list", "Doctors", Icons.Default.Person)
    object RegisterPatient : Screen("register_patient", "Register", Icons.Default.Add)
}

val bottomNavItems = listOf(
    Screen.PatientList,
    Screen.DoctorList,
    Screen.RegisterPatient
)

// --- Main App Screen with Bottom Navigation ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(viewModel: ClinicViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.PatientList.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.PatientList.route) { PatientListScreen(viewModel) }
            composable(Screen.DoctorList.route) { DoctorListScreen(viewModel) }
            composable(Screen.RegisterPatient.route) { RegisterPatientScreen(viewModel, navController) }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val currentRoute = currentRoute(navController)
        bottomNavItems.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.label) },
                label = { Text(screen.label) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}


// --- Patient List Screen ---
@Composable
fun PatientListScreen(viewModel: ClinicViewModel) {
    val patients by viewModel.allPatients.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text("Patient List", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(bottom = 16.dp))
        }
        if (patients.isEmpty()) {
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(top=32.dp)) {
                    Text("No patients found.")
                    Text("Register a new patient to get started.")
                }
            }
        } else {
            items(patients) { patient ->
                PatientCard(patient)
            }
        }
    }
}

@Composable
fun PatientCard(patient: Patient) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(patient.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("Age: ${patient.age}, Gender: ${patient.gender}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(patient.details)
        }
    }
}

// --- Doctor List Screen ---
@Composable
fun DoctorListScreen(viewModel: ClinicViewModel) {
    val doctors by viewModel.allDoctors.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text("Doctor List", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(bottom = 16.dp))
        }
        if (doctors.isEmpty()) {
            item { Text("No doctors found in the database.") }
        } else {
            items(doctors) { doctor ->
                DoctorCard(doctor)
            }
        }
    }
}

@Composable
fun DoctorCard(doctor: Doctor) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(doctor.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("Specialty: ${doctor.specialty}")
            Text("Experience: ${doctor.experience} years")
        }
    }
}


// --- Register Patient Screen ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPatientScreen(viewModel: ClinicViewModel, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Register New Patient", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("Age") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = gender, onValueChange = { gender = it }, label = { Text("Gender") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = details, onValueChange = { details = it }, label = { Text("Details / Reason for Visit") }, modifier = Modifier.fillMaxWidth().height(120.dp))
        Spacer(modifier = Modifier.height(16.dp))

        if (showError) {
            Text("Name and a valid Age are required.", color = MaterialTheme.colorScheme.error)
        }

        Button(onClick = {
            val patientAge = age.toIntOrNull()
            if (name.isNotBlank() && patientAge != null && patientAge > 0) {
                val newPatient = Patient(name = name, age = patientAge, gender = gender, details = details)
                viewModel.addPatient(newPatient)
                // Navigate back to patient list after registration
                navController.navigate(Screen.PatientList.route) {
                    popUpTo(Screen.PatientList.route) { inclusive = true }
                }
                showError = false
            } else {
                showError = true
            }
        }) {
            Text("Register Patient")
        }
    }
}