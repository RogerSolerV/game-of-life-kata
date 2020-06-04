package com.kognia.test.gameoflife.feature;

import com.kognia.test.gameoflife.domain.Board;

@FunctionalInterface
public interface BoardGeneration<T> {

  Board<T> generate(Board<T> board);
}
