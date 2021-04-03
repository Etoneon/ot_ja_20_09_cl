package L20_JPQL.hibernate.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tAddressDataSet")
public class AddressDataSet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;


    @Column(name = "address", nullable = false)
    private String street;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Person person;

    public AddressDataSet (){
    }

    public AddressDataSet (String street) {
        this.street = street;
//        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Person getPerson() { return person;}

//    public void setPerson(Person person) {this.person = person;}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
//                ", personId=" + person.getId() +
                ", street='" + street + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDataSet addressDataSet = (AddressDataSet) o;
        return Objects.equals(id, addressDataSet.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}



