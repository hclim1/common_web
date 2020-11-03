package com.hclim1.common.demo.example.service

import com.hclim1.common.demo.example.domain.Example
import com.hclim1.common.demo.response.ApiResponse
import org.springframework.stereotype.Service

@Service
class ExampleService {

	fun getData(): ApiResponse<Example?> {
		var example = Example("Sam", "Smith", 22)
		return ApiResponse(example, "성공", true);
	}

}