package model;

import model.fileHandler.Writable;

public class Model {
    private ToyList<Toy> toyList;
    private String filePath;
    private Writable writable;

    public Model(Writable writable) {
        filePath = "src/tree/toyFile.txt";
        this.writable = writable;
        try {
            toyList = (ToyList<Toy>) writable.read(filePath);
        } catch (Exception e) {
            toyList = new ToyList<>();
            writable.save(toyList, filePath);
        }
    }

    public void addToy(String name, Integer frequency, Integer quantity) {
        Toy toy = new Toy(name, frequency, quantity);
        toyList.addToy(toy);
    }

    public String getToyList() {
        return toyList.getInfo();
    }

    public void saveChanges() {
        writable.save(toyList, filePath);
    }
}
