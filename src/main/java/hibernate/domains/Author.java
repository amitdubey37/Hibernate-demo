package hibernate.domains;


import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id @GeneratedValue(strategy =GenerationType.SEQUENCE )
    Integer id;

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name="author")
            ,inverseJoinColumns = @JoinColumn(name = "book_id"))
    Collection<Book> books= new HashSet<Book>();

    public void setSubjects(Collection<String> subjects) {
        this.subjects = subjects;
    }

    @GenericGenerator(name = "sequence-gen",strategy = "sequence")
    @CollectionId(columns = {@Column(name = "subject_id")},
            generator = "sequence-gen",type = @Type(type = "long"))
    @JoinTable(name = "author_subjects",
            joinColumns = @JoinColumn(name = "author_id"))
    @ElementCollection(fetch = FetchType.EAGER)
    Collection<String> subjects  = new HashSet<String>();
    @Column( name = "NAME")
    String firstName;


    public void setSubjects(Set<String> subjects) {
        this.subjects = subjects;
    }

    @Temporal(TemporalType.DATE)
    Date dob;

    public Collection<String> getSubjects() {
        return subjects;
    }

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
