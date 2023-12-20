package asciiArtApp.converters.color.toGreyscale.specific

import asciiArtApp.converters.color.toGreyscale.Rgb24BitToGreyscale8BitColorConverter

/**
 * Default weighted Rgb24Bit to Greyscale8Bit using recommended weights
 */
class WeightedRgb24BitToGreyscale8BitColorConverter
    extends Rgb24BitToGreyscale8BitColorConverter(0.3, 0.59, 0.11)
