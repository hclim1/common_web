package com.hclim1.common.demo.example.controller


import com.hclim1.common.demo.server.ServerApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@SpringBootTest(classes = arrayOf(ServerApplication::class),
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExampleControllerTest {

	@Autowired
	private lateinit var mvc: MockMvc


	@Test
	@Throws(Exception::class)
	fun call_getTaxiPayment_list() {

		//given

		//when
		val result = mvc.perform(get("/example")
		).andDo(print())

		//then
		result.andExpect(status().isOk())
				.andExpect(content().string("Test Example"))
	}


}