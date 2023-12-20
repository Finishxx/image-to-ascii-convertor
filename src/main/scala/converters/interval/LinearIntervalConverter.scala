package converters.interval

import converters.specific.SubstitutionConverter

/**
 * Maps range of Ints defined by from and to elements arguably as equally as possible
 *
 * If characters can't be mapped truly equally, meaning we can not map equal number
 * of int values to each individual element from elements, maps more int values
 * onto first element and divides the rest equally
 *
 * @param elements Elements being mapped to
 * @param from Inclusive start of range
 * @param to Inclusive end of range
 * @tparam T Type being converted into i.e. type of elements
 */
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
