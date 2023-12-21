package Main

import asciiArtApp.console.Action
import asciiArtApp.console.chainable.ChainableAction
import asciiArtApp.console.chainable.`export`.{
  ConsoleExportAction,
  ExportAction,
  FileExportAction
}
import asciiArtApp.console.chainable.filter.{
  FilterAction,
  FlipFilterAction,
  RotateFilterAction,
  ScaleFilterAction
}
import asciiArtApp.console.convert.{
  ConvertAction,
  ConvertCustomTableAction,
  ConvertKnownTableAction
}
import asciiArtApp.console.dataSource.{
  DataSourceAction,
  GenerateAction,
  ImageExtension,
  ImportFromFileAction
}
import asciiArtApp.converters.color.toAscii.default.{
  FillerGreyscale8BitToAsciiConverter,
  LinearGreyscale8BitToAsciiConverter
}
import asciiArtApp.converters.color.toGreyscale.specific.WeightedRgb24BitToGreyscale8BitColorConverter
import asciiArtApp.converters.color.toRgb.{
  BufferedImageToIntGridImageConverter,
  IntAsColorToRgb24BitColorConverter
}
import asciiArtApp.converters.image.ascii.AsciiImageToTextConverter
import asciiArtApp.converters.image.grid.{
  GridImageConverter,
  InnerGridImageConverter
}
import asciiArtApp.dataSource.image.generators.grid.IntGridImageGenerator
import asciiArtApp.dataSource.image.imageIo.ImageIoBufferedImageImporter
import asciiArtApp.filters.image.grid.flip.FlipGridImageFilter
import asciiArtApp.filters.image.grid.rotate.RotateGridImageFilter
import asciiArtApp.filters.image.grid.scale.ScaleGridImageFilter
import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.image.grid.GridImage
import commandParser.model.CommandFlag
import commandParser.{CommandParser, CommandParserImpl}
import converters.specific.ChainedConverter
import dataSource.DataSource
import dataSource.generators.number.StandardLibraryIntGenerator
import dataSource.mixed.ConvertMixedDataSource
import exporters.text.{FileOutputExporter, StdOutputExporter}
import filters.grid.flip.Axis

import java.io.File
import scala.util.Random

object Main extends App {

  val commandName: Seq[String] = "run".split("")

  private def parseActions(args: Seq[String]): Seq[Action] = {

    val commandParser: CommandParser = new CommandParserImpl

    val command = commandParser.parse(args)

    command.names.names match {
      case Seq("run") => _
      case _ =>
        throw new IllegalArgumentException(
          s"Unexpected command name! Expected ${commandName
            .mkString(" ")}, but got ${command.names.names.mkString(" ")}")
    }

    command.flags.map {
      case CommandFlag("image", path) =>
        path match {
          case Seq(path) =>
            path match {
              case jpg if path.endsWith(".jpg") =>
                ImportFromFileAction(jpg, ImageExtension.JPG)
              case png if path.endsWith(".png") =>
                ImportFromFileAction(png, ImageExtension.PNG)
              case gif if path.endsWith(".gif") =>
                ImportFromFileAction(gif, ImageExtension.GIF)
              case _ =>
                throw new IllegalArgumentException(
                  s"image flag received unsupported extension, got $path!")
            }
          case _ =>
            throw new IllegalArgumentException(
              "image flag expects exactly one argument and that is path desired image!")
        }
      case CommandFlag("image-random", _) => GenerateAction()
      case CommandFlag("table-name", arg) =>
        arg match {
          case Seq(name) => ConvertKnownTableAction(name)
          case _ =>
            throw new IllegalArgumentException(
              s"table-name flag expects exactly one argument, got $arg!")
        }
      case CommandFlag("custom-table", arg) =>
        arg match {
          case Seq(table) => ConvertCustomTableAction(table)
          case _ =>
            throw new IllegalArgumentException(
              s"The custom-table flag takes exactly 1 argument, got $arg!")
        }
      case CommandFlag("rotate", arg) =>
        arg match {
          case Seq(degrees) if degrees.toIntOption.isDefined =>
            RotateFilterAction(degrees.toInt)
          case Seq(degrees) =>
            throw new IllegalArgumentException(
              s"rotate expects int as argument, got $degrees")
          case _ =>
            throw new IllegalArgumentException(
              s"rotate flag takes exactly one argument, got $arg")
        }
      case CommandFlag("scale", arg) =>
        arg match {
          case Seq(scale) if scale.toDoubleOption.isDefined =>
            ScaleFilterAction(scale.toDouble)
          case Seq(scale) =>
            throw new IllegalArgumentException(
              s"scale expects double as arguments, got $scale")
          case _ =>
            throw new IllegalArgumentException(
              s"scale takes exactly one argument, got $arg")
        }
      case CommandFlag("flip", arg) =>
        arg match {
          case Seq("x") => FlipFilterAction(Axis.X)
          case Seq("y") => FlipFilterAction(Axis.Y)
          case _ =>
            throw new IllegalArgumentException(
              s"flip takes exactly one argument, got $arg")
        }
      case CommandFlag("output-console", arg) =>
        arg match {
          case Seq() => ConsoleExportAction()
          case _ =>
            throw new IllegalArgumentException(
              s"output-console takes zero arguments, got $arg")
        }
      case CommandFlag("output-file", arg) =>
        arg match {
          case Seq(path) => FileExportAction(path)
          case _ =>
            throw new IllegalArgumentException(
              s"output-file takes exactly one argument, got $arg")
        }
    }
  }

