package view.commands;

import view.View;

public class PrizeDraw implements Command {
    private View view;

    public PrizeDraw(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Разыграть приз";
    }

    @Override
    public void execute() {
        view.prizeDraw();
    }
    
}
