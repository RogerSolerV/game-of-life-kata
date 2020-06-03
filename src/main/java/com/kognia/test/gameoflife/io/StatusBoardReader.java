package com.kognia.test.gameoflife.io;

import com.kognia.test.gameoflife.domain.Board;
import com.kognia.test.gameoflife.domain.STATUS;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatusBoardReader {

  public static Board<STATUS> readBoard(String fileName) throws IOException {
    return Board.builder().addAllRows(prepareBoard(getFileLinesStream(fileName))).build();
  }

  protected static Stream<String> getFileLinesStream(String fileName) throws IOException {
    return ReadGameOfLifeFile.readFile(fileName);
  }

  protected static List<List<STATUS>> prepareBoard(Stream<String> allLines) {
    return allLines
        .filter(StatusBoardReader::nonHeaderLine)
        .map(StatusBoardReader::convertLine)
        .collect(Collectors.toUnmodifiableList());
  }

  protected static boolean nonHeaderLine(String s) {
    return !Objects.equals(s, Board.BOARD_HEADER);
  }

  protected static List<STATUS> convertLine(String line) {
    return line.chars()
        .mapToObj(c -> (char) c)
        .map(STATUS::valueOfChar)
        .collect(Collectors.toUnmodifiableList());
  }
}
