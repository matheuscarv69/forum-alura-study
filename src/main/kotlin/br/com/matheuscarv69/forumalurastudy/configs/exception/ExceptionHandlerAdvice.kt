package br.com.matheuscarv69.forumalurastudy.configs.exception

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandlerAdvice(private val messageSource: MessageSource) {

    /**
     * Handle for application's errors
     * Return HttpStatus 500 - INTERNAL SERVER ERROR
     * */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    fun handleServerErrorException(
        exception: Exception,
        request: HttpServletRequest
    ): ExceptionResponse {

        return ExceptionResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            field = "",
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message!!,
            path = request.servletPath
        )
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(
        exception: MethodArgumentNotValidException, request: HttpServletRequest
    ): List<ExceptionResponse> {
        val exceptionResponseList: MutableList<ExceptionResponse> = ArrayList()

        val fieldErrorList: List<FieldError> = exception.bindingResult.fieldErrors

        fieldErrorList.forEach { fieldError ->
            val message: String = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale())
            val errorResponse = ExceptionResponse(
                status = HttpStatus.BAD_REQUEST.value(),
                field = fieldError.field,
                error = HttpStatus.BAD_REQUEST.name,
                message = message,
                path = request.servletPath
            )
            exceptionResponseList.add(errorResponse)
        }

        return exceptionResponseList
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(TopicNotFoundException::class)
    fun handleTopicNotFoundException(
        exception: TopicNotFoundException,
        request: HttpServletRequest
    ): ExceptionResponse {

        return ExceptionResponse(
            status = HttpStatus.NOT_FOUND.value(),
            field = "",
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message!!,
            path = request.servletPath
        )

    }



}

data class ExceptionResponse(
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val field: String,
    val message: String,
    val path: String
)