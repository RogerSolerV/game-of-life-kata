package com.kognia.test.gameoflife;

import com.kognia.test.gameoflife.domain.Board;
import com.kognia.test.gameoflife.domain.STATUS;
import com.kognia.test.gameoflife.feature.NewGeneration;
import com.kognia.test.gameoflife.io.StatusBoardReader;

public class GameOfLifeRunner {

  public static void main(String[] args) throws Exception {
    Board<STATUS> board = StatusBoardReader.readBoard("board.life");
    System.out.println(board);

    NewGeneration moveOn = new NewGeneration();
    System.out.println("------------------------------------");
    Board<STATUS> secondGeneration = moveOn.generate(board);
    System.out.println(secondGeneration);

    System.out.println("------------------------------------");
    Board<STATUS> thirdGeneration = moveOn.generate(secondGeneration);
    System.out.println(thirdGeneration);

    // TODO stuff
    // Make Board final with Builder
    // NewGeneration class make up, name, static?
    // Generate in threadpool / parallel
    // Unit test coverage
    // Read args on main
    // parameter for number of generations
    // Small class / connection diagram
    // explain milestones done, 1-3 not 2! :)
  }
}
