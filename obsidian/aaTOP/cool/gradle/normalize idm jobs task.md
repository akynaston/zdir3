task normalizeJobs {
    def xmlSource = file('auxiliary/jobs/SFH-Trigger Archive Files.xml')
    def xmlDest = file('auxiliary/jobs/SFH-Trigger Archive Files.xml')

    def parser = new groovy.xml.XmlParser()
    def xmlRoot = parser.parse(xmlSource)
    def b = new groovy.xml.XmlNodePrinter(new PrintWriter(new FileWriter(xmlDest)), "    ")
    b.preserveWhitespace = true

    println "hi"
    print "bye"

    b.print(xmlRoot)

}