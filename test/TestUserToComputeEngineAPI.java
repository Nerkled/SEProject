import com.lucas.Input;
import com.lucas.Output;
import com.lucas.Source;
import com.lucas.StorageToComputeEngineAPI;
import com.lucas.UserToComputeEngineAPI;
import com.lucas.UserToComputeEngineImp;
import com.lucas.StorageToComputeEngineImp;


import org.junit.Test;
import org.mockito.Mockito;

import com.lucas.Source;
import com.lucas.StorageToComputeEngineAPI;
import com.lucas.UserToComputeEngineAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;





public class TestUserToComputeEngineAPI{
    @Test
    public void testAPI(){
        StorageToComputeEngineAPI storageMock = Mockito.mock(StorageToComputeEngineAPI.class);
        UserToComputeEngineAPI userAPI = new UserToComputeEngineImp(storageMock);
        Source sourceMock = Mockito.mock(Source.class);
        userAPI.setInputSource(sourceMock);
        verify(storageMock, never()).write(any(Output.class));

        //testing SetOutputDelimiter
        //String resultDelimiter = ",";  
        String resultDelimiter="";
        userAPI.setOutputDelimiter(resultDelimiter);
        verify(storageMock, never()).write(any(Output.class));
        assertEquals(resultDelimiter, userAPI.getResultDelimiter());


        //testing SetInputSource  
        //Source source = null;  
        Source source = new Source(); // Ensure source is initialized
        userAPI.setInputSource(source);
        assertEquals(source, userAPI.getInputSource());

        //testing SetOutputDestination
        //Source destination = new Source(); 
        Source destination = null; 
        userAPI.setOutputDestination(destination);
        assertEquals(destination,userAPI.getOutputDestination());

        //testing setComputationInput
        //Input input= new Input( );
        Input input= null;
        userAPI.setComputationInput(input);
        assertEquals (input, userAPI.getComputationInput());

        //lucas number computation test
        userAPI.executeLucasNumberComputation();
    }

}