package models;

public class Goods {
    private String name;
    private double weight; //in grams

    public Goods(String name) {
        this.name = name;
    }

    public Goods() {}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void print() {
        System.out.println(name + " " + weight);
    }

    public void print(int number) {
        for(int i = 0; i < number; i++){
            System.out.println(name + " " + weight);
        }
    }
}

