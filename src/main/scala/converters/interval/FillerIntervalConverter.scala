package converters.interval

class FillerIntervalConverter[T](
  elements: Seq[T],
  filler: T,
  from: Int,
  to: Int)
    extends IntervalConverter[T] {
  require(
    elements.size <= to - from + 1,
    "Please provide one element for each number in range!")
  require(to >= from, "To has to be greater than from!")

  private val substitutionFrom: Int = from
  private val substitutionTo: Int =
    if (elements.isEmpty) from else from + elements.size - 1

  private val substitutionConverter: LinearIntervalConverter[T] =
    new LinearIntervalConverter(
      if (elements.isEmpty) Seq(filler) else elements,
      from,
      substitutionTo)

  override def convert(what: Int): T =
    if ((substitutionFrom to substitutionTo).contains(what))
      substitutionConverter.convert(what)
    else if ((substitutionTo to to).contains(what))
      filler
    else
      throw new NoSuchElementException(
        s"$what is out of bounds of this IntervalConverter [$from-$to]")
}
