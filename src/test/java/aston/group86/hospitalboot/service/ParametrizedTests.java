package aston.group86.hospitalboot.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class ParametrizedTests {

  MyCalc myCalc = new MyCalc();

  @ParameterizedTest
  @CsvSource({
      "1,2,3",
      "5,2,7",
      "3,2,5",
      "4,2,6",
      "7,2,9",
  })
  @MethodSource("getArguments")
  void calcTest(int a, int b, int sum) {
    int result = myCalc.getSum(a, b);
    assertThat(result).isEqualTo(sum);
  }

  static Stream<Arguments> getArguments() {
    return Stream.of(
        Arguments.of(22, 12, 34),
        Arguments.of(7, 8, 15)
    );
  }

}