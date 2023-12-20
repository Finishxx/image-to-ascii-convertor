package asciiArtApp.model.image.grid.raster

import asciiArtApp.model.color.rgb.RgbColor
import asciiArtApp.model.image.grid.GridImageAs2DSeq

/**
 * RgbColorImage represented using 2DSeq of RgbColors
 * @param grid 2DSeq representing the image
 */
class RgbColorImageAs2DSeq(grid: Seq[Seq[RgbColor]])
    extends GridImageAs2DSeq[RgbColor](grid)
    with RgbColorImage[RgbColor]
