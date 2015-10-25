package cern.ais.presentation.controller

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("code")
class CodeController
{
	static class ExecResult {
		String code;
		String out;
		boolean hasError;
	}

	@ResponseBody
	@RequestMapping(value = "/exec", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ExecResult exec(@RequestBody script) {
		new ExecResult(code: script, out: "lallala", hasError: false)
	}

	@RequestMapping("/{id}")
	String code(@PathVariable String id, Model model) {
		model.addAttribute("code", "println('Hello world. $id')")
		"code"
	}
}
