package asciiArtApp.converters.color.toAscii.intervalConverters

import converters.Converter

// Maps intervals of numbers into T
trait IntervalConverter[T] extends Converter[Int, T]
