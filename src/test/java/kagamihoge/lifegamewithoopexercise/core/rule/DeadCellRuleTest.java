package kagamihoge.lifegamewithoopexercise.core.rule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DeadCellRuleTest {

    @Test
    public void testIsNewLife() {
        DeadCellRule rule = new DeadCellRule();
        
        assertThat(rule.isNewLife(0), is(false));
        assertThat(rule.isNewLife(1), is(false));
        assertThat(rule.isNewLife(2), is(false));
        assertThat(rule.isNewLife(3), is(true));
        assertThat(rule.isNewLife(4), is(false));
        assertThat(rule.isNewLife(5), is(false));
        assertThat(rule.isNewLife(6), is(false));
        assertThat(rule.isNewLife(7), is(false));
        assertThat(rule.isNewLife(8), is(false));
    }
}
