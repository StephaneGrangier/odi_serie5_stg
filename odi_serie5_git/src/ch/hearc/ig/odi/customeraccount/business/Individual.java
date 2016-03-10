/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.business;

import java.util.Date;

/**
 *
 * @author floriane.sapin
 */
public class Individual extends Customer{
    
    private Date birthDate;
    private String email;
    private String firstName;
    private String lastName;
    
    public Individual(Integer number, String firstname, String lastName, Date birthDate, String email){
        super(number);
        this.birthDate = birthDate;
        this.email = email; 
        this.firstName = firstname;
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
