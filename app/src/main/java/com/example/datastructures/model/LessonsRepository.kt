package com.example.datastructures.model

import com.example.datastructures.R

object LessonsRepository {
    val lessons = listOf(
        Lesson(
            R.string.introduction,
            R.string.importance_in_programming,
            R.drawable.lesson_1
        ),
        Lesson(
            R.string.big_o_notation,
            R.string.understanding_time_and_space_complexties,
            R.drawable.lesson_2
        ),
        Lesson(
            R.string.arrays_and_strings,
            R.string.basic_operations_and_manipulations,
            R.drawable.lesson_3
        ),
        Lesson(
            R.string.linked_lists,
            R.string.simple_linked_lists_doubled_linked_lists_and_circular_linked_lists,
            R.drawable.lesson_4
        ),
        Lesson(
            R.string.stacks_and_queues,
            R.string.implementations_and_use_cases,
            R.drawable.lesson_5
        )
    )
}