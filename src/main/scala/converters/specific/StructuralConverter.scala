package converters.specific

import converters.Converter

abstract class StructuralConverter[F[_], T, V](converter: Converter[T, V])
    extends Converter[F[T], F[V]] {

  def convertInner(value: F[T], conversion: T => V): F[V] //abstract

  override def convert(what: F[T]): F[V] = convertInner(what, converter.convert)
}
