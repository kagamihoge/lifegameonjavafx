package kagamihoge.lifegamewithoopexercise.core.grid;

import static kagamihoge.lifegamewithoopexercise.core.cell.CellFactoryForTest.cellFactory;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GridOfCellsTest {
    
    @Test
    public void testSeedIsAllDead() {
        String[] allDead = {
            "----",
            "----",
            "----",
            "----",
        };
        
        GridOfCellsForTest cells = new GridOfCellsForTest(4, 4, 0.0);
        cells = (GridOfCellsForTest)cells.generateNext();
        cells.assertWithMatchCellString(allDead);
    }
    
    @Test
    public void testSeedIsAllLive() {
        String[] allLive = {
            "****",
            "****",
            "****",
            "****",
        };
        
        GridOfCellsForTest cells = new GridOfCellsForTest(4, 4, 1.0);
        cells = (GridOfCellsForTest)cells.generateNext();
        cells.assertWithMatchCellString(allLive);
    }
    
    @Test
    public void testWithBlockPattern() {
        String[] block1 = {
            "----",
            "-**-",
            "-**-",
            "----",
        };
        assertWithTestPattern(block1);
        String[] block2 = {
            "------",
            "--**--",
            "-*--*-",
            "--**--",
            "------",
        };
        assertWithTestPattern(block2);
        String[] block3 = {
            "-----",
            "-**--",
            "-*-*-",
            "--*--",
            "-----",
        };
        assertWithTestPattern(block3);
        String[] block4 = {
            "-----",
            "--**-",
            "-*-*-",
            "-**--",
            "-----",
        };
        assertWithTestPattern(block4);
        String[] block5 = {
            "------",
            "--**--",
            "-*--*-",
            "-*--*-",
            "--**--",
            "------",
        };
        assertWithTestPattern(block5);
    }
    
    @Test
    public void testWithSindouPattern1() {
        String[] from = {
            "-----",
            "-----",
            "-***-",
            "-----",
            "-----"
        };
        String[] to = {
            "-----",
            "--*--",
            "--*--",
            "--*--",
            "-----"
        };
        assertWithTestPattern(from, to);
        assertWithTestPattern(to, from);
    }
    
    @Test
    public void testWithSindouPattern2() {
        String[] from = {
            "------",
            "--*---",
            "--**--",
            "--**--",
            "---*--",
            "------"
        };
        String[] to = {
            "------",
            "--**--",
            "-*----",
            "----*-",
            "--**--",
            "------"
        };
        assertWithTestPattern(from, to);
        assertWithTestPattern(to, from);
    }
    
    @Test
    public void testWithSindouPattern3() {
        String[] from = {
            "------",
            "-**---",
            "-**---",
            "---**-",
            "---**-",
            "------"
        };
        String[] to = {
            "------",
            "-**---",
            "-*----",
            "----*-",
            "---**-",
            "------"
        };
        assertWithTestPattern(from, to);
        assertWithTestPattern(to, from);
    }
    
    @Test
    public void testWithSindouPattern4() {
        String[] from = {
            "------",
            "--*---",
            "--*-*-",
            "-*-*--",
            "---*--",
            "------"
        };
        String[] to = {
            "------",
            "---*--",
            "-**---",
            "---**-",
            "--*---",
            "------"
        };
        assertWithTestPattern(from, to);
        assertWithTestPattern(to, from);
    }
    
    private void assertWithTestPattern(String[] from, String[] to) {
        GridOfCellsForTest cells = new GridOfCellsForTest(from);
        cells.assertWithMatchCellString(from);
        cells = (GridOfCellsForTest)cells.generateNext();
        cells.assertWithMatchCellString(to);
    }
    
    private void assertWithTestPattern(String[] block) {
        assertWithTestPattern(block, block);
    }

    private static class GridOfCellsForTest extends GridOfCells {
        public GridOfCellsForTest(int width, int height, double seed) {
            super(width, height, cellFactory, seed);
        }
        
        public GridOfCellsForTest(int width, int height) {
            super(width, height, cellFactory);
        }
        
        public GridOfCellsForTest(String[] init) {
            super(init[0].length(), init.length, cellFactory);
            for (int y = 0; y < getGridHeight(); y++) {
                for (int x = 0; x < getGridWidth(); x++) {
                    if ('*' == init[y].charAt(x)) {
                        cells[y][x] = cellFactory.liveCell();
                    } else if ('-' == init[y].charAt(x)) {
                        cells[y][x] = cellFactory.deadCell();
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }

        public void assertWithMatchCellString(String[] forMatchCells) {
            for (int y = 0; y < getGridHeight(); y++) {
                for (int x = 0; x < getGridWidth(); x++) {
                    if ('*' == forMatchCells[y].charAt(x)) {
                        assertThat(cells[y][x].isLive(), is(true));
                    } else if ('-' == forMatchCells[y].charAt(x)) {
                        assertThat(cells[y][x].isLive(), is(false));
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
        
        @Override
        public GridOfCells createGridOfCells() {
            return new GridOfCellsForTest(getGridWidth(), getGridHeight());
        }
    }

    @Test
    public void testIsLiveCellIfOutOfBoundsThenDead() {

        GridOfCells cells = new GridOfCells(1, 1, cellFactory, 0.0);
        cells = cells.generateNext();
        cells.flip(0, 0);

        assertThat(cells.isLiveCellIfOutOfBoundsThenDead(0, 0), is(true));

        assertThat(cells.isLiveCellIfOutOfBoundsThenDead(0, -1), is(false));
        assertThat(cells.isLiveCellIfOutOfBoundsThenDead(0, 1), is(false));

        assertThat(cells.isLiveCellIfOutOfBoundsThenDead(-1, 0), is(false));
        assertThat(cells.isLiveCellIfOutOfBoundsThenDead(-1, -1), is(false));
        assertThat(cells.isLiveCellIfOutOfBoundsThenDead(-1, 1), is(false));

        assertThat(cells.isLiveCellIfOutOfBoundsThenDead(1, 0), is(false));
        assertThat(cells.isLiveCellIfOutOfBoundsThenDead(1, -1), is(false));
        assertThat(cells.isLiveCellIfOutOfBoundsThenDead(1, 1), is(false));
    }

    @Test
    public void testInitWithDeadCells() {
        int width = 10;
        int height = 20;

        GridOfCells cells = new GridOfCells(10, 20, cellFactory);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                assertThat(cells.isLiveCellIfOutOfBoundsThenDead(x, y), is(false));
                ;
            }
        }
    }

}
