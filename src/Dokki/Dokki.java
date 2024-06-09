/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dokki;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author USER
 */
public class Dokki {
    public static void main(String[] args) throws Exception {
        System.out.println("Dokki Worker is Running...");
        DokkiRemoteClass d = new DokkiRemoteClass();
        Registry r = LocateRegistry.createRegistry(2233);
        r.bind("DOKKI", d);
    }
}
