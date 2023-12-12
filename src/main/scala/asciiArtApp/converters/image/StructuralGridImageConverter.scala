package asciiArtApp.converters.image

import asciiArtApp.model.image.grid.GridImage
import converters.Converter
import converters.specific.StructuralConverter

class StructuralGridImageConverter[T, V](converter: Converter[T, V])
    extends StructuralConverter[GridImage, T, V](converter) {
  override def convertInner(
    what: GridImage[T],
    conversion: T => V): GridImage[V] =
    what.map(conversion)
}
