package converters.specific

import converters.Converter

/**
 * Achieves conversion of T -> U by chaining two converters: T -> V and V -> U
 *
 * @param first First converter converting from T -> V
 * @param second Second converter converting from T -> V
 * @tparam T Type being converted
 * @tparam V Intermediate type
 * @tparam U Type being converted to
 */
class ChainedConverter[T, V, U](first: Converter[T, V], second: Converter[V, U])
    extends Converter[T, U] {
  override def convert(what: T): U = second.convert(first.convert(what))
}
