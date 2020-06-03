package com.kognia.test.gameoflife.feature;

import com.kognia.test.gameoflife.domain.Board;
import com.kognia.test.gameoflife.domain.STATUS;

public class NewGeneration implements Generation<Board<STATUS>> {

  @Override
  public Board<STATUS> generate(Board<STATUS> board) {
    return null;
  }
}
