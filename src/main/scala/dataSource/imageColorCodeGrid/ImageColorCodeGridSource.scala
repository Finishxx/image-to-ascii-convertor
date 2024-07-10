package dataSource.imageColorCodeGrid

import dataSource.DataSource

// Source of images defined by their color code grid - grid with defined width
// and height containing color tightly packed as Ints
// Bits24 - 31 represent the alpha channel(transparency).
// Bits 16 - 23 represent the red channel.
// Bits 8 - 15 represent the green channel.
// Bits 0 - 7 represent the blue channel.
trait ImageColorCodeGridSource extends DataSource[Seq[Seq[Int]]]
