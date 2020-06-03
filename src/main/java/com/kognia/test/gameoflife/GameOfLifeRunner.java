package com.kognia.test.gameoflife;

import com.kognia.test.gameoflife.domain.Board;
import com.kognia.test.gameoflife.domain.STATUS;
import com.kognia.test.gameoflife.feature.NewGeneration;
import com.kognia.test.gameoflife.io.LinesToBoardConverter;

public class GameOfLifeRunner {

  public static void main(String[] args) throws Exception {
    Board<STATUS> board = LinesToBoardConverter.readBoard("board.life");
    System.out.println(board);

    NewGeneration moveOn = new NewGeneration();
    System.out.println("------------------------------------");
    Board<STATUS> secondGeneration = moveOn.generate(board);
    System.out.println(secondGeneration);

    System.out.println("------------------------------------");
    Board<STATUS> thirdGeneration = moveOn.generate(secondGeneration);
    System.out.println(thirdGeneration);
  }
}
