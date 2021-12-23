package com.sisbutsig.tddbyexample.primenumbers2;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public final class PrimeNumbers {
  public static boolean isPrime(int num) {
    return num > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(num))
                               .noneMatch(isFactorOf(num));
  }

  private PrimeNumbers() {
  }

  private static IntPredicate isFactorOf(int num) {
    return factor -> num % factor == 0;
  }

  public static List<Integer> findAllTo(int num) {
    return IntStream.range(2, num)
                    .filter(PrimeNumbers::isPrime)
                    .boxed()
                    .collect(toList());
  }
}
