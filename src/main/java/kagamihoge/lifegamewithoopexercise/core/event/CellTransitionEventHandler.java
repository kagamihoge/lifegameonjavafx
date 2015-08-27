package kagamihoge.lifegamewithoopexercise.core.event;

import kagamihoge.lifegameonjavafx.core.cell.Cell;

public interface CellTransitionEventHandler {
    void handle(int x, int y, Cell cell);
}
