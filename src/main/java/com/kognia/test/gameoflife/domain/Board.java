package com.kognia.test.gameoflife.domain;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Board<T> {

  private final Table<Integer, Integer, T> board = TreeBasedTable.create();

  public void set(Integer x, Integer y, T val) {
    board.put(x, y, val);
  }

  public T getCell(Integer x, Integer y) {
    return board.get(x, y);
  }

  public List<T> getNeighbours(Integer x, Integer y) {
    return List.of(
        getNorth(x, y),
        getNorthEast(x, y),
        getEast(x, y),
        getSouthEast(x, y),
        getSouth(x, y),
        getSouthWest(x, y),
        getWest(x, y),
        getNorthWest(x, y));
  }

  public T getNorth(Integer x, Integer y) {
    return getCell(prevValue(x, board.rowKeySet().size()), y);
  }

  public T getNorthEast(Integer x, Integer y) {
    return getCell(
        prevValue(x, board.rowKeySet().size()), nextValue(y, board.columnKeySet().size()));
  }

  public T getEast(Integer x, Integer y) {
    return getCell(x, nextValue(y, board.columnKeySet().size()));
  }

  public T getSouthEast(Integer x, Integer y) {
    return getCell(
        nextValue(x, board.rowKeySet().size()), nextValue(y, board.columnKeySet().size()));
  }

  public T getSouth(Integer x, Integer y) {
    return getCell(nextValue(x, board.rowKeySet().size()), y);
  }

  public T getSouthWest(Integer x, Integer y) {
    return getCell(
        nextValue(x, board.rowKeySet().size()), prevValue(y, board.columnKeySet().size()));
  }

  public T getWest(Integer x, Integer y) {
    return getCell(x, prevValue(y, board.columnKeySet().size()));
  }

  public T getNorthWest(Integer x, Integer y) {
    return getCell(prevValue(x, board.rowKeySet().size()), prevValue(x, board.rowKeySet().size()));
  }

  public static Integer nextValue(Integer x, Integer rowSize) {
    if (x == rowSize - 1) {
      return 0;
    }
    return x + 1;
  }

  public static Integer prevValue(Integer x, Integer rowSize) {
    if (x == 0) {
      return rowSize - 1;
    }
    return x - 1;
  }
}
