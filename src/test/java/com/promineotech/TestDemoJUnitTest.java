package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat; 
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("argumentsForAddPositive")
	public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
	if(!expectException) {
		assertThat(TestDemo.addPositive(a,b)).isEqualTo(expected);
	}
	else {
		assertThatThrownBy(() -> TestDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
	}
	}
	

	private static Stream<Arguments> argumentsForAddPositive() {
	    return Stream.of(
	            Arguments.of(0, 2, 2, true),
	            Arguments.of(2, 4, 6, true),
	            Arguments.of(5, 2, 7, true),
	            Arguments.of(0, 2, 2, true),
	            Arguments.of(2, 5, 9, false),
	            Arguments.of(12, -2, 10, false)
	    );
	}

 
@Test 
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}

}
