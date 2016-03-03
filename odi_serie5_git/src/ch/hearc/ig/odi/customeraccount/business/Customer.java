package ch.hearc.ig.odi.customeraccount.business;

import java.util.*;

public class Customer {

	private Map<String, Account> accounts;  //--converti en Map, VP=> Collection<Account> accounts;
	private int number;
	private String firstName;
	private String lastName;

	/**
	 * 
	 * @param number
	 * @param firstName
	 * @param lastName
	 */
	public Customer(Integer number, String firstName, String lastName) {
            this.number = number;
            this.firstName = firstName;
            this.lastName = lastName;
            this.accounts = new HashMap();
	}

	/**
	 * 
	 * @param number
	 */
	public Account getAccountByNumber(String number) {
            return this.accounts.get(number);
		
	}

	/**
	 * 
	 * @param number
	 * @param name
	 * @param rate
	 */
	public void addAccount(String number, String name, double rate) {
	    Account account = new Account(number, name, rate,this);
            accounts.put(number, account);
            
	}

}