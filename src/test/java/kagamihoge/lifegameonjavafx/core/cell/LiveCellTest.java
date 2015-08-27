package kagamihoge.lifegameonjavafx.core.cell;

import static kagamihoge.lifegameonjavafx.core.cell.CellFactoryForTest.cellFactory;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import kagamihoge.lifegamewithoopexercise.core.cell.impl.LiveCell;

public class LiveCellTest {

    @Test
    public void testIsLive() {
        assertThat(new LiveCell(cellFactory).isLive(), is(true));
    }
    
    @Test
    public void testCellTransitionEventHandler() {
        LiveCell cell = new LiveCell(cellFactory);
        cell.setEventListner((x, y, c) -> {
            assertThat(x, is(0));
            assertThat(y, is(10));
            assertThat(c.isLive(), is(true));
        });
        cell.afterTransition(0, 10);
    }

    @Test
    public void testFlip() {
        assertThat(new LiveCell(cellFactory).flip().isLive(), is(false));
    }
    
    @Test
    public void testTransition() {
        LiveCell cell = new LiveCell(cellFactory);
        
        assertThat(cell.transition(0).isLive(), is(false));
        assertThat(cell.transition(1).isLive(), is(false));
        assertThat(cell.transition(2).isLive(), is(true));
        assertThat(cell.transition(3).isLive(), is(true));
        assertThat(cell.transition(4).isLive(), is(false));
        assertThat(cell.transition(5).isLive(), is(false));
        assertThat(cell.transition(6).isLive(), is(false));
        assertThat(cell.transition(7).isLive(), is(false));
        assertThat(cell.transition(8).isLive(), is(false));
    }
}
