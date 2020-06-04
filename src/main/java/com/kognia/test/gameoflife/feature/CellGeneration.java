package com.kognia.test.gameoflife.feature;

import com.kognia.test.gameoflife.domain.Board;

@FunctionalInterface
public interface CellGeneration<T> {

  T generate(Board<T> board, Integer x, Integer y);
}
