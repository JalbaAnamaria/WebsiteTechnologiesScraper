

void main() throws IOException {

    List<String> domains = DomainReader.getAllDomains();
    List<DomainScanResult> results = new ArrayList<>();

    for (String domain : domains) {
        System.out.println("Reading: " + domain);

        try {
            String html = HtmlReader.read(domain);
            List<DetectedTechnology> detectedTechnologies = TechnologyDetector.detect(html);

            DomainScanResult websiteResult = new DomainScanResult(domain, detectedTechnologies);
            results.add(websiteResult);

            if(detectedTechnologies.isEmpty()) {
                System.out.println("No known technologies detected");
                System.out.println();
            } else {
                for (DetectedTechnology detectedTechnology : detectedTechnologies) {
                    System.out.println("Technology: " + detectedTechnology.getName());
                    System.out.println("Confidence: " + detectedTechnology.getConfidence());
                    System.out.println("Proofs: " + detectedTechnology.getProofs());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR : Could not read " + domain);
            System.out.println("Reason: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
            System.out.println();
        }
    }

    JsonExporter.export(results, "results.json");



}
