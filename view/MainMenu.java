package view;

import view.commands.AddToy;
import view.commands.Command;
import view.commands.Finish;
import view.commands.GetAwardedList;
import view.commands.GetPrizeList;
import view.commands.GetToyList;
import view.commands.PrizeAward;
import view.commands.PrizeDraw;
import view.commands.SaveChanges;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new AddToy(view));
        commandList.add(new GetToyList(view));
        commandList.add(new GetPrizeList(view));
        commandList.add(new GetAwardedList(view));
        commandList.add(new PrizeDraw(view));
        commandList.add(new PrizeAward(view));
        commandList.add(new SaveChanges(view));
        commandList.add(new Finish(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public void execute(int numCommand){
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }
}
