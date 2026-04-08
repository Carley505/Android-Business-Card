package com.example.businesscard


import android.os.Bundle
import android.widget.Filter
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
//                    TopSection(
//                        name = "Jennifer Doe",
//                        position = "Android Developer Extraodinaire",
//                        imageDrawable = painterResource(R.drawable.android_logo),
//                        modifier = Modifier.background(Color(0xFFd5f7cb))
//                    )
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(Modifier.fillMaxWidth().background(Color(0xFFd5f7cb))) {
        Row(Modifier.weight(1f).fillMaxWidth()) {
            TopSection(
                name = "Callistus Ngeywa",
                position = "Super Android Developer Builder",
                imageDrawable = painterResource(R.drawable.android_logo)
            )
        }
        Row(Modifier.weight(1f)) {
            BottomSection()
        }
    }
}

@Composable
fun TopSection(
    name: String, position: String,
    imageDrawable: Painter, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(bottom = 16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imageDrawable,
            contentDescription = "Android logo",
            modifier = Modifier
                .background(Color(0xFF043161))
                .height(100.dp)
                .width(100.dp)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Text(
            text = position,
            color = Color(0xFF0a7506),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BottomSection() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        BottomItem(
            icon = painterResource(R.drawable.baseline_phone_white_48),
            content = "+254 759 319 378"
        )
        BottomItem(
            icon = painterResource(R.drawable.baseline_share_black_48),
            content = "@AndroidDev"
        )
        BottomItem(
            icon = painterResource(R.drawable.baseline_mail_black_48),
            content = "john.doe@android.com"
        )
    }
}

@Composable
fun BottomItem(icon: Painter, content: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 66.dp, top = 8.dp, bottom = 8.dp, end = 66.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = "phone",
            colorFilter = ColorFilter.tint(color = Color(0xFF0a7506)),
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )
        Text(
            text = content
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewApp() {
    BusinessCardTheme() {
//        TopSection(
//            name = "Jennifer Doe",
//            position = "Android Developer Extraodinaire",
//            imageDrawable = painterResource(R.drawable.android_logo)
//        )
        BusinessCardApp()
    }
}

