package com.practicum.firstcomposeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practicum.firstcomposeproject.MainActivity.Companion.kuzyakin
import com.practicum.firstcomposeproject.MainActivity.Companion.lukashin

@Composable
fun ContactDetails(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // User pic
        if (contact.imageRes == null) {
            RoundInitials(contact.name.take(1) + contact.familyName.take(1))
        } else {
            Image(
                modifier = Modifier.size(70.dp),
                painter = painterResource(contact.imageRes),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Name & Surname
        Text(
            text = stringResource(R.string.contact_name, contact.name, contact.surname ?: ""),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )

        // Lastname & Star
        Row {
            Text(
                text = contact.familyName,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.width(4.dp))

            if (contact.isFavorite) {
                Image(
                    modifier = Modifier.padding(top = 2.dp),
                    painter = painterResource(android.R.drawable.star_big_on),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // InfoRows
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            InfoRow(label = stringResource(R.string.phone), value = contact.phone)
            InfoRow(label = stringResource(R.string.address), value = contact.address)

            if (!contact.email.isNullOrEmpty()) {
                InfoRow(label = stringResource(R.string.email), value = contact.email)
            }
        }
    }
}

@Composable
fun RoundInitials(initials: String) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(70.dp),
            painter = painterResource(id = R.drawable.circle),
            tint = Color.Gray,
            contentDescription = null,
        )
        Text(
            text = initials,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = label,
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            modifier = Modifier.weight(1f),
            text = value,
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ContactCardPreviewLukashin() {
    ContactDetails(lukashin)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ContactCardPreviewKuzyakin() {
    ContactDetails(kuzyakin)
}