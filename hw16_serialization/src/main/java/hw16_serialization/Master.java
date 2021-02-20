
package hw16_serialization;

public class Master {
    String name;
    int age;
    String[] functions ={"feeding","caressing","playing","cleaning"};
    public Master(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    
}
