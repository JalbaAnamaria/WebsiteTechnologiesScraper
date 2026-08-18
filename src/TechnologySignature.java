public class TechnologySignature {

    private final String value;
    private final int weight;

    public TechnologySignature(String value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public String getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}
