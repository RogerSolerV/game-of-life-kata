package com.kognia.test.gameoflife.domain;

import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.TreeBasedTable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class Board<T> {

  public static final String BOARD_HEADER = "!";
  private final Table<Integer, Integer, T> board;

  private Board(Table<Integer, Integer, T> board) {
    this.board = board;
  }

  public T getCell(Integer x, Integer y) {
    return board.get(x, y);
  }

  public Set<Cell<Integer, Integer, T>> rowCellSet() {
    return board.cellSet();
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
    return getCell(
        prevValue(x, board.rowKeySet().size()), prevValue(x, board.columnKeySet().size()));
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Board)) {
      return false;
    }
    Board<?> board1 = (Board<?>) o;
    return Objects.equals(board, board1.board);
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder(BOARD_HEADER);
    s.append(System.lineSeparator());
    for (Integer row : board.rowKeySet()) {
      for (Integer col : board.columnKeySet()) {
        s.append(board.get(row, col));
      }
      s.append(System.lineSeparator());
    }
    return s.toString();
  }

  public static BoardBuilder builder() {
    return new BoardBuilder();
  }

  @Override
  public int hashCode() {
    return Objects.hash(board);
  }

  public static class BoardBuilder<T> {
    private final Table<Integer, Integer, T> board = TreeBasedTable.create();

    public BoardBuilder() {}

    public BoardBuilder<T> addRow(List<T> rows) {
      insertRow(rows);
      return this;
    }

    public BoardBuilder<T> addAllRows(List<List<T>> rows) {
      return addAllRows(rows.stream());
    }

    public BoardBuilder<T> addAllRows(Stream<List<T>> rows) {
      rows.forEach(this::insertRow);
      return this;
    }

    public BoardBuilder<T> set(Integer x, Integer y, T val) {
      board.put(x, y, val);
      return this;
    }

    protected void insertRow(List<T> values) {
      int rowNumber = board.rowKeySet().size();
      int y = 0;
      for (T val : values) {
        board.put(rowNumber, y, val);
        y++;
      }
    }

    public Board<T> build() {
      return new Board<>(board);
    }
  }
}
