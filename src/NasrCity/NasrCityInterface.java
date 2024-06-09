/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package NasrCity;

import bankingsystem.BankClient;
import java.rmi.RemoteException;
import java.rmi.Remote;
/**
 *
 * @author USER
 */
public interface NasrCityInterface extends Remote{
    public String checkBalance(BankClient bc) throws RemoteException;
    public BankClient withdraw(BankClient bc, double amount) throws RemoteException;
    public BankClient deposit(BankClient bc, double amount) throws RemoteException;
    public void signInNasrCity(BankClient bc) throws RemoteException;
}
