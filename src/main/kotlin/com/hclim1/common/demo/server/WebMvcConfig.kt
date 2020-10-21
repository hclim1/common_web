package com.hclim1.common.demo.server

import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@EnableWebMvc
@Configuration
@ComponentScan("com.hclim1.common.demo")
class WebMvcConfig : WebMvcConfigurer {

	@Bean
	fun webServerFactory(): ConfigurableServletWebServerFactory? {
		val factory = TomcatServletWebServerFactory()
		factory.addConnectorCustomizers(TomcatConnectorCustomizer { connector -> connector.setProperty("relaxedQueryChars", "|{}[]") })
		return factory
	}

}