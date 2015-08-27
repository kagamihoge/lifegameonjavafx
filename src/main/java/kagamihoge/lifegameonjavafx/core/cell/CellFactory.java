package kagamihoge.lifegameonjavafx.core.cell;

public interface CellFactory {

    Cell deadCell();

    Cell liveCell();

    Cell seedCell(double seed);
}
