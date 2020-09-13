package com.wm;

import java.util.stream.IntStream;

public class PrimeUtils {

  public static boolean isPrime(int num) {
    long divisor = IntStream.range(2, num / 2 + 1)
        .filter(e -> num % e == 0)
        .count();
    return divisor == 0;
  }

}
