package com.kognia.test.gameoflife.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  void testInserts() {
    Board<String> board =
        Board.builder()
            .set(0, 0, "1")
            .set(0, 1, "2")
            .set(0, 2, "3")
            .set(1, 0, "4")
            .set(1, 1, "5")
            .set(1, 2, "6")
            .set(2, 0, "7")
            .set(2, 1, "8")
            .set(2, 2, "9")
            .build();

    Board<String> board2 = getOneToNineBoard();

    assertEquals(board, board);
    assertEquals(board, board2);
    assertNotEquals(board, "A");
  }

  @Test
  void testCompassNeighbours() {
    Board<String> board = getOneToNineBoard();

    assertEquals("7", board.getNorth(0, 0));
    assertEquals("1", board.getNorth(1, 0));
    assertEquals("4", board.getNorth(2, 0));

    assertEquals("4", board.getSouth(0, 0));
    assertEquals("7", board.getSouth(1, 0));
    assertEquals("1", board.getSouth(2, 0));

    assertEquals("2", board.getEast(0, 0));
    assertEquals("5", board.getEast(1, 0));
    assertEquals("8", board.getEast(2, 0));

    assertEquals("3", board.getWest(0, 0));
    assertEquals("6", board.getWest(1, 0));
    assertEquals("9", board.getWest(2, 0));

    assertEquals("2", board.getNorth(1, 1));
    assertEquals("3", board.getNorthEast(1, 1));
    assertEquals("6", board.getEast(1, 1));
    assertEquals("9", board.getSouthEast(1, 1));
    assertEquals("8", board.getSouth(1, 1));
    assertEquals("7", board.getSouthWest(1, 1));
    assertEquals("4", board.getWest(1, 1));
    assertEquals("1", board.getNorthWest(1, 1));
  }

  @Test
  void testNeighbours() {
    Board<String> board = getOneToNineBoard();

    Set<String> neighbours = new HashSet<>(board.getNeighbours(1, 1));
    assertEquals(Set.of("1", "2", "3", "4", "6", "7", "8", "9"), neighbours);
  }

  private Board<String> getOneToNineBoard() {
    return Board.builder()
        .addRow(List.of("1", "2", "3"))
        .addRow(List.of("4", "5", "6"))
        .addRow(List.of("7", "8", "9"))
        .build();
  }
}
