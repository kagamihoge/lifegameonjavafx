package kagamihoge.lifegamewithoopexercise.core.grid;

public class Neighbours {
    private static final int MAX_CELL_SIZE = 8;

    private GridOfCells cells;

    public Neighbours(GridOfCells cells) {
        this.cells = cells;
    }

    public int countLiveCells(int x, int y) {
        int sumOfLives = 0;

        sumOfLives += countIfLiveCell(x - 1, y - 1);
        sumOfLives += countIfLiveCell(x, y - 1);
        sumOfLives += countIfLiveCell(x + 1, y - 1);

        sumOfLives += countIfLiveCell(x - 1, y);
        sumOfLives += countIfLiveCell(x + 1, y);

        sumOfLives += countIfLiveCell(x - 1, y + 1);
        sumOfLives += countIfLiveCell(x, y + 1);
        sumOfLives += countIfLiveCell(x + 1, y + 1);

        return sumOfLives;
    }

    public int countDeadCells(int x, int y) {
        return MAX_CELL_SIZE - countLiveCells(x, y);
    }

    private int countIfLiveCell(int x, int y) {
        if (cells.isLiveCellIfOutOfBoundsThenDead(x, y)) {
            return 1;
        }
        return 0;
    }
}
