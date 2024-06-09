/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sherouk;

import bankingsystem.BankClient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class SheroukRemoteClass extends UnicastRemoteObject implements SheroukInterface {

    ArrayList<BankClient> sheroukClients = new ArrayList<>();

    public SheroukRemoteClass() throws RemoteException {

    }

    @Override
    public String checkBalance(BankClient bc) throws RemoteException {
        for (BankClient i : sheroukClients) {
            if (i.getId() == bc.getId()) {
                return "" + i.getBalance();
            }
        }
        return "not found";
    }

    @Override
    public BankClient withdraw(BankClient bc, double amount) throws RemoteException {
        try {
            for (BankClient i : sheroukClients) {
                if (i.getId() == bc.getId()) {
                    i.setBalance(i.getBalance() - amount);
                    bc = i.clone();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in withdraw function in Sherouk Remote Class");
        }
        // bc.setBalance(bc.getBalance() - amount);
        return bc;
    }

    @Override
    public BankClient deposit(BankClient bc, double amount) throws RemoteException {
        try {
            for (BankClient i : sheroukClients) {
                if (i.getId() == bc.getId()) {
                    i.setBalance(i.getBalance() + amount);
                    bc = i.clone();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in deposit function in Sherouk Remote Class");
        }
        //bc.setBalance(bc.getBalance() + amount);
        return bc;
    }

    @Override
    public void signInSherouk(BankClient bc) throws RemoteException {
        sheroukClients.add(bc);
    }

}
