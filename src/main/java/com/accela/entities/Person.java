package com.accela.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "First Name is mandatory")
    private String fname;
    
    @NotBlank(message = "Last Name is mandatory")
    private String lname;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "person")
    private List<Address> address = new ArrayList<>();
    
    public Person() {}

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
    public String toString() {
        return "Person{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + '}';
    }
}