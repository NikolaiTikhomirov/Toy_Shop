package view.commands;

import view.View;

public class GetAwardedList implements Command {
    private View view;

    public GetAwardedList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть список выданных призов";
    }

    @Override
    public void execute() {
        view.getAwardedList();
    }
}
