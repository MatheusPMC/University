package com.university.core.service

import com.university.core.mapper.DisciplineConverter
import com.university.core.model.Discipline
import com.university.core.port.DisciplineRepositoryPort
import com.university.core.port.DisciplineServicePort
import com.university.entry.dto.DisciplineDto
import io.micronaut.context.annotation.Prototype

@Prototype
class DisciplineService (
    private val disciplineRepositoryPort: DisciplineRepositoryPort
        ): DisciplineServicePort {

    override fun getAllDiscipline(): List<DisciplineDto> {
        var repository = disciplineRepositoryPort.getAllDisciplineRepository()
        return DisciplineConverter.diciplineListToDiciplineDtoList(repository)
    }

    override fun getOneDiscipline(code: String): DisciplineDto? {
        var repository = disciplineRepositoryPort.getOneDisciplineRepository(code)
        return DisciplineConverter.diciplineToDiciplineDto(repository!!)
    }

    override fun postDiscipline(discipline: Discipline): DisciplineDto {
        var repository = disciplineRepositoryPort.postDisciplineRepository(DisciplineConverter.diciplineToDiciplineEntity(discipline))
        return DisciplineConverter.diciplineToDiciplineDto(repository)
    }

    override fun putDiscipline(discipline: Discipline): DisciplineDto {
        var repository = disciplineRepositoryPort.putDisciplineRepository(DisciplineConverter.diciplineToDiciplineEntity(discipline))
        return DisciplineConverter.diciplineToDiciplineDto(repository)
    }

    override fun deleteDiscipline(code: String): String {
        var repository = disciplineRepositoryPort.delDisciplineRepository(code)
        return repository
    }
}