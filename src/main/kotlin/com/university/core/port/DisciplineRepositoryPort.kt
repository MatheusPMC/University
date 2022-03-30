package com.university.core.port

import com.university.core.model.Discipline
import com.university.infra.entity.DisciplineEntity

interface DisciplineRepositoryPort {
    fun getAllDisciplineRepository(): List<Discipline?>
    fun getOneDisciplineRepository(code: String): Discipline?
    fun postDisciplineRepository(disciplineEntity: DisciplineEntity): Discipline
    fun putDisciplineRepository(disciplineEntity: DisciplineEntity): Discipline
    fun delDisciplineRepository(code: String): String
}