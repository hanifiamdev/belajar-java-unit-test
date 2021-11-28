package hanifiamdev.com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    void testMock() {

        // Membuat Mock Object
        List<String> list = Mockito.mock(List.class);

        // Menambahkan Behavior
        Mockito.when(list.get(0)).thenReturn("Hanif");
        Mockito.when(list.get(100)).thenReturn("Amrullah");

        // Test Mock
        Assertions.assertEquals("Hanif", list.get(0)); // dipanggil hanya sekali
        Assertions.assertEquals("Amrullah", list.get(100));

        // Verivy Mock
        Mockito.verify(list, Mockito.times(1)).get(0); // memastikan index ke 0 hanya di panggil sekali
    }
}
