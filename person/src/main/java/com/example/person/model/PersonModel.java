package com.example.person.model;
import javax.persistence.*;

@Entity
@Table(name = "personModel")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "age")
    private String age;
    @Column(name = "job")
    private String job;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneno")
    private String phoneno;

    public PersonModel() {
    }

    public PersonModel(long id, String name, String address, String postcode, String age, String job, String email, String phoneno) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.age = age;
        this.job = job;
        this.email = email;
        this.phoneno = phoneno;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    @Override
    public String toString(){
        return "PersonModel [id=" + id + ", address=" + address + ", postcode=" + postcode + ", age=" + age + ", job=" + job + ", email=" + email + ", phoneno=" + phoneno + "]";
    }
}
