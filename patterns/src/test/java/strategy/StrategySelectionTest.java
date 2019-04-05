package strategy;

import exception.MyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrategySelectionTest {
    private static final String ADD_COMMAND = "add";
    private static final String SUBTRACT_COMMAND = "subtract";
    private static final String MULTIPLE_COMMAND = "multiple";
    private static final String DIVISION_COMMAND = "division";
    private StrategySelection strategySelection;

    @Before
    public void setUp() {
        strategySelection = new StrategySelection();
    }

    @Test
    public void selectAddingStrategyTest() throws MyException {
        assertEquals(15, strategySelection.selectOperationStrategy(10, 5, ADD_COMMAND));
    }

    @Test
    public void selectSubtractStrategyTest() throws MyException {
        assertEquals(5, strategySelection.selectOperationStrategy(10, 5, SUBTRACT_COMMAND));
    }

    @Test
    public void selectMultipleStrategyTest() throws MyException {
        assertEquals(50, strategySelection.selectOperationStrategy(10, 5, MULTIPLE_COMMAND));
    }

    @Test(expected = MyException.class)
    public void selectNonexistentStrategyTest() throws MyException {
        strategySelection.selectOperationStrategy(10, 5, "dance");
    }

    @Test
    public void selectDivisionStrategyTest() throws MyException {
        assertEquals(2, strategySelection.selectOperationStrategy(10, 5, DIVISION_COMMAND));
    }

    @Test
    public void selectDivisionStrategyWithNonIntegerReturnValueTest() throws MyException {
        assertEquals(2, strategySelection.selectOperationStrategy(10, 4, DIVISION_COMMAND));
    }

    @Test(expected = ArithmeticException.class)
    public void selectDivisionStrategyWithZeroValueTest() throws MyException {
        strategySelection.selectOperationStrategy(10, 0, DIVISION_COMMAND);
    }

    @Test(expected = NullPointerException.class)
    public void selectStrategyWithNullCommandTest() throws MyException {
        strategySelection.selectOperationStrategy(7, 4, null);
    }
}