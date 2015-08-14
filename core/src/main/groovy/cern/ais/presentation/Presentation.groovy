package cern.ais.presentation

import groovy.transform.Immutable

trait ISection {
	abstract String getHtml()

	String enclose(String content, String tag) {
		"<$tag>$content</$tag>"
	}
}

@Immutable
class Section implements ISection {
	String html
}

class Slide implements ISection {
	private final List<Section> sections
	Slide(Section ... sections) {
		this.sections = sections.toList()
	}

	String getHtml() {
		sections.collect { enclose(it.html, "section") }.join('')
	}
}

interface Presentation {
	String getTitle()
	List<Slide> getSlides()
}
