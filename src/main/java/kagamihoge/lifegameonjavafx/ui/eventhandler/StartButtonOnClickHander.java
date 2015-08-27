package kagamihoge.lifegameonjavafx.ui.eventhandler;

import kagamihoge.lifegamewithoopexercise.ui.model.LifeGameModel;

public class StartButtonOnClickHander implements ControllButtonOnClickHandler {

    private LifeGameModel model;
    
    public StartButtonOnClickHander(LifeGameModel model) {
        this.model = model;
    }
    
    @Override
    public void handle() {
        model.start();
    }

    @Override
    public ControllButtonOnClickHandler nextHandler() {
        return new StopButtonOnClickHandler(model);
    }

    @Override
    public String getText() {
        return "開始";
    }

}
