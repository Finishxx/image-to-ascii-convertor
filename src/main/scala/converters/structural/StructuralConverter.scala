package converters.structural

import converters.Converter

abstract class StructuralConverter[F[_], T, V](converter: Converter[T, V])
    extends Converter[F[T], F[V]] {

  protected def convertInner(structure: F[T], conversion: T => V): F[V]

  override def convert(what: F[T]): F[V] = convertInner(what, converter.convert)
}
