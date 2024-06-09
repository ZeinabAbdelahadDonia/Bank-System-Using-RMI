/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tagamoa;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Tagamoa {
    public static void main(String[] args) throws Exception {
        System.out.println("Tagamoa Worker is Running...");
        TagamoaRemoteClass t = new TagamoaRemoteClass();
        Registry r = LocateRegistry.createRegistry(1144);
        r.bind("TAGAMOA", t);
    }
}
