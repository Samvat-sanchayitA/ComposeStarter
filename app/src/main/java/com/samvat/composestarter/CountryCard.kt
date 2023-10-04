package com.samvat.composestarter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CountryCard(country: Country) {

    Row(modifier = Modifier
        .fillMaxSize()
        .padding(2.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box()
            {
                Image(painter = painterResource(R.drawable.usa_flag), contentDescription = "flag")
            }
            Text(
                text = country.name,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 50.sp
            )
            Text(text = country.capital, textAlign = TextAlign.Center, fontSize = 20.sp)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(2.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = country.officialName, textAlign = TextAlign.Center, fontSize = 30.sp)
            Text(text = country.continent, textAlign = TextAlign.Center, fontSize = 28.sp)
            Row(
                modifier = Modifier.padding(2.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularText(country.currencySymbol)
                Text(
                    text = country.currency,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth(0.4f)
                )
                Column(
                    modifier = Modifier.fillMaxWidth(0.3f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = country.code, textAlign = TextAlign.Center)
                    Text(text = country.suffix, textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@Composable
fun CircularText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .padding(2.dp)
            .drawBehind {
                drawCircle(
                    color = Color.LightGray,
                    radius = this.size.maxDimension
                )
            })
}

@Preview(showBackground = true)
@Composable
fun CountryPreview() {
    CountryCard(country = Country())
}