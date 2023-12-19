package converters.interval

import converters.specific.SubstitutionConverter

class LinearIntervalConverter[T](elements: Seq[T], from: Int, to: Int)
    extends IntervalConverter[T] {
  require(to >= from, "To has to be greater than from!")
  require(
    elements.size <= to - from + 1,
    "Please provide one element for each number in range!")
  require(
    elements.nonEmpty,
    "Please provide at least one element!"
  )

  private def createLinearTable(
    elements: Seq[T],
    from: Int,
    to: Int): Map[Int, T] = {
    val numElements = elements.size
    val rangeSize = (to - from + 1) / numElements
    val remainder = (to - from + 1) % numElements

    elements.zipWithIndex.flatMap {
      case (element, index) =>
        val start = from + index * rangeSize + math.min(index, remainder)
        val end = start + rangeSize - 1 + (if (index < remainder) 1 else 0)
        (start to end).map(_ -> element)
    }.toMap
  }

  private val substitutionConverter: SubstitutionConverter[Int, T] =
    new SubstitutionConverter(createLinearTable(elements, from, to))

  override def convert(what: Int): T = substitutionConverter.convert(what)
}
