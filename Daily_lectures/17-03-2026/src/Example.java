import java.util.UUID;

public class Example {
    String id;
    String uniqueId;

    public Example(String id) {
        this.id = id;
        this.uniqueId = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getUniqueId() {
        return uniqueId;
    }
}
