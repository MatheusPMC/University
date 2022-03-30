package com.university.core.port

import com.university.core.model.Discipline
import com.university.entry.dto.DisciplineDto

interface DisciplineServicePort {
    fun getOneDiscipline(code: String): DisciplineDto?
    fun getAllDiscipline(): List<DisciplineDto>
    fun postDiscipline(discipline: Discipline): DisciplineDto
    fun putDiscipline(discipline: Discipline): DisciplineDto
    fun deleteDiscipline(code: String): String
}