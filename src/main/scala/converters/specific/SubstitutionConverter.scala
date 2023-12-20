package converters.specific

import converters.Converter

/**
 * Maps elements from T to V using a Map[T, V]
 *
 * @param substitution Substitution map
 * @tparam T Type being converted
 * @tparam V Type which is being converted to
 */
class SubstitutionConverter[T, V](substitution: Map[T, V])
    extends Converter[T, V] {
  override def convert(what: T): V = substitution.get(what) match {
    case Some(value) => value
    case None =>
      throw new IllegalArgumentException(
        s"Could not find $what in substitution table")
  }
}
