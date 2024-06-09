/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Zamalek;

import bankingsystem.BankClient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ZamalekRemoteClass extends UnicastRemoteObject implements ZamalekInterface{
    ArrayList<BankClient> zamalekClients = new ArrayList<>();

    public ZamalekRemoteClass() throws RemoteException {

    }

    @Override
    public String checkBalance(BankClient bc) throws RemoteException {
        for (BankClient i : zamalekClients) {
            if (i.getId() == bc.getId()) {
                return "" + i.getBalance();
            }
        }
        return "not found";
    }

    @Override
    public BankClient withdraw(BankClient bc, double amount) throws RemoteException {
        try {
            for (BankClient i : zamalekClients) {
                if (i.getId() == bc.getId()) {
                    i.setBalance(i.getBalance() - amount);
                    bc = i.clone();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in withdraw function in Zamalek Remote Class");
        }
        // bc.setBalance(bc.getBalance() - amount);
        return bc;
    }

    @Override
    public BankClient deposit(BankClient bc, double amount) throws RemoteException {
        try {
            for (BankClient i : zamalekClients) {
                if (i.getId() == bc.getId()) {
                    i.setBalance(i.getBalance() + amount);
                    bc = i.clone();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in deposit function in Zamalek Remote Class");
        }
        //bc.setBalance(bc.getBalance() + amount);
        return bc;
    }

    @Override
    public void signInZamalek(BankClient bc) throws RemoteException {
        zamalekClients.add(bc);
    }

}
