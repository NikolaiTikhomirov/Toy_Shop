package model;

public class Toy implements ToyListInterface{

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


}
