package commandParser
import commandParser.model.{Command, CommandFlag, CommandName}

class CommandParserImpl extends CommandParser {
  override def parse(args: Seq[String]): Command = {

    val nameAndFlags: (Seq[String], Seq[String]) =
      args.splitAt(args.indexWhere(_.startsWith("--")))

    val flags: Seq[String] = nameAndFlags._2

    val commandName: CommandName = CommandName(nameAndFlags._1)

    val folded: Seq[Seq[String]] = flags
      .foldLeft(Seq(Seq.empty[String])) { (acc, elem) =>
        if (elem.startsWith("--"))
          acc :+ Seq(elem.substring(2))
        else
          acc.init :+ (acc.last :+ elem)
      }
      .tail

    val commandFlags: Seq[CommandFlag] =
      folded.map(seq => CommandFlag(seq.head, seq.tail))

    Command(commandName, commandFlags)
  }
}
