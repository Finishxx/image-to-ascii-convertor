package commandParser

import commandParser.model.{Command, CommandFlag, CommandName}

trait CommandParser {
  def parse(command: Seq[String]): Command

}
