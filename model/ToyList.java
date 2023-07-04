package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.ToyList;

public class ToyList<T extends ToyListInterface> implements Serializable, Iterable<T>{
    private List<T> toyList;

    public ToyList(){
        toyList = new ArrayList<>();
    }

    public void addToy(T toy){
        toyList.add(toy);
    }

    public T getToyByName(String name){
        for (T toy: toyList){
            if (toy.getName().equals(name)){
                return toy;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (T toy : toyList) {
            stringBuilder.append(toy);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return toyList.iterator();
    }

    public void prizeAward(){

    }

    public void prizeDraw(){

    }

    public void getPrizeList(){

    }
}
