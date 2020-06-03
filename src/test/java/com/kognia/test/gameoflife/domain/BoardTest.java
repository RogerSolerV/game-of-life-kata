package com.kognia.test.gameoflife.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  void testInserts() {
    Board<String> board = new Board<>();
    board.set(0, 0, "1");
    board.set(0, 1, "2");
    board.set(0, 2, "3");

    board.set(1, 0, "4");
    board.set(1, 1, "5");
    board.set(1, 2, "6");

    board.set(2, 0, "7");
    board.set(2, 1, "8");
    board.set(2, 2, "9");

    Board<String> board2 = new Board<>();
    board2.insertRow(List.of("1", "2", "3"));
    board2.insertRow(List.of("4", "5", "6"));
    board2.insertRow(List.of("7", "8", "9"));

    assertEquals(board, board2);
  }

  @Test
  void testNeighbours() {
    Board<String> board = new Board<>();
    board.insertRow(List.of("1", "2", "3"));
    board.insertRow(List.of("4", "5", "6"));
    board.insertRow(List.of("7", "8", "9"));

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

    Set<String> neighbours = new HashSet<>(board.getNeighbours(1, 1));
    assertEquals(Set.of("1", "2", "3", "4", "6", "7", "8", "9"), neighbours);
  }
}
