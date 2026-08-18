import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonExporter {
    public static void export(List<DomainScanResult> results, String fileName) throws IOException {

        FileWriter writer = new FileWriter(fileName);

        writer.write("[\n");

        for (int i = 0; i < results.size(); i++) {

            DomainScanResult result = results.get(i);

            writer.write("  {\n");
            writer.write("    \"domain\": \"" + result.getDomain() + "\",\n");
            writer.write("    \"detectedTechnologies\": [\n");

            List<DetectedTechnology> technologies =
                    result.getDetectedTechnologies();

            for (int j = 0; j < technologies.size(); j++) {

                DetectedTechnology technology = technologies.get(j);

                writer.write("      {\n");
                writer.write("        \"name\": \"" + technology.getName() + "\",\n");
                writer.write("        \"proofs\": [\n");

                List<String> proofs = technology.getProofs();

                for (int k = 0; k < proofs.size(); k++) {

                    writer.write("          \"" + proofs.get(k) + "\"");

                    if (k < proofs.size() - 1) {
                        writer.write(",");
                    }

                    writer.write("\n");
                }

                writer.write("        ],\n");
                writer.write("        \"confidence\": \"" + technology.getConfidence() + "\"\n");
                writer.write("      }");

                if (j < technologies.size() - 1) {
                    writer.write(",");
                }

                writer.write("\n");
            }

            writer.write("    ]\n");
            writer.write("  }");

            if (i < results.size() - 1) {
                writer.write(",");
            }

            writer.write("\n");
        }

        writer.write("]\n");

        writer.close();
    }

}
