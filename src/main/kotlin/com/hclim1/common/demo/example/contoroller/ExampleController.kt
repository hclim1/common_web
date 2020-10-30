package com.hclim1.common.demo.example.contoroller

import com.hclim1.common.demo.example.domain.Example
import com.smilegate.general.mgt.common.ApiResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/example")
class ExampleController {


	@GetMapping("/data")
	fun getFullName() : ApiResponse<Example?> {
		var example : Example? = null
		val result : ApiResponse<Example?>
		result = ApiResponse(example,"조회", false)
		return result
	}


	@GetMapping("")
	fun getExample(): String {
		return "Hello World"
	}
}


