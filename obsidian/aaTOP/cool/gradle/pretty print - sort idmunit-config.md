3/20/2024 3:41:34 PM
Temp function I had to sort xmlunit . .but it deletes comments . .

```

task replace {
    def xmlSource = file('src/test/resources/idmunit-config.xml')
    def xmlDest = file('src/test/resources/idmunit-config.xml.done')

    def parser = new groovy.xml.XmlParser()
    def xmlRoot = parser.parse(xmlSource)
    def b = new groovy.xml.XmlNodePrinter(new PrintWriter(new FileWriter(xmlDest)), "    ")
    b.preserveWhitespace = true

    println "hi"
    print "bye"

    b.print(xmlRoot)

}
```