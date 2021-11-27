package hanifiamdev.com.test;

import hanifiamdev.com.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayName("Test untuk Calculator class")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each");

    }

    @Test
    @DisplayName("Test skenario sukses untuk method add(integer, integer)")
    public void testAddSuccess() {
        var result = calculator.add(10, 10);

        // cara manual
       /* if(result != 20) {
            throw new RuntimeException("Test Gagal");
        }*/

        //menggunakan assertion
        assertEquals(20, result);
    }

    @Test
    public void testDivideSuccess() {
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });

    }

    @Test
    @Disabled
    public void testComingSoon() {}

}
