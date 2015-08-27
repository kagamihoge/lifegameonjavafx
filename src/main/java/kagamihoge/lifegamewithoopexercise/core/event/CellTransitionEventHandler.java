package kagamihoge.lifegamewithoopexercise.core.event;

import kagamihoge.lifegamewithoopexercise.core.cell.Cell;

public interface CellTransitionEventHandler {
    void handle(int x, int y, Cell cell);
}
