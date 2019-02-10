package common.entities;

import org.springframework.data.annotation.Id;

public class Doctor {
    @Id
    private String id;
    private String firstName;
    private String lastName;

    public Doctor() {}

    public Doctor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
