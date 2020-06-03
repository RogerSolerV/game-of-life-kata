package com.kognia.test.gameoflife.feature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.kognia.test.gameoflife.domain.Board;
import com.kognia.test.gameoflife.domain.STATUS;
import java.util.List;
import org.junit.jupiter.api.Test;

class NewGenerationTest {

  @Test
  void generation() {
    Board<STATUS> board = new Board<>();
    board.insertRow(
        List.of(STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD));
    board.insertRow(
        List.of(STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD));
    board.insertRow(
        List.of(STATUS.DEAD, STATUS.DEAD, STATUS.ALIVE, STATUS.ALIVE, STATUS.ALIVE, STATUS.DEAD));
    board.insertRow(
        List.of(STATUS.DEAD, STATUS.ALIVE, STATUS.ALIVE, STATUS.ALIVE, STATUS.DEAD, STATUS.DEAD));
    board.insertRow(
        List.of(STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD));
    board.insertRow(
        List.of(STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD, STATUS.DEAD));

    System.out.println(board);
    System.out.println("--------------------------------------");
    NewGeneration newGen = new NewGeneration();
    Board<STATUS> newBoard = newGen.generate(board);
    System.out.println(newBoard);
  }

  @Test
  void cellGeneration() {
    Board<STATUS> board = new Board<>();
    board.insertRow(List.of(STATUS.DEAD, STATUS.DEAD, STATUS.DEAD));
    board.insertRow(List.of(STATUS.DEAD, STATUS.DEAD, STATUS.ALIVE));
    board.insertRow(List.of(STATUS.DEAD, STATUS.ALIVE, STATUS.ALIVE));
    board.insertRow(List.of(STATUS.DEAD, STATUS.DEAD, STATUS.DEAD));

    NewGeneration newGen = new NewGeneration();
    assertEquals(STATUS.DEAD, newGen.generate(board, 0, 0));
    assertEquals(STATUS.DEAD, newGen.generate(board, 0, 2));
    assertEquals(STATUS.ALIVE, newGen.generate(board, 1, 0));
    assertEquals(STATUS.ALIVE, newGen.generate(board, 1, 1));
    assertEquals(STATUS.ALIVE, newGen.generate(board, 1, 2));
    assertEquals(STATUS.DEAD, newGen.generate(board, 2, 0));
    assertEquals(STATUS.DEAD, newGen.generate(board, 3, 0));
    assertEquals(STATUS.ALIVE, newGen.generate(board, 3, 1));
    assertEquals(STATUS.DEAD, newGen.generate(board, 3, 2));
    assertThrows(NullPointerException.class, () -> newGen.generate(board, 3, 3));
  }
}
