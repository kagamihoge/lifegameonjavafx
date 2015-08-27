package kagamihoge.lifegameonjavafx.core.cell;

import static kagamihoge.lifegameonjavafx.core.cell.CellFactoryForTest.cellFactory;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import kagamihoge.lifegamewithoopexercise.core.cell.impl.DeadCell;

public class DeadCellTest {

    @Test
    public void testIsLive() {
        assertThat(new DeadCell(cellFactory).isLive(), is(false));
    }
    
    @Test
    public void testCellTransitionEventHandler() {
        DeadCell cell = new DeadCell(cellFactory);
        cell.setEventListner((x, y, c) -> {
            assertThat(x, is(10));
            assertThat(y, is(0));
            assertThat(c.isLive(), is(false));
        });
        cell.afterTransition(10, 0);
    }

    @Test
    public void testFlip() {
        assertThat(new DeadCell(cellFactory).flip().isLive(), is(true));
    }
    
    @Test
    public void testTransition() {
        DeadCell cell = new DeadCell(cellFactory);
        
        assertThat(cell.transition(0).isLive(), is(false));
        assertThat(cell.transition(1).isLive(), is(false));
        assertThat(cell.transition(2).isLive(), is(false));
        assertThat(cell.transition(3).isLive(), is(true));
        assertThat(cell.transition(4).isLive(), is(false));
        assertThat(cell.transition(5).isLive(), is(false));
        assertThat(cell.transition(6).isLive(), is(false));
        assertThat(cell.transition(7).isLive(), is(false));
        assertThat(cell.transition(8).isLive(), is(false));
    }
}
