package com.kognia.test.gameoflife.io;

import com.kognia.test.gameoflife.domain.Board;
import com.kognia.test.gameoflife.domain.STATUS;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LinesToBoardConverter {

  public static Board<STATUS> readBoard(String fileName) throws IOException {
    return new Board(
        ReadGameOfLifeFile.readFile(fileName)
            .filter(LinesToBoardConverter::nonHeaderLine)
            .map(LinesToBoardConverter::convertLine)
            .collect(Collectors.toUnmodifiableList()));
  }

  private static boolean nonHeaderLine(String s) {
    return !Objects.equals(s, Board.BOARD_HEADER);
  }

  public static List<STATUS> convertLine(String line) {
    return line.chars()
        .mapToObj(c -> (char) c)
        .map(STATUS::valueOfChar)
        .collect(Collectors.toUnmodifiableList());
  }
}
