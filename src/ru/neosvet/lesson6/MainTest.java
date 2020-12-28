package ru.neosvet.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class MainTest {
    @Test
    public void errorTestAfterLastFour() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Assertions.assertEquals(null, Main.afterLastFour(new int[]{1, 2, 3, 5}));
        });
    }

    @DisplayName("Param Test")
    @ParameterizedTest
    @MethodSource("data")
    public void paramTestAfterLastFour(int[] mIn, int[] mOut) {
        Assertions.assertArrayEquals(mOut, Main.afterLastFour(mIn));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[]{5}),
                Arguments.arguments(new int[]{4, 3, 1, 7}, new int[]{3, 1, 7})
        );
    }
}
