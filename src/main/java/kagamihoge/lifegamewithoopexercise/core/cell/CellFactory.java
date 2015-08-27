package kagamihoge.lifegamewithoopexercise.core.cell;

public interface CellFactory {

    Cell deadCell();

    Cell liveCell();

    Cell seedCell(double seed);
}
