package com.university.entry.dto

import java.time.LocalDateTime

data class DisciplineDto (
    var name: String,
    var code: String,
    var time: String,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)