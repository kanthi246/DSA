package com.kanthi.dsa.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kanthi.dsa.domain.model.User
import com.kanthi.dsa.presenter.navigation.UserNavigation
import com.kanthi.dsa.presenter.theme.DSATheme
import com.kanthi.dsa.presenter.userscreen.UserCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
/** Android entry point that hosts the Compose user screens. */
class MainActivity : ComponentActivity() {
    /** Creates the themed navigation UI when the activity starts. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DSATheme {
                UserNavigation()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
/** Shows a sample user card in Android Studio's Compose preview. */
fun UserCardPreview() {
    DSATheme {
        UserCard(
            user = User(
                id = 1,
                name = "Kanthi",
                email = "kanthi@gmail.com",
                phone = "9492289246"
            ),
            onClick = {}
        )
    }
}
