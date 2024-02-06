package com.example.notesappkmm.domain.note

import com.example.notesappkmm.presentation.BabyBlueHex
import com.example.notesappkmm.presentation.LightGreenHex
import com.example.notesappkmm.presentation.RedOrangeHex
import com.example.notesappkmm.presentation.RedPinkHex
import com.example.notesappkmm.presentation.VioletHex
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, LightGreenHex, BabyBlueHex, VioletHex)

        fun generateRandomColor() = colors.random()
    }
}