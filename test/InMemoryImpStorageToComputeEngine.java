import java.util.ArrayList;
import java.util.List;

public class InMemoryImpStorageToComputeEngine{
    private List<Integer> inputIntegers;
    private List<String> outputStrings;
    public InMemoryImpStorageToComputeEngine(){
        this.inputIntegers = new ArrayList<>();
        this.outputStrings = new ArrayList<>();
    }
    public void readInput(InputConfig inputConfig){
        this.inputIntegers = new ArrayList<>(inputConfig.getIntegers());
    }
    public void writeOutput(OutputConfig outputConfig){
        this.outputStrings = new ArrayList<>(outputConfig.getStrings());
    }
    public List<Integer> getInMemoryInput(){
        return new ArrayList<>(inputIntegers);
    }
    public List<String> getInMemoryOutput(){
        return new ArrayList<>(outputStrings);
    }
}
