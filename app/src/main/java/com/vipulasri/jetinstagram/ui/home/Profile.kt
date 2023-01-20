package com.vipulasri.jetinstagram.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.PostsRepository
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.ui.components.icon
import androidx.compose.material.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.ui.components.diagonalGradientBorder


@Composable
fun Profile() {
    Scaffold(
        topBar = { ProfileToolbar() }) {
        val posts by PostsRepository.posts
        val stories by StoriesRepository.observeStories()

        Column() {
            Row(modifier = Modifier.padding(end = 16.dp)) {
                ProfileDescription()

                    ProfileImage(imageUrl = stories.first().image)

            }
            LazyColumn {
                item {
                    StoriesSection(stories)
                    Divider()
                }
            }
        }
    }
}


@Composable
fun ProfileToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "katespadeny",
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            Icons.Default.MoreVert,
            contentDescription = ""
        )
    }
}

@Composable
fun ProfileDescription(){
    Column(
        modifier = Modifier.padding(16.dp).width(270.dp)
        ) {
        val muted = Color.LightGray
        Text(
            text = "kate spade new york",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "Clothing (Brand)",
            color = muted
        )
        Text(
            text = "quick and curious and playful and strong. \n" +
                    "follow us for a glimpse into the world of \n" +
                    "kate spade new york"
        )
        Text(
            text = "www.katespade.com/instagram\n" +
                    "            ",
            color = Color.Blue
        )
        Spacer(modifier = Modifier)
        Row(modifier = Modifier) {
            Text(
                text = "2.5m ",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Followers  "
            )
            Text(
                text = "1600 ",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Following"
            )
        }
        Row(modifier = Modifier) {
            Text(
                text = "Followed by ",
                color = Color.LightGray
            )
            Text(
                text = "astridddzx ",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "and ",
                color = Color.LightGray
            )
            Text(
                text = "keysik",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ProfileImage(imageUrl: String) {
    val shape = CircleShape
    Box(
        modifier = Modifier
            .diagonalGradientBorder(
                colors = listOf(
                    Color(0xFFd71069),
                    Color(0xFFe25d6a),
                    Color(0xFFe9ad55),
                ),
                shape = shape,
                isFromRight = true
            )
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(6.dp)
                .background(color = Color.LightGray, shape = shape)
                .clip(shape)
        ) {
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

