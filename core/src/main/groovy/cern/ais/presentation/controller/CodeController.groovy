package cern.ais.presentation.controller

import groovy.json.StringEscapeUtils
import groovy.ui.SystemOutputInterceptor
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
	ExecResult exec(@RequestBody Map script) {
		def hasError = false
		def res = null
		def writer = new StringWriter()

		SystemOutputInterceptor systemOutputInterceptor = new SystemOutputInterceptor({ String it ->
			writer.write(it);
			true
		}, false)
		SystemOutputInterceptor systemErrInterceptor = new SystemOutputInterceptor({ String it -> 
			writer.write(it);
			true
		}, true)
		systemOutputInterceptor.start()
		systemErrInterceptor.start()
		try {
			res = new GroovyShell().evaluate(script.script as String)
		}
		catch (any) {
			res = any.message
			any.printStackTrace(new PrintWriter(writer))
			hasError = true
		}
		finally {
			systemOutputInterceptor.stop()
			systemErrInterceptor.stop()
		}
		def out = groovy.xml.XmlUtil.escapeXml(writer.toString())
		new ExecResult(code: script, out: "> Result: $res\n${ '-' * 10 }Out/Err${ '-' * 10 }\n$out", hasError: hasError)
	}

	@RequestMapping("/{id}")
	String code(@PathVariable String id, Model model) {
		def text = new File("/Users/seagull/Dev/cern/other/presentation-fwk/core/src/main/resources/code").listFiles().find { it.name.startsWith(id) }?.text
		model.addAttribute("code", text)
		"code"
	}
}

// here's where the magic happens allowing the service to capture the output while the script runs
class SystemOutputInterceptorClosure extends Closure {

	StringBuffer stringBuffer = new StringBuffer();

	public SystemOutputInterceptorClosure( Object owner ) {
		super( owner ) ;
	}

	@Override
	public Object call( Object params ) {
		stringBuffer.append(params);
		return false;
	}

	@Override
	public Object call(Object... args) {
		stringBuffer.append(args);
		return false;
	}

	public StringBuffer getStringBuffer() {
		return this.stringBuffer;
	}
}
