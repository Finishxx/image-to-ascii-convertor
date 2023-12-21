package commandParser.model

case class Command(names: CommandName, flags: Seq[CommandFlag])
