/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sherouk;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Sherouk {
    public static void main(String[] args) throws Exception {
        System.out.println("Sherouk Worker is Running...");
        SheroukRemoteClass s = new SheroukRemoteClass();
        Registry r = LocateRegistry.createRegistry(1122);
        r.bind("SHEROUK", s);
    }
}