  private def getIntGridImage(
    dataSourceAction: DataSourceAction): DataSource[GridImage[Int]] =
    dataSourceAction match {
      case ImportFromFileAction(path, extension) =>
        extension match {
          case ImageExtension.JPG | ImageExtension.PNG | ImageExtension.GIF =>
            new ConvertMixedDataSource(
              new ImageIoBufferedImageImporter(new File(path)),
              new BufferedImageToIntGridImageConverter)
        }
      case GenerateAction() =>
        new IntGridImageGenerator(
          Random.between(100, 500),
          Random.between(100, 500),
          new StandardLibraryIntGenerator)
    }

  private def getConverter(
    convertAction: ConvertAction): GridImageConverter[Int, AsciiCharacter] = {
    def bourke =
      (
        "bourke",
        "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ".toCharArray
          .map(AsciiCharacter))

    def bourkeSmall =
      ("bourke-small", " .:-=+*#%@".toCharArray.map(AsciiCharacter))

    def nonLinear = ("non-linear", " .:-=+*#%@".toCharArray.map(AsciiCharacter))

    val asciiConverter = convertAction match {
      case ConvertCustomTableAction(table) =>
        new LinearGreyscale8BitToAsciiConverter(
          table.toCharArray.map(AsciiCharacter))
      case ConvertKnownTableAction(bourke._1) =>
        new LinearGreyscale8BitToAsciiConverter(bourke._2)
      case ConvertKnownTableAction(nonLinear._1) =>
        new FillerGreyscale8BitToAsciiConverter(nonLinear._2)
      case ConvertKnownTableAction(bourkeSmall._1) =>
        new LinearGreyscale8BitToAsciiConverter(bourkeSmall._2)
    }

    new InnerGridImageConverter(
      new ChainedConverter(
        new ChainedConverter(
          new IntAsColorToRgb24BitColorConverter,
          new WeightedRgb24BitToGreyscale8BitColorConverter),
        asciiConverter
      ))
  }

  def main(args: Seq[String]): Unit = {

    val actions = parseActions(args)

    val dataSourceAction: DataSourceAction =
      actions.filter(_.isInstanceOf[DataSourceAction]) match {
        case Seq(action: DataSourceAction) => action
        case seq =>
          throw new IllegalArgumentException(
            s"Received ${seq.size} source flags! Please input exactly one!")
      }

    val convertAction: ConvertAction =
      actions.filter(_.isInstanceOf[ConvertAction]) match {
        case Seq(action: ConvertAction) => action
        case seq =>
          throw new IllegalArgumentException(
            s"Received ${seq.size} conversion flags! Please input just one or none!")
      }

    val chainableActions = actions.filter(_.isInstanceOf[ChainableAction])

    val intGridImage: GridImage[Int] =
      getIntGridImage(dataSourceAction).provide()

    var asciiImage: GridImage[AsciiCharacter] =
      getConverter(convertAction).convert(intGridImage)

    val asciiToText = new AsciiImageToTextConverter

    for (action <- chainableActions)
      action match {
        case filterAction: FilterAction =>
          asciiImage = filterAction match {
            case FlipFilterAction(axis) =>
              new FlipGridImageFilter(axis).filter(asciiImage)
            case RotateFilterAction(degrees) =>
              new RotateGridImageFilter(degrees).filter(asciiImage)
            case ScaleFilterAction(scale) =>
              new ScaleGridImageFilter(scale).filter(asciiImage)
          }
        case exportAction: ExportAction =>
          val asciiImageAsText = asciiToText.convert(asciiImage)
          exportAction match {
            case FileExportAction(path) =>
              new FileOutputExporter(new File(path))
            case ConsoleExportAction() =>
              new StdOutputExporter().`export`(asciiImageAsText)
          }
      }

  }
}
