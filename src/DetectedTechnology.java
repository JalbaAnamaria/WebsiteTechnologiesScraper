import java.util.List;

public class DetectedTechnology {

    private final String name;
    private final List<String> proofs;
    private final Confidence confidence;

    public DetectedTechnology(String name, List<String> proofs, Confidence confidence) {
        this.name = name;
        this.proofs = proofs;
        this.confidence = confidence;
    }

    public String getName() {
        return name;
    }

    public List<String> getProofs() {
        return proofs;
    }

    public Confidence getConfidence() {
        return confidence;
    }
}
