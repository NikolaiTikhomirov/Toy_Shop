package model;

import model.fileHandler.Writable;

public class Model {
    private ToyList<String, Toy> toyList;
    private PrizeList<Toy> prizeList;
    private String toyListPath;
    private String prizeListPath;
    private Writable writable;

    public Model(Writable writable) {
        toyListPath = "model/toyList.txt";
        prizeListPath = "model/prizeList.txt";
        this.writable = writable;
        // try {
            toyList = (ToyList<String, Toy>) writable.read(toyListPath);
        // } catch (Exception e) {
        //     toyList = new ToyList<>();
        //     writable.save(toyList, toyListPath);
        // }
        // try {
            prizeList = (PrizeList<Toy>) writable.read(prizeListPath);
        // } catch (Exception e) {
        //     prizeList = new PrizeList<>();
        //     writable.save(prizeList, prizeListPath);
        // }
    }

    public void addToy(String name, Integer frequency, Integer quantity) {
        Toy toy = new Toy(name, frequency, quantity);
        toyList.addToy(toy);
    }

    public String getToyList() {
        return toyList.getInfo();
    }

    public void saveChanges() {
        writable.save(toyList, toyListPath);
        writable.save(prizeList, prizeListPath);
    }

    public void prizeAward(){
        toyList.prizeAward();
    }

    public void prizeDraw(){
        toyList.prizeDraw();
    }

    public String getPrizeList(){
        return prizeList.getInfo();
    }
}
