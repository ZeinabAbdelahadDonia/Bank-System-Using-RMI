/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MasterServer1;

import Obour.ObourInterface;
import Sherouk.SheroukInterface;
import Tagamoa.TagamoaInterface;
import bankingsystem.BankClient;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.registry.Registry;

public class MasterServer1RemoteClass extends UnicastRemoteObject implements MasterServer1Interface {

    static MasterServer1GUI M1GUI = new MasterServer1GUI();
    private static ArrayList<BankClient> clients = new ArrayList<BankClient>();
    private static ArrayList<BankClient> master2Clients = new ArrayList<BankClient>();

    public static ArrayList<BankClient> getClients() {
        return clients;
    }

    public static ArrayList<BankClient> getMaster2Clients() {
        return master2Clients;
    }

    public MasterServer1RemoteClass() throws RemoteException {

    }

    @Override
    public void signIn(BankClient bc, String area) throws RemoteException {
        clients.add(bc);
        updateMaster1GUI(clients.toString());
        try {
            if (area.equals("Sherouk")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 1122);
                SheroukInterface obj = (SheroukInterface) reg.lookup("SHEROUK");
                obj.signInSherouk(bc);

            } else if (area.equals("Obour")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 1133);
                ObourInterface obj = (ObourInterface) reg.lookup("OBOUR");
                obj.signInObour(bc);
            } else {
                Registry reg = LocateRegistry.getRegistry("localhost", 1144);
                TagamoaInterface obj = (TagamoaInterface) reg.lookup("TAGAMOA");
                obj.signInTagamoa(bc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateMaster1GUI(String txt) {
        M1GUI.updateMaster1Screen(txt);
    }

    public void callDeposit(BankClient bc, double amount, String area) throws RemoteException {
        BankClient b = new BankClient();
        try {
            if (area.equals("Sherouk")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 1122);
                SheroukInterface obj = (SheroukInterface) reg.lookup("SHEROUK");
                b = obj.deposit(bc, amount).clone();

            } else if (area.equals("Obour")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 1133);
                ObourInterface obj = (ObourInterface) reg.lookup("OBOUR");
                b = obj.deposit(bc, amount).clone();
            } else {
                Registry reg = LocateRegistry.getRegistry("localhost", 1144);
                TagamoaInterface obj = (TagamoaInterface) reg.lookup("TAGAMOA");
                b = obj.deposit(bc, amount).clone();
            }

            for (BankClient bkc : clients) {
                if (b.getId() == bkc.getId()) {
                    bkc.setBalance(b.getBalance());
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void callWithdraw(BankClient bc, double amount, String area) throws RemoteException {
        BankClient b = new BankClient();
        try {
            if (area.equals("Sherouk")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 1122);
                SheroukInterface obj = (SheroukInterface) reg.lookup("SHEROUK");
                b = obj.withdraw(bc, amount).clone();

            } else if (area.equals("Obour")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 1133);
                ObourInterface obj = (ObourInterface) reg.lookup("OBOUR");
                b = obj.withdraw(bc, amount).clone();
            } else {
                Registry reg = LocateRegistry.getRegistry("localhost", 1144);
                TagamoaInterface obj = (TagamoaInterface) reg.lookup("TAGAMOA");
                b = obj.withdraw(bc, amount).clone();
            }

            for (BankClient bkc : clients) {
                if (b.getId() == bkc.getId()) {
                    bkc.setBalance(b.getBalance());
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String callCheckBalance(BankClient bc, String area) throws RemoteException {
        String balanceStatus = "";
        try {
            if (area.equals("Sherouk")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 1122);
                SheroukInterface obj = (SheroukInterface) reg.lookup("SHEROUK");
                balanceStatus = obj.checkBalance(bc);

            } else if (area.equals("Obour")) {
                Registry reg = LocateRegistry.getRegistry("localhost", 1133);
                ObourInterface obj = (ObourInterface) reg.lookup("OBOUR");
                balanceStatus = obj.checkBalance(bc);
            } else {
                Registry reg = LocateRegistry.getRegistry("localhost", 1144);
                TagamoaInterface obj = (TagamoaInterface) reg.lookup("TAGAMOA");
                balanceStatus = obj.checkBalance(bc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return balanceStatus;
    }

    @Override
    public String backup2in1(ArrayList<BankClient> a) throws RemoteException {
        master2Clients = (ArrayList<BankClient>) a.clone();       
        return "Back Up Complete on " + master2Clients.size() + " records\n" + master2Clients.toString();
    }
}
