package converters.specific

import converters.Converter

class ChainedConverter[T, V, U](first: Converter[T, V], second: Converter[V, U])
    extends Converter[T, U] {
  override def convert(what: T): U = second.convert(first.convert(what))
}
