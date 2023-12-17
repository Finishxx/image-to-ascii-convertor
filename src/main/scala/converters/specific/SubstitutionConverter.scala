package converters.specific

import converters.Converter

class SubstitutionConverter[T, V](substitution: Map[T, V])
    extends Converter[T, V] {
  override def convert(what: T): V = substitution(what)
}