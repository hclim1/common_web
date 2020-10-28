package com.hclim1.common.demo.example.contoroller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/example")
class ExampleController {

	@GetMapping("")
	fun getExample(): String {
		return "Test Example"
	}
}

