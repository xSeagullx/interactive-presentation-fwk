package cern.ais.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("concurrentProgramming")
class ConcurrencyController {
	@RequestMapping("/index")
	String code(Model model) {
		model.addAttribute("title", 'CP')
		model.addAttribute("slides", 'concurrency')
		"index"
	}
}
