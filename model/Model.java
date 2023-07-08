package model;

import java.util.HashMap;
import java.util.Random;
import model.fileHandler.Writable;

public class Model {
    private ToyList<String, Toy> toyList;
    private PrizeList<Toy> prizeList;
    private String awardedList;
    private String toyListPath;
    private String prizeListPath;
    private String awardedListPath;
    private Integer countAwarded;
    private Writable writable;

    public Model(Writable writable) {
        toyListPath = "model/toyList.txt";
        prizeListPath = "model/prizeList.txt";
        awardedListPath = "model/awardedList.txt";
        this.writable = writable;
        toyList = (ToyList<String, Toy>) writable.read(toyListPath);
        prizeList = (PrizeList<Toy>) writable.read(prizeListPath);
        awardedList = (String) writable.read(awardedListPath);
        countAwarded = 1;
        for (char c : awardedList.toCharArray()) {
            if (c == '|') {
                countAwarded++;
            }
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
        writable.save(toyList, toyListPath);
        writable.save(prizeList, prizeListPath);
        writable.save(awardedList, awardedListPath);
    }

    public void prizeAward(){
        awardedList += countAwarded + ". ";
        awardedList += prizeList.prizeAward().getName();
        awardedList += "|\n";
        countAwarded ++;
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
                    break;
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

    public void getAwardedList(){
        System.out.println(awardedList);;
    }
}
