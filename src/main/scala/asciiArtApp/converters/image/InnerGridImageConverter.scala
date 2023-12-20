package asciiArtApp.converters.image

import asciiArtApp.model.image.grid.GridImage
import converters.Converter

/**
 * Converts all inner elements of a GridImage[T] onto GridImage[V] using provided converter
 *
 * @param converter Converter which is applied to individual elements of GridImage
 * @tparam T Inner type of GridImage[T], which we expect as input
 * @tparam V Inner type of GridImage[V], which we convert to
 */
class InnerGridImageConverter[T, V](converter: Converter[T, V])
    extends Converter[GridImage[T], GridImage[V]] {
  override def convert(what: GridImage[T]): GridImage[V] =
    what.map(converter.convert)
}
