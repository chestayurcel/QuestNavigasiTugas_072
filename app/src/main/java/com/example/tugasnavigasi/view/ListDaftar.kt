package com.example.tugasnavigasi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tugasnavigasi.R

@Composable
fun ListDaftar(navController: NavController) {
    val lightPurple = Color(0xFFEAE7FC)
    val midPurple = Color(0xFFDFD1FC)
    val darkPurple = Color(0xFF8E70DC)
    val labelColor = Color(0xFF4A1EAF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(midPurple)
            .padding(top = 53.dp)
    ) {
        // Bagian Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(darkPurple)
                .height(105.dp)
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = "List Daftar Peserta",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        // Bagian Isi (List Data)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InfoCard(
                label = stringResource(id = R.string.nama_lengkap),
                value = "Chesta Yurcel Zebada",
                backgroundColor = lightPurple,
                labelColor = labelColor
            )
            Spacer(modifier = Modifier.height(17.dp))

            InfoCard(
                label = stringResource(id = R.string.jenis_kelamin),
                value = "Laki-laki",
                backgroundColor = lightPurple,
                labelColor = labelColor
            )
            Spacer(modifier = Modifier.height(17.dp))

            InfoCard(
                label = "STATUS PERKAWINAN",
                value = "Lajang",
                backgroundColor = lightPurple,
                labelColor = labelColor
            )
            Spacer(modifier = Modifier.height(17.dp))

            InfoCard(
                label = stringResource(id = R.string.alamat),
                value = "Sleman",
                backgroundColor = lightPurple,
                labelColor = labelColor
            )
            Spacer(modifier = Modifier.height(50.dp))

            // Tombol Navigasi
            CustomButton(text = "Beranda", color = darkPurple) {
                navController.navigate("HalamanAwal")
            }
            Spacer(modifier = Modifier.height(25.dp))

            CustomButton(text = "Formulir Pendaftaran", color = darkPurple) {
                navController.navigate("Formulir")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

// Composable untuk setiap baris informasi
@Composable
fun InfoCard(label: String, value: String, backgroundColor: Color, labelColor: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Text(
                text = label,
                fontSize = 15.sp,
                color = labelColor,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = value,
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Black
            )
        }
    }
}

// Composable untuk tombol custom
@Composable
fun CustomButton(text: String, color: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(text = text, fontSize = 16.sp, color = Color.White)
    }
}