package hw16_serialization;

import com.google.gson.Gson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;


public class MyGsonDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {

        int value1 = 42;
        float value2 = 3.14f;
        String value3 = "value3";
        int[] valueArray = {9, 14, 19};
        ArrayList<Double> valueArrList = new ArrayList<>(List.of(3.14, 2.71, 1.41));
        Set<String> valueSet = new HashSet<>();
        Map<String, Double> valueMap = new HashMap<>();

        valueSet.add("valueSet1");
        valueSet.add("valueSet2");
        valueMap.put("valueMap1", 1.1);
        valueMap.put("valueMap2", 2.2);
        valueMap.put("valueMap3", 3.3);

        AniObject anyObject =  new AniObject(value1, value2, true, value3,
        valueArray, valueArrList, valueSet, valueMap);

        System.out.println(anyObject);
        MyGson myGson = new MyGson();
        String serAniObject = myGson.toJson(anyObject);
        System.out.println("\nmyGsoned AniObject:\n" + serAniObject +"\n");

//       System.out.println("\nmyMyGsoned AniObject:\n" + myGson.toMyJson(anyObject) +"\n");

        Gson gson = new Gson();
        System.out.println("gSoned AniObject:\n" + gson.toJson(anyObject) +"\n");

        AniObject reAniObject = gson.fromJson(serAniObject, AniObject.class);
        reAniObject.setDate();
        System.out.println("reGsoned MyGsoned AniObject:\n" + reAniObject + "\n");

        System.out.println("equals? "+ anyObject.equals(reAniObject)+ "\n");

        System.out.println("reGsoned MyGsoned null: " + gson.fromJson(new MyGson().toJson(null),AniObject.class));
        System.out.println("MyGsoned null: " + new MyGson().toJson(null));


        Class clazz = Animal.class;
        List <Field> fields = Arrays.asList(clazz.getDeclaredFields());
        List <String> fieldNames = fields.stream().map(f -> f.getName()).collect(Collectors.toList());
        int numberOfFields = fields.size();
        Class <?> [] fieldTypes = fields.stream().map(field -> field.getType()).
                toArray(Class<?>[]::new);
        Constructor[] constructors = clazz.getConstructors();

        System.out.println("fields:  " + numberOfFields + "pars: " + constructors[0].getParameters().length);

         Constructor[] filteredConstructors = Arrays.stream(constructors).
                filter(cons->Arrays.equals(cons.getParameterTypes(), fieldTypes)).toArray(Constructor[]::new);
        Constructor constructor = filteredConstructors[0];

        System.out.println(fieldNames);



    }
}
