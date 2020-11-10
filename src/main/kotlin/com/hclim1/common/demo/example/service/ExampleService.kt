package com.hclim1.common.demo.example.service

import com.hclim1.common.demo.error.GlobalExceptionHandler
import com.hclim1.common.demo.example.domain.Example
import com.hclim1.common.demo.response.ApiResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExampleService {

	companion object {
		private val log
				= LoggerFactory.getLogger(ExampleService::class.java)
	}

	fun getData(key : String): ApiResponse<Example?> {
		var example = Example("Sam", "Smith", 22)
		return ApiResponse(example, "성공", true)
	}

	fun addData(example: Example): ApiResponse<Boolean> {
		//TODO insert example
		log.info("Example parameter={}",example.toString())
		return ApiResponse(true)
	}

	fun setData(example: Example): ApiResponse<Boolean> {
		//TODO update example
		log.info("Example parameter={}",example.toString())
		return ApiResponse(true)
	}

	fun removeData(key : String): ApiResponse<Boolean?> {
		//TODO update example
		return ApiResponse(true)
	}

}