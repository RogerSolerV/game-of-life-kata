package com.kognia.test.gameoflife;

import com.kognia.test.gameoflife.domain.Board;
import com.kognia.test.gameoflife.domain.STATUS;
import com.kognia.test.gameoflife.io.LinesToBoardConverter;

public class GameOfLifeRunner {

  public static void main(String[] args) throws Exception {
    Board<STATUS> board = LinesToBoardConverter.readBoard("board.life");
    System.out.println(board);
  }
}
