package model;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;

import model.PrizeList;

public class PrizeList<T extends ToyListInterface> implements Serializable, Iterable<T>{
    private ArrayDeque<T> prizeList;

    public PrizeList(){
        prizeList = new ArrayDeque<>();
    }

    public void addToy(T toy){
        prizeList.addLast(toy);
    }

    public T getToyByName(String name){
        for (T toy: prizeList){
            if (toy.getName().equals(name)){
                return toy;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        Integer count = 1;
        for (T toy : prizeList) {
            stringBuilder.append(count + ". ");
            stringBuilder.append(toy.getName());
            stringBuilder.append("\n");
            count++;
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return prizeList.iterator();
    }

    public T prizeAward(){
        return prizeList.pollFirst();
    }

    public void prizeDraw(){

    }

    public void getPrizeList(){

    }
}
