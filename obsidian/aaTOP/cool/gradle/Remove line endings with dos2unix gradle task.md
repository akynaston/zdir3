System.setProperty("line.seperator","\n");
task dos2unix(type: Copy) {
  from $sourceFile
  into $targetFile
  filter { line -> line}
}