import com.lucas.*;
import java.util.List;

public class InputConfig extends Input {
    private List<Integer> integers;

    public InputConfig (List<Integer> integers) {
        this.integers = integers;
    }
    public List<Integer> getIntegers() {
        return integers;
    }
}
