package com.university.infra.entity

import com.university.commons.annotations.NoArg
import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime

@Introspected
@NoArg
data class DisciplineEntity (
    var name: String,
    var code: String,
    var time: String,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)