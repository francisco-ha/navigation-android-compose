package com.example.navigationincompose

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
//@Preview(showSystemUi = true)
fun LoginScreen(navigateToHome:() -> Unit){
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "LOGIN SCREEN", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {navigateToHome()}) {
            Text(text = "Navegar a Home")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            val uri = "https://pagina-test.dev/home"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            context.startActivity(intent)
        }) {
            Text(text = "Navegar a Home con deeplink")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
