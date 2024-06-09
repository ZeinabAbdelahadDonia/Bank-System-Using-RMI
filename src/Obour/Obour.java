/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Obour;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author USER
 */
public class Obour {
    public static void main(String[] args) throws Exception {
        System.out.println("Obour Worker is Running...");
        ObourRemoteClass o = new ObourRemoteClass();
        Registry r = LocateRegistry.createRegistry(1133);
        r.bind("OBOUR", o);
    }
}
