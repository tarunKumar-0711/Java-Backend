package com.applictaionTask;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
class ApplicationTests {
	
	private Calculator c = new Calculator();
	@Test
	void contextLoads() {
	}
	
	 	@Test
	    @Disabled
	    void testSum() {
	        //expected
	        int expectedResult = 17;
	        //actual
	        int actualResult = c.doSum(12, 3, 2);
	        assertThat(actualResult).isEqualTo(expectedResult);
	    }

	    @Test
	    void testProduct() {
	        //expected
	        int expectedResult = 6;
	        //actual
	        int actualResult = c.doProduct(3, 2);
	        assertThat(actualResult).isEqualTo(expectedResult);

	    }

	    @Test
	    void testCompareNums(){
	        //actual result
	        Boolean actualResult = c.compareTwoNums(3, 3);
	        assertThat(actualResult).isTrue();
	    }
}
