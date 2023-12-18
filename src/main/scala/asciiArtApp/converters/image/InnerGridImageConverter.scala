package asciiArtApp.converters.image

import asciiArtApp.model.image.grid.GridImage
import converters.Converter

class InnerGridImageConverter[T, V](converter: Converter[T, V])
    extends Converter[GridImage[T], GridImage[V]] {
  override def convert(what: GridImage[T]): GridImage[V] =
    what.map(converter.convert)
}
