package com.hclim1.common.demo.example.contoroller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {

	@GetMapping("/example")
	fun getExample(): String {
		return "Test Example"
	}
}

