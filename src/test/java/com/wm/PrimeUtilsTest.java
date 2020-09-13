package com.wm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrimeUtilsTest {

  PrimeUtils primeUtils;
  private TestReporter testReporter;
  private TestInfo testInfo;

  @BeforeAll
  public void init() {
    primeUtils = new PrimeUtils();
  }

  @BeforeEach
  public void setup(TestInfo testInfo, TestReporter testReporter) {
    this.testInfo = testInfo;
    this.testReporter = testReporter;
  }

  @Test
  @Tag("prime")
  @DisplayName("Testing prime number")
  void isPrimeTest() {
    testReporter.publishEntry(testInfo.getDisplayName());
    Assertions.assertEquals(false, primeUtils.isPrime(57));
    Assertions.assertEquals(true, primeUtils.isPrime(59));
    Assertions.assertNotEquals(false, primeUtils.isPrime(97));
  }

}