package kagamihoge.lifegameonjavafx;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import kagamihoge.lifegameonjavafx.core.cell.DeadCellTest;
import kagamihoge.lifegameonjavafx.core.cell.LiveCellTest;
import kagamihoge.lifegameonjavafx.core.cell.SeedCellTest;
import kagamihoge.lifegameonjavafx.core.grid.GridOfCellsTest;
import kagamihoge.lifegameonjavafx.core.grid.NeighboursTest;
import kagamihoge.lifegameonjavafx.core.rule.DeadCellRuleTest;
import kagamihoge.lifegameonjavafx.core.rule.LiveCellRuleTest;

@RunWith(Suite.class)
@SuiteClasses({
    DeadCellTest.class,
    LiveCellTest.class,
    SeedCellTest.class,
    GridOfCellsTest.class,
    NeighboursTest.class,
    DeadCellRuleTest.class,
    LiveCellRuleTest.class
})
public class AllTests {

}
