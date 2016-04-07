def feed = $/<feed>
<title type="text">Groovy questions - Stack Exchange</title>
<entry>
        <id>http://stackoverflow.com/questions/33471900/how-to-increase-available-memory-size-in-groovyconsole</id>
        <title type="text">How to increase available memory size in GroovyConsole? &#8211; stackoverflow.com</title>
        <category term="groovy" />
        <category term="jvm" />
        <author>
          <name>Paul Jurczak</name>
        </author>
        <summary type="html">
            I&#39;m running scripts inside GroovyConsole 2.4.5 on Windows 7 64-bit and they are crashing due to out of memory error. Runtime.getRuntime().totalMemory() shows 250MB and my PC has 32GB RAM. What is the  ... 
        </summary>
    </entry>
    <entry>
        <id>http://stackoverflow.com/questions/33460942/java-code-completion-in-groovy-files-in-eclipse-mars</id>
        <title type="text">Java Code Completion in Groovy Files in Eclipse Mars &#8211; stackoverflow.com</title>
        <category term="eclipse" />
        <category term="groovy" />
        <author><name>Gregor</name></author>
        <summary type="html">
            I don&#39;t get any Java code completion in a groovy editor in Eclipse Mars. It seems that in older Eclipse versions the Java completion was available: Eclipse content assist not working for Java objects  ... 
        </summary>
    </entry>
</feed>/$

def xml = new XmlParser().parseText(feed)
println("Names")
println(xml.entry.author.name.text())
println("Titles")
println(xml."**".title*.text().join('\n'))
println("tags")
println(xml."**".@term.grep { it?.size() > 2 } )
