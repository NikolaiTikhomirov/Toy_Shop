package model;

import java.io.Serializable;

public class Toy implements Serializable, ToyListInterface{

    private String name;
    private Integer frequency;
    private Integer quantity;

    public Toy(String name, Integer frequency, Integer quantity){
        this.name = name;
        this.frequency = frequency;
        this.quantity = quantity;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Integer getFrequency(){
        return frequency;
    }

    @Override
    public Integer getQuantity(){
        return quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public String toString() {
        String n = "";
        String f = "";
        String q = "";
        if (name != null) n = this.getName();
        if (frequency != null) f = String.valueOf(this.getFrequency());
        if (quantity != null) q = String.valueOf(this.getQuantity());
        return "Имя: " + n + " Вес: " + f + " количество: " + q;
    }

}
