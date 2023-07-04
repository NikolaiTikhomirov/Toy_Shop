package view.commands;

import view.View;

public class GetPrizeList implements Command {
    private View view;

    public GetPrizeList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть очередь призов на выдачу";
    }

    @Override
    public void execute() {
        view.getPrizeList();
    }
}
