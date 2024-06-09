/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NasrCity;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NasrCity {
     public static void main(String[] args) throws Exception {
        System.out.println("Nasr City Worker is Running...");
        NasrCityRemoteClass n = new NasrCityRemoteClass();
        Registry r = LocateRegistry.createRegistry(2244);
        r.bind("NASRCITY", n);
    }
}
