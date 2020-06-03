package com.kognia.test.gameoflife.feature;

import com.google.common.collect.Table.Cell;
import com.kognia.test.gameoflife.domain.Board;
import com.kognia.test.gameoflife.domain.Board.BoardBuilder;
import com.kognia.test.gameoflife.domain.STATUS;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewGeneration implements Generation<STATUS> {

  public Board<STATUS> generate(Board<STATUS> board) {
    BoardBuilder builder = Board.builder();
    board.rowCellSet().stream().parallel().forEach(c -> generateAndSet(board, builder, c));
    return builder.build();
  }

  private void generateAndSet(
      Board<STATUS> board, BoardBuilder builder, Cell<Integer, Integer, STATUS> c) {
    STATUS newStatus = generate(board, c.getRowKey(), c.getColumnKey());
    builder.set(c.getRowKey(), c.getColumnKey(), newStatus);
  }

  @Override
  public STATUS generate(Board<STATUS> board, Integer x, Integer y) {
    Map<STATUS, Long> counters =
        board.getNeighbours(x, y).stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    counters.putIfAbsent(STATUS.ALIVE, 0L);
    counters.putIfAbsent(STATUS.DEAD, 0L);

    STATUS current = board.getCell(x, y);
    if (current == STATUS.DEAD && counters.get(STATUS.ALIVE) == 3) {
      return STATUS.ALIVE;
    } else if (current == STATUS.ALIVE) {
      if (counters.get(STATUS.ALIVE) < 2 || counters.get(STATUS.ALIVE) > 2) {
        return STATUS.DEAD;
      } else {
        return STATUS.ALIVE;
      }
    }
    return current;
  }
}
