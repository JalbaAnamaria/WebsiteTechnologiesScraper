import java.util.ArrayList;
import java.util.List;

public class TechnologyDetector {

    public static List<DetectedTechnology> detect(String html) {

        List<Technology> technologies = TechnologyRegistry.getAllTechnologies();
        List<DetectedTechnology> detectedTechnologies = new ArrayList<>();

        String lowerCasedHtml = html.toLowerCase();

        for (Technology technology : technologies) {

            List<String> proofs = new ArrayList<>();

            int score = 0;
            for (TechnologySignature signature: technology.getSignatures()) {

                if (lowerCasedHtml.contains(signature.getValue().toLowerCase())) {
                    proofs.add(signature.getValue());
                    score+=signature.getWeight();
                }
            }

            if (!proofs.isEmpty()) {
                Confidence confidence = calculateConfidence(score);

                DetectedTechnology detectedTechnology = new DetectedTechnology(
                        technology.getName(), proofs, confidence);
                detectedTechnologies.add(detectedTechnology);
            }
        }
        return detectedTechnologies;
    }


    private static Confidence calculateConfidence(int score) {
        if (score >= 10) {
            return Confidence.HIGH;
        } else if (score >= 3) {
            return Confidence.MEDIUM;
        } else {
            return Confidence.LOW;
        }
    }
}
