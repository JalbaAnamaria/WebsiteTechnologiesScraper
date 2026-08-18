
import java.util.List;

public class Technology {

    private final  String name;
    private final List<TechnologySignature> signatures;

    public Technology(String name, List<TechnologySignature> signatures) {
        this.name = name;
        this.signatures = signatures;
    }

    public String getName() {
        return name;
    }

    public List<TechnologySignature> getSignatures() {
        return signatures;
    }
}
