package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    // Teilaufgabe 1
    @Test
    @DisplayName("Clear the screen after pressing the clear-key")
    void testClearKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressClearKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



    // Teilaufgabe 2 - Roter Test 1
    @Test
    @DisplayName("should display a decimal with a maximum of ten numbers and a dot")
    void testMaximumOfNumbersAndDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressDotKey();
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);


        String expected = "3.333333333";
        String actual = calc.readScreen();

        assertEquals(expected, actual);


    }

    // Teilaufgabe 2 - Roter Test 2
    @Test
    @DisplayName("should display an Error after using the unary Operator '1/x' and dividing by zero")
    void testDivisionByZeroOnUnaryOperator() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


}

