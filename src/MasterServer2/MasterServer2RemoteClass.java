/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MasterServer2;

import MasterServer2.MasterServer2GUI;
import MasterServer2.MasterServer2Interface;
import NasrCity.NasrCityInterface;
import Dokki.DokkiInterface;
import Zamalek.ZamalekInterface;
import bankingsystem.BankClient;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MasterServer2RemoteClass extends UnicastRemoteObject implements MasterServer2Interface {

    static MasterServer2GUI M2GUI = new MasterServer2GUI();
    private static ArrayList<BankClient> clients = new ArrayList<BankClient>();
    private static ArrayList<BankClient> master1Clients = new ArrayList<BankClient>();

    public static ArrayList<BankClient> getClients() {
        return clients;
    }

    public static ArrayList<BankClient> getMaster1Clients() {
        return master1Clients;
    }

    public MasterServer2RemoteClass() throws RemoteException {

    }

    @Override
    public void signIn(BankClient bc, String area) throws RemoteException {
        clients.add(bc);
        updateMaster2GUI(clients.toString());
        try {
            if (area.equals("Dokki")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 2233);
                DokkiInterface obj = (DokkiInterface) reg.lookup("DOKKI");
                obj.signInDokki(bc);

            } else if (area.equals("Nasr City")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 2244);
                NasrCityInterface obj = (NasrCityInterface) reg.lookup("NASRCITY");
                obj.signInNasrCity(bc);
            } else {
                Registry reg = LocateRegistry.getRegistry("localhost", 2255);
                ZamalekInterface obj = (ZamalekInterface) reg.lookup("ZAMALEK");
                obj.signInZamalek(bc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMaster2GUI(String txt) {
        M2GUI.updateMaster2Screen(txt);
    }

    @Override
    public void callWithdraw(BankClient bc, double amount, String area) throws RemoteException {
        BankClient b = new BankClient();
        try {
            if (area.equals("Dokki")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 2233);
                DokkiInterface obj = (DokkiInterface) reg.lookup("DOKKI");
                b = obj.withdraw(bc, amount).clone();

            } else if (area.equals("Nasr City")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 2244);
                NasrCityInterface obj = (NasrCityInterface) reg.lookup("NASRCITY");
                b = obj.withdraw(bc, amount).clone();
            } else {
                Registry reg = LocateRegistry.getRegistry("localhost", 2255);
                ZamalekInterface obj = (ZamalekInterface) reg.lookup("ZAMALEK");
                b = obj.withdraw(bc, amount).clone();
            }

            for (BankClient bkc : clients) {
                if (b.getId() == bkc.getId()) {
                    bkc.setBalance(b.getBalance());
                }

            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void callDeposit(BankClient bc, double amount, String area) throws RemoteException {
        BankClient b = new BankClient();
        try {
            if (area.equals("Dokki")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 2233);
                DokkiInterface obj = (DokkiInterface) reg.lookup("DOKKI");
                b = obj.deposit(bc, amount).clone();

            } else if (area.equals("Nasr City")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 2244);
                NasrCityInterface obj = (NasrCityInterface) reg.lookup("NASRCITY");
                b = obj.deposit(bc, amount).clone();
            } else {
                Registry reg = LocateRegistry.getRegistry("localhost", 2255);
                ZamalekInterface obj = (ZamalekInterface) reg.lookup("ZAMALEK");
                b = obj.deposit(bc, amount).clone();
            }

            for (BankClient bkc : clients) {
                if (b.getId() == bkc.getId()) {
                    bkc.setBalance(b.getBalance());
                }
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public String callCheckBalance(BankClient bc, String area) throws RemoteException {
        String balanceStatus = "";
        try {
            if (area.equals("Dokki")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 2233);
                DokkiInterface obj = (DokkiInterface) reg.lookup("DOKKI");
                balanceStatus = obj.checkBalance(bc);

            } else if (area.equals("Nasr City")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 2244);
                NasrCityInterface obj = (NasrCityInterface) reg.lookup("NASRCITY");
                balanceStatus = obj.checkBalance(bc);
            } else {
                Registry reg = LocateRegistry.getRegistry("localhost", 2255);
                ZamalekInterface obj = (ZamalekInterface) reg.lookup("ZAMALEK");
                balanceStatus = obj.checkBalance(bc);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        return balanceStatus;
    }

    @Override
    public String backup1in2(ArrayList<BankClient> a) throws RemoteException {
        master1Clients = (ArrayList<BankClient>) a.clone();
        //return "Back Up Complete on " + master1Clients.size() +" records";
        return "Back Up Complete on " + master1Clients.size() + " records\n" + master1Clients.toString();

    }

}
