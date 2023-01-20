package com.vipulasri.jetinstagram.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.ui.components.*


@Composable
fun Profile() {
    Scaffold(
        topBar = { ProfileToolbar() }) {
        val posts by PostsRepository.posts
        val stories by StoriesRepository.observeStories()

        Column {
            Row(modifier = Modifier.padding(end = 16.dp)) {
                ProfileDescription()

                ProfileImage(imageUrl = stories.first().image)

            }
            ProfileButtons()
            LazyColumn {
                item {
                    StoriesSection(stories)
                    Divider()
                }
            }
            ProfileTopBar()
            RecommendationsGrid()
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
fun ProfileDescription() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .width(260.dp)
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
                    "kate spade new york",
            fontSize = 13.sp
        )
        Text(
            text = "www.katespade.com/instagram\n" +
                    "            ",
            color = Color.Blue,
            fontSize = 13.sp
        )
        Spacer(modifier = Modifier)
        Row(modifier = Modifier) {
            Text(
                text = "2.5m ",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Text(
                text = "Followers  ",
                fontSize = 13.sp
            )
            Text(
                text = "1600 ",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Text(
                text = "Following",
                fontSize = 13.sp
            )
        }
        Row(modifier = Modifier) {
            Text(
                text = "Followed by ",
                color = Color.LightGray,
                fontSize = 13.sp
            )
            Text(
                text = "astridddzx ",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Text(
                text = "and ",
                color = Color.LightGray,
                fontSize = 13.sp
            )
            Text(
                text = "keysik",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
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

@Composable
fun ProfileButtons() {
    Column() {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Button(
                modifier = Modifier.width(180.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            ) {
                Text(
                    text = "Follow",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                modifier = Modifier.width(180.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            ) {
                Text(
                    text = "Message",
                )
            }
        }
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Button(
                modifier = Modifier.width(180.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            ) {
                Text(
                    text = "Email",
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                modifier = Modifier.width(180.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            ) {
                Text(
                    text = "Browse",
                )
            }
        }
    }
}

@Composable
fun ProfileTopBar(
    ) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        ) {
            Text(text = "Grid")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            ) {
            Text(text = "List")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        ) {
            Text(text = "IGTV")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.padding(7.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        ) {
            Text(text = "Shop")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.padding(7.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        ) {
            Text(text = "Tagged")
        }
    }
}

@Composable
fun RecommendationsCard(
    modifier: Modifier = Modifier
) {
    val stories by StoriesRepository.observeStories()

    Card(
        elevation = 12.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource( id = R.drawable.ic_dm),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(100.dp)
            )
            Text(
                text = ("Hello World"),
                style = MaterialTheme.typography.h3.copy(fontSize = 12.sp),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendationsGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),

        modifier = modifier
    ) {
        items(10) {
            RecommendationsCard(modifier = Modifier.padding(16.dp))
        }
    }
}
