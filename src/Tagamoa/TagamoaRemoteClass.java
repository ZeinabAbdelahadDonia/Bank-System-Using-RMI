/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tagamoa;

import bankingsystem.BankClient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class TagamoaRemoteClass extends UnicastRemoteObject implements TagamoaInterface{
    ArrayList<BankClient> tagamoaClients = new ArrayList<>();

    public TagamoaRemoteClass() throws RemoteException {

    }

    @Override
    public String checkBalance(BankClient bc) throws RemoteException {
        for (BankClient i : tagamoaClients) {
            if (i.getId() == bc.getId()) {
                return "" + i.getBalance();
            }
        }
        return "not found";
    }

    @Override
    public BankClient withdraw(BankClient bc, double amount) throws RemoteException {
        try {
            for (BankClient i : tagamoaClients) {
                if (i.getId() == bc.getId()) {
                    i.setBalance(i.getBalance() - amount);
                    bc = i.clone();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in withdraw function in Tagamoa Remote Class");
        }
        // bc.setBalance(bc.getBalance() - amount);
        return bc;
    }

    @Override
    public BankClient deposit(BankClient bc, double amount) throws RemoteException {
        try {
            for (BankClient i : tagamoaClients) {
                if (i.getId() == bc.getId()) {
                    i.setBalance(i.getBalance() + amount);
                    bc = i.clone();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in deposit function in Tagamoa Remote Class");
        }
        //bc.setBalance(bc.getBalance() + amount);
        return bc;
    }

    @Override
    public void signInTagamoa(BankClient bc) throws RemoteException {
        tagamoaClients.add(bc);
    }

    
}
