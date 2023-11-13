package com.example.datastructures

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.datastructures.model.Lesson
import com.example.datastructures.model.LessonsRepository.lessons
import com.example.datastructures.ui.theme.DataStructuresTheme

@Composable
fun LessonScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ){
        LessonList(contentPadding = it)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier : Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = "30 Days of Learning",
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier.padding()
    )
}

@Composable
fun LessonList(contentPadding: PaddingValues){
    LazyColumn(contentPadding = contentPadding) {
        items(lessons){
            LessonCard(it)
        }
    }
}

@Composable
fun LessonCard(
    lesson: Lesson,
    modifier : Modifier = Modifier
){
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .clickable(
                enabled = true,
                onClick = {expanded = !expanded}
            )
    ){
        Column(modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            )
            .padding(16.dp)
        ) {
            Text(text = "Day ${lesson.day}")
            LessonTitle(lesson.title)
            LessonImage(lesson.image)
            if (expanded){
                LessonDescription(lesson.description)
            }
        }
    }
}

@Composable
fun LessonDescription(
    @StringRes description: Int
) {
    Text(
        text = stringResource(
            id = description
        ),
        modifier = Modifier.padding(top = 4.dp)
    )
}

@Composable
fun LessonTitle(
    @StringRes title: Int
) {
    Text(
        text = stringResource(id = title),
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Composable
fun LessonImage(
    @DrawableRes image: Int
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp)
            .padding(bottom = 4.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun LessonPreview(){
    DataStructuresTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            LessonScreen()
        }
    }
}
