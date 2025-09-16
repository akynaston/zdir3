3/21/2025 9:25:32 AM

loop through json files:
```
        File dir = new File("C:\\work\\work");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File json : directoryListing) {
                if (!json.getName().endsWith(".json")) {
                    continue;
                }
                File outputFile = new File(json.getName() + ".ldif");
                BufferedReader brJson = new BufferedReader(new FileReader(json));
                PrintWriter pwLDIF = new PrintWriter(new FileWriter(outputFile));

                OnboardingTool.createOnboardingFile(brJson, pwLDIF);

            }
        }
```