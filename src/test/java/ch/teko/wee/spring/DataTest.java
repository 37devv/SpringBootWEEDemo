package ch.teko.wee.spring;


import ch.teko.wee.spring.service.DataService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DataTest {

    @Test
    public void testGetFirstAndLastName() {
        // Create a mock instance of the DataService interface
        DataService dataService = Mockito.mock(DataService.class);

        // Define the expected behavior of the mock
        when(dataService.getFirstAndLastName()).thenReturn("John Doe");

        // Create an instance of the class that depends on DataService
        MyClass myClass = new MyClass(dataService);

        // Call the method being tested
        String result = myClass.processFullName();

        // Verify the result
        assertEquals("Processed Name: John Doe", result);
    }

    // Class that depends on DataService
    static class MyClass {
        private final DataService dataService;

        public MyClass(DataService dataService) {
            this.dataService = dataService;
        }

        public String processFullName() {
            String fullName = dataService.getFirstAndLastName();
            return "Processed Name: " + fullName;
        }
    }
}
