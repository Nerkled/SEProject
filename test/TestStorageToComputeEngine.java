import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
public class TestStorageToComputeEngine {
    @Test
    public void testStorageToComputeEngineAPI() {
        StorageToComputeEngineAPI storageMock = Mockito.mock(StorageToComputeEngineAPI.class);
        
        Input input = new Input(); 
        
        Output output = new Output();
        
        storageMock.write(output);
        
        Mockito.verify(storageMock, Mockito.times(1)).write(Mockito.eq(output));
        
        storageMock.read(input);
        
        Mockito.verify(storageMock, Mockito.times(1)).read(Mockito.eq(input));
    }
}