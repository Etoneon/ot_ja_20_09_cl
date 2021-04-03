package L20_JPQL.hibernate.model;


import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sergey
 * created on 08.10.18.
 */

@NamedQuery(
        name = "get_person_by_id",
        query = "select p from Person p where id = :id"
)
@Entity
@Table(name = "tPerson")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    private String name;

    private int age;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY
            , orphanRemoval = true
    )
    @JoinColumn(name = "address_id")
         private AddressDataSet address;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER
            , orphanRemoval = true) //вариат 1 создания схемы
    //@OneToMany(cascade = CascadeType.ALL) // вариант 2 создания схемы
    private List<Phone> phones = new ArrayList<>();

    public Person () {}

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressDataSet getAddress() {
        return address;
    }

    public void setAddress(AddressDataSet address) {
        this.address = address;
    }

/*    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
*/

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
//                ", createdOn=" + createdOn +
                ", phones=" + phones +
                '}';
    }
}
