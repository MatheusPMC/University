package com.university.core.mapper

import com.university.core.model.Discipline
import com.university.entry.dto.DisciplineDto
import com.university.infra.entity.DisciplineEntity

class DisciplineConverter {
    companion object {

        fun diciplineDtoToDicipline(disciplineDto: DisciplineDto) : Discipline {
            return Discipline(
                disciplineDto.name,
                disciplineDto.code,
                disciplineDto.time,
                disciplineDto?.createdAt,
                disciplineDto?.updatedAt
            )
        }

        fun diciplineToDiciplineEntity(discipline: Discipline) : DisciplineEntity {
            return DisciplineEntity(
                discipline.name,
                discipline.code,
                discipline.time,
                discipline?.createdAt,
                discipline?.updatedAt
            )
        }

        fun diciplineEntityToDicipline(disciplineEntity: DisciplineEntity?) : Discipline {
            return Discipline(
                disciplineEntity!!.name,
                disciplineEntity.code,
                disciplineEntity.time,
                disciplineEntity?.createdAt,
                disciplineEntity?.updatedAt
            )
        }

        fun diciplineEntityListToDiciplineList(disciplineEntity: List<DisciplineEntity>) : List<Discipline> {
            return disciplineEntity.map { Discipline(it.name, it.code, it.time, it?.createdAt, it?.updatedAt) }
        }

        fun diciplineToDiciplineDto(discipline: Discipline) : DisciplineDto {
            return DisciplineDto(
                discipline.name,
                discipline.code,
                discipline.time,
                discipline?.createdAt,
                discipline?.updatedAt
            )
        }

        fun diciplineListToDiciplineDtoList(discipline: List<Discipline?>): List<DisciplineDto> {
            return discipline.map { DisciplineDto(it!!.name, it.code, it.time, it?.createdAt, it?.updatedAt)}
        }


    }
}