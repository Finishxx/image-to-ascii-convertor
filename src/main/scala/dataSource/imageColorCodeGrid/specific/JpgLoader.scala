package dataSource.imageColorCodeGrid.specific

import dataSource.imageColorCodeGrid.ImageColorCodeGridSource
import dataSource.imageColorCodeGrid.imageIo.ImageLoader

import java.io.File

class JpgLoader(file: File) extends ImageColorCodeGridSource {
  override def provide(): Seq[Seq[Int]] =
    new ImageLoader(file).provide()
}
