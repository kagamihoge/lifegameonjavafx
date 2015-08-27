package kagamihoge.lifegameonjavafx.core.rule;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import kagamihoge.lifegameonjavafx.core.rule.LiveCellRule;

public class LiveCellRuleTest {

    @Test
    public void testIsUnderpopulation() {
        LiveCellRule rule = new LiveCellRule();
        
        assertThat(rule.isUnderpopulation(0), is(true));
        assertThat(rule.isUnderpopulation(1), is(true));
        assertThat(rule.isUnderpopulation(2), is(false));
        assertThat(rule.isUnderpopulation(3), is(false));
        assertThat(rule.isUnderpopulation(4), is(false));
        assertThat(rule.isUnderpopulation(5), is(false));
        assertThat(rule.isUnderpopulation(6), is(false));
        assertThat(rule.isUnderpopulation(7), is(false));
        assertThat(rule.isUnderpopulation(8), is(false));
    }

    @Test
    public void testIsOvercrowding() {
        LiveCellRule rule = new LiveCellRule();
        
        assertThat(rule.isOvercrowding(0), is(false));
        assertThat(rule.isOvercrowding(1), is(false));
        assertThat(rule.isOvercrowding(2), is(false));
        assertThat(rule.isOvercrowding(3), is(false));
        assertThat(rule.isOvercrowding(4), is(true));
        assertThat(rule.isOvercrowding(5), is(true));
        assertThat(rule.isOvercrowding(6), is(true));
        assertThat(rule.isOvercrowding(7), is(true));
        assertThat(rule.isOvercrowding(8), is(true));
    }

    @Test
    public void testIsUnchangedSurvive() {
        LiveCellRule rule = new LiveCellRule();
        
        assertThat(rule.isUnchangedSurvive(0), is(false));
        assertThat(rule.isUnchangedSurvive(1), is(false));
        assertThat(rule.isUnchangedSurvive(2), is(true));
        assertThat(rule.isUnchangedSurvive(3), is(true));
        assertThat(rule.isUnchangedSurvive(4), is(false));
        assertThat(rule.isUnchangedSurvive(5), is(false));
        assertThat(rule.isUnchangedSurvive(6), is(false));
        assertThat(rule.isUnchangedSurvive(7), is(false));
        assertThat(rule.isUnchangedSurvive(8), is(false));
    }
}
