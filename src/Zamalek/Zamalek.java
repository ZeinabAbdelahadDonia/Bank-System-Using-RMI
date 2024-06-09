/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Zamalek;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Zamalek {
     public static void main(String[] args) throws Exception {
        System.out.println("Zamalek Worker is Running...");
        ZamalekRemoteClass d = new ZamalekRemoteClass();
        Registry r = LocateRegistry.createRegistry(2255);
        r.bind("ZAMALEK", d);
    }
}
