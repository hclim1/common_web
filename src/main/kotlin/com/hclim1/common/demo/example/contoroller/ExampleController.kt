package com.hclim1.common.demo.example.contoroller

import com.hclim1.common.demo.example.domain.Example
import com.hclim1.common.demo.example.service.ExampleService
import com.hclim1.common.demo.response.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/example")
class ExampleController {


	@Autowired
	private lateinit var exampleServcie: ExampleService

	@GetMapping("/data")
	fun getData(): ApiResponse<Example?> {
		return exampleServcie.getData();
	}

	@GetMapping("")
	fun getHelloWorld(): String {
		return "Hello World"
	}
}


