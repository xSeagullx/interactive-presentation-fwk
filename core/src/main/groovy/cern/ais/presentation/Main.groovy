package cern.ais.presentation

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@ComponentScan
@EnableAutoConfiguration
class Main extends WebMvcAutoConfiguration {
	static void run(Class<?> clazz) {
		SpringApplication.run([Main, clazz] as Object[])
	}

	static void main(args) {
		SpringApplication.run(Main)
	}
}
