package com.hclim1.common.demo.error

import org.springframework.validation.BindingResult

class ErrorResponse {
	var code: String
		private set
	var message: String
		private set
	var status: Int
		private set

	private constructor(code: ErrorCode) {
		message = code.message
		status = code.status
		this.code = code.code
	}

	private constructor(code: ErrorCode, message: String) {
		this.message = message
		status = code.status
		this.code = code.code
	}

	companion object {
		fun of(code: ErrorCode): ErrorResponse {
			return ErrorResponse(code)
		}

		fun of(code: ErrorCode, bindingResult: BindingResult): ErrorResponse {
			val fieldError = bindingResult.fieldErrors[0]
			return ErrorResponse(code, String.format("%s %s", fieldError.field, fieldError.defaultMessage))
		}
	}
}