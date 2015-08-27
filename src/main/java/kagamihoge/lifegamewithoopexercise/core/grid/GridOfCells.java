package kagamihoge.lifegamewithoopexercise.core.grid;

import kagamihoge.lifegamewithoopexercise.core.cell.Cell;
import kagamihoge.lifegamewithoopexercise.core.cell.CellFactory;

public class GridOfCells {
    protected Cell[][] cells = new Cell[0][0];
    
    private CellFactory cellFactory;

    public GridOfCells(int width, int height, CellFactory cellFactory) {
        this(width, height, cellFactory, 0.5);
    }
    
    public GridOfCells(int width, int height, CellFactory cellFactory, double seed) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException();
        }

        this.cellFactory = cellFactory;
        this.cells = new Cell[height][width];
        initWithSeed(seed);
    }

    private void initWithSeed(double seed) {
        for (int y = 0; y < getGridHeight(); y++) {
            for (int x = 0; x < getGridWidth(); x++) {
                cells[y][x] = cellFactory.seedCell(seed);
            }
        }
    }

    public boolean isLiveCellIfOutOfBoundsThenDead(int x, int y) {
        if (isOutOfBounds(x, y)) {
            return cellFactory.deadCell().isLive();
        }
        return cells[y][x].isLive();
    }
    
    public void flip(int x, int y) {
        if (isOutOfBounds(x, y)) {
            return;
        }
        cells[y][x] = cells[y][x].flip();
        cells[y][x].afterTransition(x, y);
    }
    
    public GridOfCells generateNext(   ) {
        Neighbours neighbours = new Neighbours(this);
        GridOfCells next = createGridOfCells();
        for (int y = 0; y < getGridHeight(); y++) {
            for (int x = 0; x < getGridWidth(); x++) {
                next.cells[y][x] = cells[y][x].transition(neighbours.countLiveCells(x, y));
                next.cells[y][x].afterTransition(x, y);
            }
        }
        return next;
    }

    private boolean isOutOfBounds(int x, int y) {
        if (x < 0 || y < 0 || x >= getGridWidth() || y >= getGridHeight()) {
            return true;
        }
        return false;
    }

    protected int getGridWidth() {
        return cells[0].length;
    }

    protected int getGridHeight() {
        return cells.length;
    }
    
    protected GridOfCells createGridOfCells() {
        return new GridOfCells(getGridWidth(), getGridHeight(), cellFactory);
    }
}
