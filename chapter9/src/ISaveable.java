import java.util.List;

public interface ISaveable {
    List<String> write();

    void update(List<String> savedValues);

}
