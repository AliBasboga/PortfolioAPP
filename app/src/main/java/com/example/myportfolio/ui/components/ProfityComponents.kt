package com.example.myportfolio.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myportfolio.data.model.Project
import com.example.myportfolio.ui.theme.Pink41
import com.example.myportfolio.ui.theme.Pink45

@Preview
@Composable
fun PortfolioCard(modifier: Modifier = Modifier) {

    val portfolioShowState = remember { mutableStateOf(false) }

    Surface (
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(400.dp)
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                PortfolioProfileImage()
                Divider(
                    modifier = modifier
                        .padding(10.dp)
                        .width(250.dp),
                    color = Color.Black,
                    thickness = 0.5.dp
                )
                PortfolioPersonInfo()
                Button(onClick = {
                    portfolioShowState.value = !portfolioShowState.value
                }) {
                    Text(text = "Portfolio",
                        style = MaterialTheme.typography.titleMedium,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Italic
                    )
                }
                PortfolioProjects(isShown = portfolioShowState.value)
            }
        }
    }
}

@Preview
@Composable
fun PortfolioProfileImage(modifier: Modifier = Modifier) {
    Surface (
        modifier = modifier
            .size(150.dp)
            .padding(10.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.Black),
        shadowElevation = 15.dp,
    ) {
        Icon(
            imageVector = Icons.Default.Android,
            contentDescription = "Face",
            modifier = Modifier
                .clip(CircleShape)
                .background(color = Color.White)
        )
    }
}

@Preview
@Composable
private fun PortfolioPersonInfo() {
    Column (
        modifier = Modifier.padding(5.dp)
    ) {
        Text(text = "Ali Başboğa",
            style = MaterialTheme.typography.headlineLarge,
            )

        Text(text = "Android Developer",
            style = MaterialTheme.typography.titleMedium
        )

        Text(text = "@AliBasboga",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
fun PortfolioProjects(modifier: Modifier = Modifier, isShown: Boolean = false)  {
    if (isShown) {
        Box (modifier = modifier
            .fillMaxSize()
            .padding(5.dp)
        ){
            Surface(
                modifier = modifier
                    .padding(5.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                border = BorderStroke(width = 2.dp, color = Color.Black),
                shadowElevation = 5.dp,
            ) {
                PortfolioProjectItems(
                    data = listOf(
                        Project(
                            projectname = "Project 1",
                            projectDescription = "Project 1 Description Yes yes yes okey okey okey"
                        ),
                        Project(
                            projectname = "Project 2",
                            projectDescription = "Project 2 Description yes yes yes okey okey okey "
                        ),
                        Project(
                            projectname = "Project 3",
                            projectDescription = "Project 3 Description yes yes yes okey okey okey"
                        ),
                        Project(
                            projectname = "Project 4",
                            projectDescription = "Project 4 Description yes yes yes okey okey okey"
                        ),
                        Project(
                            projectname = "Project 5",
                            projectDescription = "Project 5 Description yes yes yes okey okey okey"
                        ),
                    )
                )
            }
        }
    }
}

@Composable
fun PortfolioProjectItems(modifier: Modifier = Modifier, data : List<Project>) {
    LazyColumn (modifier = modifier.background(Pink45)) {
        items(data) {item ->
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                //elevation = CardDefaults.cardElevation(10.dp),
                shape = RoundedCornerShape(20.dp),
            ) {
                Row (
                    modifier = Modifier
                        .background(color = Pink41)
                        .padding(10.dp)
                ){
                    PortfolioProfileImage(modifier = modifier.size(100.dp))
                    Column (
                        modifier = Modifier
                            .padding(10.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = item.projectname.toString(),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(text = item.projectDescription.toString(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}