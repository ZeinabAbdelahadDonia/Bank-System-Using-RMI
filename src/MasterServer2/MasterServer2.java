/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MasterServer2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MasterServer2 {

    public static void main(String[] args) throws Exception {
        System.out.println("Master Server 2 Running...");
        MasterServer2RemoteClass ms2 = new MasterServer2RemoteClass();
        Registry r = LocateRegistry.createRegistry(2222);
        r.bind("MASTER2", ms2);
        ms2.M2GUI.setVisible(true);
    }
}