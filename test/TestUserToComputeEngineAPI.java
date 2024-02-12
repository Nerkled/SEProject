import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TestUserToComputeEngineAPI
{
    @Test
    public void testAPI()
    {
        StorageToComputeEngineAPI storageMock = Mockito.mock(StorageToComputeEngineAPI.class);
        UserToComputeEngineAPI userAPI = new UserToComputeEngineImp(storageMock);
        Source sourceMock = Mockito.mock(Source.class);
        userAPI.setInputSource(sourceMock);
        verify(storageMock, never()).write(any(Output.class));

        //testing SetOutputDelimiter
        String resultDelimiter = ",";  
        //String resultDelimiter="";
        userAPI.setOutputDelimiter(resultDelimiter);
        verify(storageMock, never()).write(any(Output.class));
        assert resultDelimiter.equals(userAPI.getResultDelimiter());


        //testing SetInputSource
        Source source = new Source();  
        //Source source = null;  
        userAPI.setInputSource(source);
        assert source.equals(userAPI.getInputSource());

        //testing SetOutputDestination
        Source destination = new Source(); 
        //Source destination = null; 
        userAPI.setOutputDestination(destination);
        assert destination.equals(userAPI.getOutputDestination());

        //testing setComputationInput
        Input input= new Input( );
        userAPI.setComputationInput(input);
        assert input.equals(userAPI.getComputationInput());

        //lucas number computation test
        userAPI.executeLucasNumberComputation();

    }
}