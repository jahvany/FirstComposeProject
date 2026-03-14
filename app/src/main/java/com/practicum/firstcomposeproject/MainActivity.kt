package com.practicum.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    companion object {
        val lukashin = Contact(
            "Евгений",
            "Андреевич",
            "Лукашин",
            null,
            true,
            "+7 495 495 95 95",
            "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
            "ELukashin@practicum.ru"
        )

        val kuzyakin = Contact(
            "Василий",
            null,
            "Кузякин",
            R.drawable.userpic,
            false,
            "---",
            "Ивановская область, дер. Крутово, д. 4"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactDetails(lukashin)
        }
    }
}

