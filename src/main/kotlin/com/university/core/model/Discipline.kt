package com.university.core.model

import java.time.LocalDateTime

data class Discipline (
    var name: String,
    var code: String,
    var time: String,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)