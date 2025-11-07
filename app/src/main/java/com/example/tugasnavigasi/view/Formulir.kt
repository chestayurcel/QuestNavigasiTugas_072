package com.example.tugasnavigasi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tugasnavigasi.R
import com.example.tugasnavigasi.Routes

@Composable
fun Formulir(navController: NavController) {
    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    val jenisKelaminOptions = listOf("Laki-laki", "Perempuan")
    var statusPerkawinan by remember { mutableStateOf("") }
    val statusPerkawinanOptions = listOf("Janda", "Lajang", "Duda") // Menambah opsi
    var alamat by remember { mutableStateOf("") }

    val lightPurple = Color(0xFFB17EEA)
    val darkPurple = Color(0xFF6750A4)
    val backgroundColor = Color(0xFFEAE1FA)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top = 53.dp)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(lightPurple)
                .heightIn(min = 100.dp)
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = "Formulir Pendaftaran",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Card untuk Isi Formulir
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(25.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                // Input Nama Lengkap
                Text(
                    text = "NAMA LENGKAP",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                OutlinedTextField(
                    value = namaLengkap,
                    onValueChange = { namaLengkap = it },
                    label = { Text("Isian nama lengkap") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = darkPurple,
                        unfocusedBorderColor = Color.Black,
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Pilihan Jenis Kelamin
                Text("JENIS KELAMIN", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                Column {
                    jenisKelaminOptions.forEach { option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = (jenisKelamin == option),
                                onClick = { jenisKelamin = option },
                                colors = RadioButtonDefaults.colors(selectedColor = darkPurple)
                            )
                            Text(text = option, modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Pilihan Status Perkawinan
                Text("STATUS PERKAWINAN", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                Column {
                    statusPerkawinanOptions.forEach { option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = (statusPerkawinan == option),
                                onClick = { statusPerkawinan = option },
                                colors = RadioButtonDefaults.colors(selectedColor = darkPurple)
                            )
                            Text(text = option, modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Input Alamat
                Text("ALAMAT", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.padding(bottom = 4.dp))
                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    label = { Text("Alamat") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = darkPurple,
                        unfocusedBorderColor = Color.Black,
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Tombol Submit
                Button(
                    onClick = {
                        navController.navigate(Routes.LIST_DAFTAR) {
                            popUpTo(Routes.HALAMAN_AWAL)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3636C7)),
                ) {
                    Text(
                        stringResource(R.string.submit),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
