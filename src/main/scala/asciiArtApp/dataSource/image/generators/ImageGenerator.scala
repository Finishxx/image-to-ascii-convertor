package asciiArtApp.dataSource.image.generators

import asciiArtApp.model.image.Image
import dataSource.generators.Generator

/**
 * Superclass of Generators, which generate Images
 * @tparam T Type of the Image
 */
trait ImageGenerator[T <: Image] extends Generator[T]
