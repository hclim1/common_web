package com.hclim1.common.demo.example.controller


import com.hclim1.common.demo.server.ServerApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.util.LinkedMultiValueMap

import org.springframework.util.MultiValueMap




@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@SpringBootTest(classes = arrayOf(ServerApplication::class),
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExampleControllerTest {

	@Autowired
	private lateinit var mvc: MockMvc


	@Test
	@Throws(Exception::class)
	fun get_example_list() {

		//given

		//when
		val result = mvc.perform(get("/example")
		).andDo(print())

		//then
		result.andExpect(status().isOk)
				.andExpect(content().string("Hello World"))
	}

	@Test
	@Throws(Exception::class)
	fun get_example_json() {

		//given
		var key : String = "test"
		//when
		val result = mvc.perform(get("/example/data/$key")
		).andDo(print())

		//then
		result.andExpect(status().isOk)
				.andExpect(jsonPath("success").isBoolean)
				.andExpect(jsonPath("success").value(true))
				.andExpect(jsonPath("message").value("성공"))
				.andExpect(jsonPath("item").isNotEmpty)
	}


	@Test
	@Throws(java.lang.Exception::class)
	fun add_example_true(){
		//given
		val params: MultiValueMap<String, String> = LinkedMultiValueMap()
		params.add("firstName","Test")
		params.add("lastName","Last Test")
		params.add("age","22")
		//when
		val result = mvc.perform(post("/example/data")
				.params(params)
				).andDo(print())
		//then
	}


	@Test
	@Throws(java.lang.Exception::class)
	fun set_example_true(){
		//given
		val params: MultiValueMap<String, String> = LinkedMultiValueMap()
		params.add("firstName","Test")
		params.add("lastName","Last Test")
		params.add("age","22")
		//when
		val result = mvc.perform(put("/example/data")
				.params(params)
		).andDo(print())
		//then
	}

	@Test
	@Throws(java.lang.Exception::class)
	fun remove_example_true(){
		//given
		var key : String = "test"
		//when
		val result = mvc.perform(delete("/example/data/$key")
		).andDo(print())
		//then
	}

}