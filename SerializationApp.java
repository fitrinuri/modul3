/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul3;

/**
 *
 * @author hp
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SerializationApp {
    
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        List<Participant> participants = new ArrayList<Participant>();
        
        
        System.out.println("Masukkan nama awal");
        InputStream input = System.in;
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader bufred = new BufferedReader(reader);
        String firstname = bufred.readLine();
        System.out.println("Masukkan nama akhir");
        String lastname = bufred.readLine();
        System.out.println("Masukkan usia");
        int usia = Integer.parseInt(bufred.readLine());

        participants.add(new Participant(firstname, lastname, usia));
        
        participants.add(new Participant("Fitri", "nuri", 21));
        participants.add(new Participant("Achmad", "joko", 25));
        participants.add(new Participant("Muna", "jatul", 20));
        participants.add(new Participant("Ratna", "novita", 21));
        
        System.out.println("Participants : " + participants);
        
        SerializationDemo demo = new SerializationDemo();
        demo.serialize(participants, "participantData.ser");
        System.out.println("serialization is done");
        
        System.out.println("Deserialize object.....");
        List<Participant> newList = demo.deserialize("participantData.ser");
        System.out.println("New List: " + newList);
        
        
    }
    
}
