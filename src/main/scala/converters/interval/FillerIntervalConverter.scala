package converters.interval

class FillerIntervalConverter[T](
  elements: Seq[T],
  filler: T,
  from: Int,
  to: Int)
    extends IntervalConverter[T] {
  require(
    elements.size < to - from + 1,
    "Please provide smaller sized elements than from-to range, for filler to be relevant at all!")

  val substitutionConverter: LinearIntervalConverter[T] =
    new LinearIntervalConverter(
      elements,
      elements.indices.start,
      elements.indices.end)
  override def convert(what: Int): T =
    if (what >= from && what <= elements.indices.end)
      substitutionConverter.convert(what)
    else if (what >= from && what <= to)
      filler
    else
      throw new NoSuchElementException(
        s"$what is out of bounds of this IntervalConverter [$from-$to]")
}
