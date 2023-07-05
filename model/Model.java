package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
        if (toyList.size() < 1) System.out.println("Призы закончились");
        else{
            Integer bothFrequency = 0;
            Integer count = 0;
            HashMap<Integer, Integer> frequencyList = new HashMap<>();
            HashMap<Integer, String> countList = new HashMap<>();
            Integer res = 0;
            for (Toy toy : toyList.getValues()){
                bothFrequency += toy.getFrequency();
                frequencyList.put(count, bothFrequency);
                countList.put(count, toy.getName());
                count++;
            }
            Random random = new Random();
            Integer x = random.nextInt(bothFrequency) + 1;
            for (int i = 0; i < frequencyList.size(); i++){
                if (x < frequencyList.get(i)){
                    res = i;
                }
            }
            Toy toy = toyList.getToy(countList.get(res));
            toy.setQuantity(toy.getQuantity() - 1);
            prizeList.addToy(toy);
            if (toy.getQuantity() == 0) toyList.removeToy(toy.getName());
        }
    }

    public String getPrizeList(){
        return prizeList.getInfo();
    }
}
