
package hw16_serialization;

public class Owner {
    String name;
    int age;
    String[] friends={"Eduard","Stepan"};
    public Owner(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    
}
