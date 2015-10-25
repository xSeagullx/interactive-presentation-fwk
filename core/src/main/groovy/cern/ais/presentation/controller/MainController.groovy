package cern.ais.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("main")
class MainController {
	@RequestMapping("/index")
	String code(Model model) {
		model.addAttribute("title", 'HW')
		"index"
	}
}
