package com.email.service.datamodel;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @NotBlank
    @Column(unique = true)
    private String username;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    private LocalDate dob;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    //@ManyToOne()
    @JoinColumn(name="name")
    // @NotBlank
    private ERole role;
    @OneToOne
    @JoinColumn(name="id")
    private Address address;

    public User(int id, String firstname, String lastname, LocalDate dob, String email, String username, String password, ERole role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        // this.address = new Address();
    }

    public User(String firstname, String lastname, LocalDate dob, String email, String username, String password, ERole role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getUsername() {
        return username;
    }

    public String getLastname() {
        return lastname;
    }

    public ERole getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}


