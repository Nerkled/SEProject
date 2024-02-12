import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

public class TestStorageToComputeEngine{
    @Test
    public void test() throws Exception{
        StorageToComputeEngine storageToComputeEngineMock = Mockito.mock(StorageToComputeEngine.class);
        when(storageToComputeEngineMock.getsStorageEngine(anyInt())).thenReturn(3);
        assertEquals(3, storageToComputeEngineMock.getsStorageEngine(3));
    }
}