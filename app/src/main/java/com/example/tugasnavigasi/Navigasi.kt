package com.example.tugasnavigasi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasnavigasi.view.Formulir
import com.example.tugasnavigasi.view.HalamanAwal
import com.example.tugasnavigasi.view.ListDaftar

object Routes {
    const val HALAMAN_AWAL = "HalamanAwal"
    const val LIST_DAFTAR = "ListDaftar"
    const val FORMULIR = "Formulir"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        // 1. Ubah startDestination ke HALAMAN_AWAL
        startDestination = Routes.HALAMAN_AWAL
    ) {
        // 2. Pastikan pemanggilan composable untuk HalamanAwal sudah benar
        composable(Routes.HALAMAN_AWAL) {
            HalamanAwal(navController = navController)
        }
        composable(Routes.LIST_DAFTAR) {
            ListDaftar(navController = navController)
        }
        composable(Routes.FORMULIR) {
            Formulir(navController = navController)
        }
    }
}