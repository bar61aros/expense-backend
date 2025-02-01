package com.barbaros.expense.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleNotFoundException(ex: ResourceNotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = HttpStatus.NOT_FOUND.value(),
            message = ex.message ?: "Resource not found"
        )
        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }
}

data class ErrorResponse(
    val status: Int,
    val message: String
)
