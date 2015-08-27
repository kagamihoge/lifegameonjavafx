package kagamihoge.lifegamewithoopexercise.ui.model;

import static kagamihoge.lifegamewithoopexercise.ui.Cell.SIZE;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import kagamihoge.lifegamewithoopexercise.core.LifeGame;

public class LifeGameTimer extends AnimationTimer {
    private static long oneSecond = 1000_000_000;
    
    private long previousHandledTime = System.currentTimeMillis();
    
    private LifeGame lifeGame;

    private Integer width;
    
    private Integer height;
    
    private GraphicsContext graphicsContext2D;
    
    private DoubleProperty speedProperty;
    
    public LifeGameTimer(LifeGame lifeGame, GraphicsContext graphicsContext2D, Integer width, Integer height, DoubleProperty speedProperty) {
        this.lifeGame = lifeGame;
        this.width = width;
        this.height = height;
        this.graphicsContext2D = graphicsContext2D;
        this.speedProperty = speedProperty;
    }
    
    @Override
    public void handle(long now) {
        if (previousHandledTime + (oneSecond / speedProperty.intValue()) > now)
            return;
        previousHandledTime = now;
        graphicsContext2D.clearRect(0, 0, width * SIZE, height * SIZE);
        lifeGame.tick();
    }

}
