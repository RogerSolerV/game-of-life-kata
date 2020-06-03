package com.kognia.test.gameoflife.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.kognia.test.gameoflife.domain.STATUS;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StatusBoardReaderTest {

  @Test
  void testHeader() {
    assertTrue(StatusBoardReader.nonHeaderLine(""));
    assertTrue(StatusBoardReader.nonHeaderLine("."));
    assertTrue(StatusBoardReader.nonHeaderLine("....."));
    assertFalse(StatusBoardReader.nonHeaderLine("!"));
  }

  @Test
  void testLineToStatus() {
    assertEquals(List.of(STATUS.DEAD), StatusBoardReader.convertLine("."));
    assertEquals(List.of(STATUS.ALIVE), StatusBoardReader.convertLine("O"));
    assertThrows(NullPointerException.class, () -> StatusBoardReader.convertLine(null));
    assertThrows(IllegalArgumentException.class, () -> StatusBoardReader.convertLine("Hello"));
  }

  @Test
  void testPrepareBoard() {
    assertEquals(
        List.of(
            List.of(STATUS.DEAD, STATUS.DEAD, STATUS.DEAD),
            List.of(STATUS.DEAD, STATUS.ALIVE, STATUS.DEAD)),
        StatusBoardReader.prepareBoard(Stream.of("...", ".O.")));
  }
}
