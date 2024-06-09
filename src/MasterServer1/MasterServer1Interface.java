/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MasterServer1;

import bankingsystem.BankClient;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MasterServer1Interface extends Remote {

    public void signIn(BankClient bc, String area) throws RemoteException;

    public void updateMaster1GUI(String txt) throws RemoteException;

    public void callWithdraw(BankClient bc, double amount, String area) throws RemoteException;

    public void callDeposit(BankClient bc, double amount, String area) throws RemoteException;
    
    public String callCheckBalance(BankClient bc, String area) throws RemoteException;
    
    public String backup2in1(ArrayList<BankClient> a) throws RemoteException;
}
