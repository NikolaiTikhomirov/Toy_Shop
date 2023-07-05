package model;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

import model.PrizeList;

public class PrizeList<T extends ToyListInterface> implements Serializable, Iterable<T>{
    private Queue<T> prizeList;

    public PrizeList(){
        prizeList = new ArrayDeque<>();
    }

    public void addToy(T toy){
        prizeList.add(toy);
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
        for (T toy : prizeList) {
            stringBuilder.append(toy.getName());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return prizeList.iterator();
    }

    public void prizeAward(){

    }

    public void prizeDraw(){

    }

    public void getPrizeList(){

    }
}
