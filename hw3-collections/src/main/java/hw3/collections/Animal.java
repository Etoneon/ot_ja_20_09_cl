package hw3.collections;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    String getName(){return name;}

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}