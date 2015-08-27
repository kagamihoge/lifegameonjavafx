package kagamihoge.lifegamewithoopexercise.core.cell;

import kagamihoge.lifegamewithoopexercise.core.event.CellTransitionEventHandler;

public interface Cell {

	Cell transition(int liveCells);

	boolean isLive();
    
	Cell flip();
	
	void setEventListner(CellTransitionEventHandler handler);
	
	void afterTransition(int x ,int y);
}
