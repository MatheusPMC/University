package com.university.entry.controller

import com.university.core.mapper.DisciplineConverter
import com.university.core.port.DisciplineServicePort
import com.university.entry.dto.DisciplineDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import java.time.LocalDateTime

@Controller
class DisciplineController(
    private val disciplineServicePort: DisciplineServicePort
) {


    @Get
    fun getAllDiscipline(): HttpResponse<*> {
        var result = disciplineServicePort.getAllDiscipline()
        return HttpResponse.ok(result)
    }

    @Get("/{code}")
    fun getFindOneDiscipline(@PathVariable code: String): HttpResponse<*> {
        var result = disciplineServicePort.getOneDiscipline(code)
        return HttpResponse.ok(result)
    }

    @Post
    fun postDiscipline(@Body disciplineDto: DisciplineDto): HttpResponse<*> {
        disciplineDto.createdAt = LocalDateTime.now()
        val result = disciplineServicePort.postDiscipline(DisciplineConverter.diciplineDtoToDicipline(disciplineDto))
        return HttpResponse.created(result)
    }

    @Put
    fun updateDiscipline(@Body disciplineDto: DisciplineDto): HttpResponse<*> {
        disciplineDto.updatedAt = LocalDateTime.now()
        val result = disciplineServicePort.putDiscipline(DisciplineConverter.diciplineDtoToDicipline(disciplineDto))
        return HttpResponse.ok(result)
    }

    @Delete("/{code}")
    fun deleteDiscipline(@PathVariable code: String): HttpResponse<*> {
        val result = disciplineServicePort.deleteDiscipline(code)
        return HttpResponse.ok(result)
    }
}