import cern.ais.presentation.Main
import cern.ais.presentation.Presentation
import cern.ais.presentation.Section
import cern.ais.presentation.Slide
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Lazy
@Service
class ExamplePresentation implements Presentation {
	final String title = "Hello world"
	final List<Slide> slides

	ExamplePresentation() {
		slides = [new Slide(new Section("""
						<h1>Hello world!</h1>
						<i class="fragment">Small example presentation</i>
				""")),
		new Slide(new Section("""
						<h1>Two layer slide</h1>
				"""), new Section("Test"))] 
	}

	static main(args) {
		Main.run(ExamplePresentation)
	}
}
