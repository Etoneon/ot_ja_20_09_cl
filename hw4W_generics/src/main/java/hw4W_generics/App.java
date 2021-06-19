package hw4W_generics;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        //given
        final long customerId = 1L;
        Customer customer = new Customer(customerId, "Ivan", 233);
        Map<Customer, String> map = new HashMap<>();

        System.out.println(customer + "hash = " + customer.hashCode());

        String expectedData = "data";
        map.put(customer, expectedData);

        //when
        long newScore = customer.getScores() + 10;
        System.out.println("newScore = " + newScore);

        Customer customer11 = new Customer(customerId, "IvanChangedName", newScore);
        System.out.println(customer11 + "hash = " + customer11.hashCode());

        String factData = map.get(new Customer(customerId, "IvanChangedName", newScore));

        System.out.println("data =" + expectedData + "\n" + "factData = " + factData + "\n");
        //then
        //      assertThat(factData).isEqualTo(expectedData);
        //when
        long newScoreSecond = customer.getScores() + 20;
        customer.setScores(newScoreSecond);
        String factDataSecond = map.get(customer);
        //then
        //      assertThat(factDataSecond).isEqualTo(expectedData);


/* //     @DisplayName("Сортировка по полю score, итерация по возрастанию")
 //       void scoreSortingTest() {
            //given
            Customer customer1 = new Customer(1, "Ivan", 233);
            Customer customer2 = new Customer(2, "Petr", 11);
            Customer customer3 = new Customer(3, "Pavel", 888);

            CustomerService customerService = new CustomerService();
            customerService.add(customer1, "Data1");
            customerService.add(customer2, "Data2");
            customerService.add(customer3, "Data3");

            //when
            Map.Entry<Customer, String> smallestScore = customerService.getSmallest();
            //then
            assertThat(smallestScore.getKey()).isEqualTo(customer2);

            //when
            // подсказка:
            // a key-value mapping associated with the least key strictly greater than the given key, or null if there is no such key.
            Map.Entry<Customer, String> middleScore = customerService.getNext(new Customer(10, "Key", 20));
            //then
            assertThat(middleScore.getKey()).isEqualTo(customer1);
            middleScore.getKey().setScores(10000);
            middleScore.getKey().setName("Vasy");

            //when
            Map.Entry<Customer, String> biggestScore = customerService.getNext(customer1);
            //then
            assertThat(biggestScore.getKey()).isEqualTo(customer3);

            //when
            Map.Entry<Customer, String> notExists = customerService.getNext(new Customer(100, "Not exists", 20000));
            //then
            assertThat(notExists).isNull();
            */


 //       @DisplayName("Модификация коллекции")
                   //given
            Customer customer1 = new Customer(1, "Ivan", 233);
            Customer customer2 = new Customer(2, "Petr", 11);
            Customer customer3 = new Customer(3, "Pavel", 888);

            CustomerService customerService = new CustomerService();
            customerService.add(customer1, "Data1");
            customerService.add(new Customer(customer2.getId(), customer2.getName(), customer2.getScores()), "Data2");
            customerService.add(customer3, "Data3");

            //when
            Map.Entry<Customer, String> smallestScore = customerService.getSmallest();
            System.out.println("smallest key = " + smallestScore.getKey() + "data = " + smallestScore.getValue() + "\n");


            smallestScore.getKey().setName("Vasyl");

            System.out.println("smallest key changed= " + smallestScore.getKey() + "data = " + smallestScore.getValue() + "\n");

        System.out.println("smallest key changed ?= " + customerService.getSmallest().getKey() + "data = " + customerService.getSmallest().getValue() + "\n");


        //then
         //   assertThat(customerService.getSmallest().getKey().getName()).isEqualTo(customer2.getName());



        }



}
