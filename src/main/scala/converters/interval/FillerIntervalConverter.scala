package converters.interval

/**
 * Maps range of Ints defined by from and to elements one-to-one with elements,
 * if not possible maps the rest with filler
 *
 * @param elements Elements being mapped to
 * @param filler Filler element, which leftover unmapped ints are mapped to
 * @param from Inclusive start of range
 * @param to Inclusive end of range
 * @tparam T Type being converted into i.e. type of elements
 */
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
      throw new IllegalArgumentException(
        s"$what is out of bounds of this IntervalConverter [$from-$to]")
}
