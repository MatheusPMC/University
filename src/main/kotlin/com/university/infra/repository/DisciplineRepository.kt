package com.university.infra.repository

import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import com.university.core.mapper.DisciplineConverter
import com.university.core.model.Discipline
import com.university.core.port.DisciplineRepositoryPort
import com.university.infra.entity.DisciplineEntity
import io.micronaut.context.annotation.Prototype

@Prototype
class DisciplineRepository (
    private val mongoClient: MongoClient
): DisciplineRepositoryPort {

    override fun getAllDisciplineRepository(): List<Discipline?> {
        var result = getCollection().find().toList()
        return DisciplineConverter.diciplineEntityListToDiciplineList(result)
    }


    override fun getOneDisciplineRepository(code: String): Discipline? {
         var disciplineEntity =  getCollection()
            .find(Filters.eq("code", code)).toList().firstOrNull()
        return DisciplineConverter.diciplineEntityToDicipline(disciplineEntity)
    }


    override fun postDisciplineRepository(disciplineEntity: DisciplineEntity): Discipline {
        getCollection()
            .insertOne(disciplineEntity)
        return DisciplineConverter.diciplineEntityToDicipline(disciplineEntity)
    }

    override fun putDisciplineRepository(disciplineEntity: DisciplineEntity): Discipline {
        getCollection()
            .replaceOne(
                Filters.eq("code", disciplineEntity.code),
                disciplineEntity
            )
        return DisciplineConverter.diciplineEntityToDicipline(disciplineEntity)
    }

    override fun delDisciplineRepository(code: String): String {
           var result = getCollection()
                .deleteOne(
                    Filters.eq("code", code)
                ).deletedCount

        return if (result.toInt() == 1) {
            "Disciplina-apagada-com-sucesso!"
        } else {
            "Disciplina-não-Encontrada"
        }

    }


    private fun getCollection() =
    mongoClient
        .getDatabase("university")
        .getCollection("discipline", DisciplineEntity::class.java)
}