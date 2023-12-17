package exporters

import exporters.text.StreamTextExporter
import org.scalatest.FunSuite

import java.io.ByteArrayOutputStream

// Taken from example semester work by Martin Drozdík
class StreamTextTests extends FunSuite {
  test("Write") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.export("Ahoj")

    assert(stream.toString("UTF-8") == "Ahoj")
  }
}
