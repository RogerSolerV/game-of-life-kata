package com.kognia.test.gameoflife.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadGameOfLifeFile {

  public static Stream<String> readFile(String fileName) throws IOException {
    return Files.lines(Paths.get(fileName));
  }
}
