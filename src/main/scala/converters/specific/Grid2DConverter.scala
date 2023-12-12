package converters.specific

import converters.Converter

abstract class Grid2DConverter[T, V](converter: Converter[T, V])
    extends Converter[Iterable[Iterable[T]], Iterable[Iterable[V]]] {

  override def convert(what: Iterable[Iterable[T]]): Iterable[Iterable[V]] =
    what.map(_.map(converter.convert))
}
