package hibernate.domains;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
public class Address {
    Integer streetNumber;
    String location;
    String state;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }
}
