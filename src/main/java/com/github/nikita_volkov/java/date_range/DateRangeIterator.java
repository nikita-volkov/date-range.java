package com.github.nikita_volkov.java.date_range;

import java.time.LocalDate;
import java.util.Iterator;

/**
 * Inclusive date range.
 */
public final class DateRangeIterator implements Iterator<LocalDate> {

  private final DateRange dateRange;
  private boolean hasNext;
  private LocalDate next;

  public DateRangeIterator(DateRange dateRange) {
    this.dateRange = dateRange;
    hasNext = true;
    next = dateRange.from;
  }

  private void preiterate(){
    if (hasNext) {
      next = next.plusDays(1);
      if (next.isAfter(dateRange.to)) {
        next = null;
        hasNext = false;
      }
    }
  }

  @Override
  public boolean hasNext() {
    return hasNext;
  }

  @Override
  public LocalDate next() {
    LocalDate result = next;
    preiterate();
    return result;
  }

}
