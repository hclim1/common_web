package com.hclim1.common.demo.example.contoroller

import com.hclim1.common.demo.example.domain.Example
import com.hclim1.common.demo.example.service.ExampleService
import com.hclim1.common.demo.response.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/example")
class ExampleController {


	@Autowired
	private lateinit var exampleServcie: ExampleService

	@GetMapping("/data/{key}")
	fun getData(@PathVariable key : String): ApiResponse<Example?> {
		return exampleServcie.getData(key);
	}

	@GetMapping("")
	fun getHelloWorld(): String {
		return "Hello World"
	}

	@PostMapping("/data")
	fun addData(example : Example) : ApiResponse<Boolean>{
		return exampleServcie.addData(example)
	}
}


