package view;

import presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void addToy();
    void getToyList();
    void saveChanges();
    void finish();
}
