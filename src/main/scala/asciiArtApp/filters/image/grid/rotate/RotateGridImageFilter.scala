package asciiArtApp.filters.image.grid.rotate

import asciiArtApp.filters.image.grid.Seq2DToGridImageFilterAdapter
import filters.grid.rotate.RotateSeq2DFilter

class RotateGridImageFilter[T](degrees: Int)
    extends Seq2DToGridImageFilterAdapter[T](new RotateSeq2DFilter[T](degrees))
