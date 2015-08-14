package cern.ais.presentation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Controller
@EnableWebMvc
@EnableAutoConfiguration()
class Main extends WebMvcAutoConfiguration {
	@Autowired Presentation presentation

	@RequestMapping("/")
	String index() {
		"index"
	}

	@ModelAttribute('$')
	Presentation getPresentation() {
		presentation
	}

	static void run(Class<? extends Presentation> clazz) {
		SpringApplication.run([Main, clazz] as Object[])
	}
}
