package converters.interval

import converters.Converter

/**
 * Converts intervals of Int into T
 *
 * @tparam T Type being converted
 */
trait IntervalConverter[T] extends Converter[Int, T]
