package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import model.ToyList;

public class ToyList<String, T extends ToyListInterface> implements Serializable, Iterable<T>{
    private HashMap<String, Toy> toyList;

    public ToyList(){
        toyList = new HashMap<String, Toy>();
    }

    public void addToy(Toy toy){
        if (toyList.containsKey(toy.getName())){
            toy.setQuantity(toy.getQuantity() + toyList.get(toy.getName()).getQuantity());
            toyList.put((String) toy.getName(), toy);
        }
        else{
            toyList.put((String) toy.getName(), toy);
        }
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (var pair: toyList.entrySet()) {
            stringBuilder.append(pair.getValue());
            stringBuilder.append("\n");
        }
        return (String) stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return ((Iterable<T>) toyList).iterator();
    }

    public Toy getToy(String name){
        return toyList.get(name);
    }

    public Collection<Toy> getValues(){
        return toyList.values();
    }

    public void removeToy(String name){
        toyList.remove(name);
    }

    public Integer size(){
        return toyList.size();
    }
}
