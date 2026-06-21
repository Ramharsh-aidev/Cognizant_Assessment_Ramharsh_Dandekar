import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    // Executed before EVERY test method.
    @Before
    public void setUp() {
        System.out.println("Setting up test fixture...");
        calculator = new Calculator();
    }

    // Executed after EVERY test method.
    @After
    public void tearDown() {
        System.out.println("Tearing down test fixture...");
        calculator.clearMemory();
        calculator = null;
    }

    @Test
    public void testAdditionUsingAAAPattern() {
        // 1. ARRANGE
        int a = 10;
        int b = 5;

        // 2. ACT
        int result = calculator.add(a, b);

        // 3. ASSERT
        assertEquals("10 + 5 should equal 15", 15, result);
    }

    @Test
    public void testMemoryFunctionalityUsingAAAPattern() {
        // 1. ARRANGE
        int valueToSave = 42;

        // 2. ACT
        calculator.saveToMemory(valueToSave);
        int retrievedValue = calculator.getMemory();

        // 3. ASSERT
        assertEquals("The retrieved memory value should match what was saved", 42, retrievedValue);
    }
}
