package kagamihoge.lifegameonjavafx.ui.eventhandler;

import kagamihoge.lifegamewithoopexercise.ui.model.LifeGameModel;

public class StopButtonOnClickHandler implements ControllButtonOnClickHandler {
    private LifeGameModel model;
    
    public StopButtonOnClickHandler(LifeGameModel model) {
        this.model = model;
    }

    @Override
    public void handle() {
        model.stop();
    }

    @Override
    public ControllButtonOnClickHandler nextHandler() {
        return new StartButtonOnClickHander(model);
    }

    @Override
    public String getText() {
        return "停止";
    }

}
