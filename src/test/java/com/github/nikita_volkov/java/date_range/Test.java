package com.github.nikita_volkov.java.date_range;

import com.github.nikita_volkov.java.iterations.LinkedListIteration;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.util.*;

public class Test extends TestCase {

  public void testIterator() {
    Iterator<LocalDate> iterator = new DateRangeIterator(DateRange.unvalidated(LocalDate.of(2016, 10, 2), LocalDate.of(2016, 10, 7)));
    LinkedList<LocalDate> list = new LinkedListIteration<LocalDate>().consume(iterator);
    assertTrue(list.contains(LocalDate.of(2016, 10, 2)));
    assertTrue(list.contains(LocalDate.of(2016, 10, 7)));
    assertTrue(!list.contains(LocalDate.of(2016, 10, 8)));
    assertTrue(!list.contains(LocalDate.of(2016, 10, 1)));
  }

}