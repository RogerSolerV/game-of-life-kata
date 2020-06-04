package com.kognia.test.gameoflife;

import com.kognia.test.gameoflife.domain.Board;
import com.kognia.test.gameoflife.domain.STATUS;
import com.kognia.test.gameoflife.feature.StatusBoardGeneration;
import com.kognia.test.gameoflife.io.StatusBoardReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class GameOfLifeRunner {

  public static final int DEFAULT_GENERATIONS = 1;

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      printParamsMessage(args);
      System.exit(1);
    }
    String fileName = null;
    int generations = DEFAULT_GENERATIONS;
    try {
      fileName = getString(args, 1);
      generations = getPositiveIntOrDefault(args, 2, DEFAULT_GENERATIONS);
    } catch (Exception e) {
      e.printStackTrace();
      printParamsMessage(args);
      System.exit(1);
    }

    System.out.println(
        new StringBuilder()
            .append("File name: ")
            .append(fileName)
            .append(". Generations to run: ")
            .append(generations)
            .toString());
    Board<STATUS> board = StatusBoardReader.readBoard(fileName);
    System.out.println(board);

    StatusBoardGeneration moveOn = new StatusBoardGeneration();
    for (int i = 0; i < generations; i++) {
      System.out.println("Generation[" + (i + 1) + "]------------------------------------");
      Board<STATUS> newGeneration = moveOn.generate(board);
      System.out.println(newGeneration);
    }
  }

  protected static void printParamsMessage(String[] args) {
    System.err.println(
        new StringBuilder()
            .append("Parameters not found: ")
            .append(Arrays.asList(args))
            .append(System.lineSeparator())
            .append("First parameter must be 'file name' (relative or absolute).")
            .append(System.lineSeparator())
            .append(
                "Second parameter is optional (default: 1), and will allow you to chose how many generations will be triggered.")
            .toString());
  }

  protected static String getString(String[] args, int position) {
    if (args.length >= position) {
      return args[position - 1];
    }
    throw new NoSuchElementException("Missing parameter 1, file name");
  }

  protected static int getPositiveIntOrDefault(String[] args, int position, int defaultVal) {
    if (args.length >= position) {
      int i = Integer.parseInt(args[position - 1]);
      if (i > 0) {
        return i;
      }
      System.err.println("Ignoring wrong number of generations: " + i);
    }
    return defaultVal;
  }
}
