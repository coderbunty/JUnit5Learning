package com.wm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

  private MathUtils mathUtils;

  @BeforeAll
  public void init() {
    mathUtils = new MathUtils();
  }

  @Test
  public void testAdd() {
    //System.out.println("Ran a unit test.");
    //Assertions.fail("Not yet implemented.");
    Assertions.assertEquals(3, mathUtils.add(1, 2));
    // a message can be shown if the test fails
    Assertions.assertNotEquals(3, mathUtils.add(1, 1), "wrong sum calculated");
  }

  @Test
  public void testDivide() {
    Assertions.assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0));
  }

  @Test
  public void testMultiply() {
    // if anyone of the asserts in assertALl fails, then the test fails
    Assertions.assertAll(
        () -> Assertions.assertEquals(6, mathUtils.multiply(2, 3)),
        () -> Assertions.assertEquals(0, mathUtils.multiply(2, 0)),
        () -> Assertions.assertEquals(-6, mathUtils.multiply(2, -3))
    );
  }

  @Test
  public void testCircleArea() {
    Assertions.assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
  }

  @Disabled
  @Test
  public void testRandom() {
    Assertions.fail("Test case failed.");
  }

  @RepeatedTest(3)
  void testRemainder(RepetitionInfo rinfo) {
    //rinfo.getCurrentRepetition()
    Assertions.assertEquals(3, mathUtils.remainder(9, 6), "Remainder is incorrect");
  }

  // grouping a set of tests together using nested class
  // if any test fails, TestSubtract group test fails, the feature having multiple tests failed
  @Nested
  class TestSubtract {

    @Test
    void testSubtractWithZero() {
      Assertions.assertEquals(9, mathUtils.subtract(9, 0));
    }

    @Test
    void testSubtractWithSame() {
      Assertions.assertEquals(0, mathUtils.subtract(9, 9));
    }

    @Test
    void testSubtractWithAny() {
      Assertions.assertEquals(10, mathUtils.subtract(11, 2));
    }
  }
}