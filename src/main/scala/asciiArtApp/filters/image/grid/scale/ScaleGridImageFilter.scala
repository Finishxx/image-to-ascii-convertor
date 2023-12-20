package asciiArtApp.filters.image.grid.scale

import asciiArtApp.filters.image.grid.Seq2DToGridImageFilterAdapter
import filters.grid.scale.ScaleSeq2DFilter

class ScaleGridImageFilter[T](factor: Double)
    extends Seq2DToGridImageFilterAdapter[T](new ScaleSeq2DFilter[T](factor))
