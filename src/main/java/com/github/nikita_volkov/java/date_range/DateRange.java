package com.github.nikita_volkov.java.date_range;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Inclusive date range.
 */
public final class DateRange implements Serializable {

  private static final long serialVersionUID = 1;

  public final LocalDate from;
  public final LocalDate to;

  private DateRange(LocalDate from, LocalDate to) {
    this.from = from;
    this.to = to;
  }

  public static DateRange single(LocalDate date) {
    return new DateRange(date, date);
  }

  /**
   * Construct, while throwing an exception in case the input values are incorrect.
   */
  public static DateRange validated(LocalDate from, LocalDate to) throws IllegalArgumentException {
    if (to.isBefore(from)) throw new IllegalArgumentException("'to' is not after 'from'");
    return new DateRange(from, to);
  }

  public static Optional<DateRange> validatedOptional(LocalDate from, LocalDate to) {
    return to.isBefore(from) ? Optional.empty() : Optional.of(new DateRange(from, to));
  }

  /**
   * Construct, sidestepping the validation.
   * Only use this function, when you're sure the values are correct.
   */
  public static DateRange unvalidated(LocalDate from, LocalDate to) {
    return new DateRange(from, to);
  }

}
