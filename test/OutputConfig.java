import com.lucas.Output;
import java.util.List;

public class OutputConfig extends Output {
    private List<String> strings;

    public OutputConfig(List<String> strings) {
        this.strings = strings;
    }
    public List<String> getStrings() {
        return strings;
    }
}
