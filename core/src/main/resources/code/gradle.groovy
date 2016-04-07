apply plugin: "groovy"
apply plugin: "application"

repositories {
	mavenCentral()
}

dependencies {
	compile 'org.codehaus.groovy:groovy-all:2.3.9'
	compile "org.springframework:spring-context:4.1.6.RELEASE"
	testCompile 'junit:junit:4.11'
}

task(copy, type: Copy) {
	from(file('srcDir'))
	into(buildDir)
}
