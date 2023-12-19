package converters.specific

import converters.Converter

class SubstitutionConverter[T, V](substitution: Map[T, V])
    extends Converter[T, V] {
  override def convert(what: T): V = substitution.get(what) match {
    case Some(value) => value
    case None =>
      throw new IllegalArgumentException(
        s"Could not find $what in substitution table")
  }
}
