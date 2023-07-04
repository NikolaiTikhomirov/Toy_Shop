package presenter;

import model.Model;
import view.View;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model){
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public void addToy(String name, Integer frequency, Integer quantity){
        model.addToy(name, frequency, quantity);
    }

    public void getToyList(){
        view.print(model.getToyList());
    }

    public void saveChanges() {
        model.saveChanges();
    }

    public void prizeAward(){
        model.prizeAward();
    }

    public void prizeDraw(){
        model.prizeDraw();
    }

    public void getPrizeList(){
        view.print(model.getPrizeList());
    }
}
