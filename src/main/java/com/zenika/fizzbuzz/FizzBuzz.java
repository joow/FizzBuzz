package com.zenika.fizzbuzz;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import io.vavr.collection.Stream;

public class FizzBuzz {
    public static void main(String[] args) {
        Stream<String> fizzes = Stream.of("", "", "Fizz").cycle();
        Stream<String> buzzes = Stream.of("", "", "", "", "Buzz").cycle();
        Stream<String> words = fizzes.zipWith(buzzes, String::concat).map(Strings::emptyToNull);
        Stream<String> numbers = Stream.from(1).map(String::valueOf);
        Stream<String> fizzbuzz = words.zipWith(numbers, MoreObjects::firstNonNull);

        fizzbuzz.take(100).forEach(System.out::println);
    }
}
