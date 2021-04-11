
package hw16_serialization;

import java.time.LocalDate;
import java.util.*;


public class Animal {

    String name;
    int age;
    ArrayList<String> properties;
    Map<String, Integer> parts;
//    double weight = 3.55;
    boolean isMale;

//    Set<String> meals = new HashSet<>();
//    Map<String, Double> feedingPortions = new HashMap<>();
//    int[] feedingTime = {9, 14, 19};
    Master master;


//    transient LocalDate dateToDate;

    public Animal(String name, int age, ArrayList<String> properties,
                  Map<String, Integer> parts, boolean isMale, Master master) {
        this.name = name;
        this.age = age;
        this.properties = properties;
        this.parts = parts;
        this.isMale = isMale;
        this.master = master;
/*        feedingPortions.put("breakfast",25.0);
        feedingPortions.put("dinner",30.0);
        feedingPortions.put("supper",20.0);
        meals.add("meat");
        meals.add("serial");
        dateToDate = LocalDate.now();
*/
            }




    @Override
    public String toString() {
        return "Animal [name = " + name + ", properties = " + properties + ", age = " + age
 //               + ", weight = " + weight
                + ", isMale = " + isMale + ", parts = " + parts
//                + ", meals = " + meals + ", feedingPortions: " + feedingPortions
 //               + ", feedingTime =" + Arrays.toString(feedingTime) + ", master = " + master.getName()
 //               + ", date = " + dateToDate + "]"
                ;

    }

/*    public void setDate() {
        dateToDate = LocalDate.now();
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal that = (Animal) o;
        return (Objects.equals(name, that.name)) &&
                Objects.equals(properties, that.properties)&&
                age == that.age &&
 //               weight == that.weight &&
                isMale == that.isMale &&
  //              weight == that.weight &&
                Objects.equals(parts, that.parts) &&
 //               Objects.equals(meals, that.meals) &&
  //              Objects.equals(feedingPortions, that.feedingPortions) &&
  //              Arrays.equals(feedingTime, that.feedingTime) &&
                Objects.equals(master, that.master);
    }

    public String equalString (Object o) {
        Animal that = (Animal) o;
        String str = "";
        return  str +  (Objects.equals(name, that.name))
                + (Objects.equals(properties, that.properties))
                + (age == that.age)
  //              + (weight == that.weight)
                + (isMale == that.isMale)
 //               + (weight == that.weight)
                + (Objects.equals(parts, that.parts))
  //              + (Objects.equals(meals, that.meals))
  //              + (Objects.equals(feedingPortions, that.feedingPortions) )
  //              + (Arrays.equals(feedingTime, that.feedingTime) )
                + (Objects.equals(master, that.master));
    }


}
