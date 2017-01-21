package hibernate.domains;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Author {
    @Id
    Integer id;

    @Column( name = "NAME")
    String firstName;
    @Temporal(TemporalType.DATE)
    Date dob;

    public Date getDob() {
        return dob;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }
    @Embedded
    Address currentAddress;
    @AttributeOverrides({
            @AttributeOverride(name = "location", column = @Column(name = "Base_Location")),
            @AttributeOverride(name = "streetNumber", column = @Column(name = "Street")),
            @AttributeOverride(name = "state", column = @Column(name = "stat"))
    })
    @Embedded
    Address permanentAddress;

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    String lastName;
    Integer age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
