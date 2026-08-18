import java.util.List;

public class DomainScanResult {

    private final String domain;
    private final List<DetectedTechnology> detectedTechnologies;

    public DomainScanResult(String domain, List<DetectedTechnology> detectedTechnologies) {
        this.domain = domain;
        this.detectedTechnologies = detectedTechnologies;
    }

    public String getDomain() {
        return domain;
    }

    public List<DetectedTechnology> getDetectedTechnologies() {
        return detectedTechnologies;
    }
}
