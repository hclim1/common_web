package com.hclim1.common.demo.error

import org.slf4j.LoggerFactory.getLogger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

	companion object {
		private val log
				= getLogger(GlobalExceptionHandler::class.java)
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException::class)
	protected fun handleHttpRequestMethodNotSupportedException(e: HttpRequestMethodNotSupportedException): ResponseEntity<ErrorResponse> {
		log.error("HttpRequestMethodNotSupportedException Error={}", e.message)
		val response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED)
		return ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED)
	}

	@ExceptionHandler(Exception::class)
	fun handleException(e : Exception) : ResponseEntity<ErrorResponse>{
		log.error("Exception Error={}", e.message)
		val response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR)
		return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
	}


}