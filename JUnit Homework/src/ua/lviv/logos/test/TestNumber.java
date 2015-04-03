package ua.lviv.logos.test;

import static org.junit.Assert.*;

import org.junit.*;

import ua.lviv.logos.Number;

public class TestNumber {
  Number number;
@Before
public void createNumberObject(){
   number = new Number();
}

@Test
public void testIsTotal(){
  assertTrue(number.isTotal(2));
}
@Deprecated
public void testDiv(){
  assertEquals(number.divOnTwo(2), 1.0);
}
@Deprecated
public void testSqrt(){
  assertEquals(number.getSqrt(4), 2.0);
}


}
