package com.hclim1.common.demo.error

import com.fasterxml.jackson.databind.ObjectMapper
import com.hclim1.common.demo.server.ServerApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@SpringBootTest(classes = arrayOf(ServerApplication::class),
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ErrorControllerTest {

	@Autowired
	private lateinit var mvc: MockMvc

	private var mapper = ObjectMapper()

	@Test
	@Throws(Exception::class)
	fun call_error_http_404() {

		//given

		//when
		val result = mvc.perform(MockMvcRequestBuilders.get("/example/404")
		).andDo(MockMvcResultHandlers.print())

		//then
		result.andExpect(status().is4xxClientError)
	}

	@Test
	@Throws(Exception::class)
	fun call_error_http_405() {

		//given

		//when
		val result = mvc.perform(MockMvcRequestBuilders.post("/example/data")
		).andDo(MockMvcResultHandlers.print())

		//then
		result.andExpect(status().is4xxClientError)
				.andExpect(jsonPath("status").value("405"))
				.andExpect(jsonPath("code").value("H0004"))
	}


}