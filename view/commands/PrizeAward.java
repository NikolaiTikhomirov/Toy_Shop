package view.commands;

import view.View;

public class PrizeAward implements Command {
    private View view;

    public PrizeAward(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Вручить игрушку";
    }

    @Override
    public void execute() {
        view.prizeAward();
    }
}
