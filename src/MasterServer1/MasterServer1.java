/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MasterServer1;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MasterServer1 {

    public static void main(String[] args) throws Exception {
        System.out.println("Master Server 1 Running...");
        MasterServer1RemoteClass ms1 = new MasterServer1RemoteClass();
        Registry r = LocateRegistry.createRegistry(1111);
        r.bind("MASTER1", ms1);
        ms1.M1GUI.setVisible(true);
    }
}
