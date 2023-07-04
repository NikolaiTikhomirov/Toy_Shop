package view;

import presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void addToy();
    void getToyList();
    void prizeAward();
    void prizeDraw();
    void getPrizeList();
    void saveChanges();
    void finish();
}
