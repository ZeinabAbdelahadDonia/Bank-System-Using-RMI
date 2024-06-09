/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

import java.io.Serializable;

public class BankClient implements Serializable, Cloneable {

    private String name;
    private double balance;
    private int id;

    public BankClient() {
        this.balance = 1000 + (int) (Math.random() * ((1000000 - 1000) + 1));
        this.id = 1 + (int) (Math.random() * ((20000 - 1) + 1));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID = " + id + " Client = " + name + " --> Balance = " + balance + "\n";
    }

    @Override
    public BankClient clone() throws CloneNotSupportedException {
        return (BankClient) super.clone(); // Call the clone method of Object class
    }

}
