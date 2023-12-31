package view.commands;

import view.View;

public class GetToyList implements Command {
    private View view;

    public GetToyList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть список игрушек (призовой фонд)";
    }

    @Override
    public void execute() {
        view.getToyList();
    }
}
