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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ParticipantSer implements Serializable{
    
    private String firstName;
    private String lastName;
    private int age;
    
    public ParticipantSer(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public void printData(){
        System.out.println("Nama\t: " + firstName + " " +  lastName);
        System.out.println("Usia\t: " + age);
    }
    
    public void saveObject(ParticipantSer Obj){
        try{
            FileOutputStream fos = new FileOutputStream("data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Obj);
            oos.flush();
            fos.close();
            
        }catch (IOException ioe){
            System.out.println("a problem accured during serialize.\n " + ioe.getMessage());
        }
    }
    
    public void readObject(ParticipantSer Obj) throws ClassNotFoundException{
        try{
            FileInputStream fis = new FileInputStream("data.ser");
            ObjectInputStream ois= new ObjectInputStream(fis);
            Obj = (ParticipantSer) ois.readObject();
            Obj.printData();
            fis.close();
            
            }catch (IOException ex){
                System.out.println("a problem accured during deserialize.\n"+ ex);
                System.exit(1);
        
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        ParticipantSer is = new ParticipantSer("Fitri", "nuri", 21);
        is.saveObject(is);
        is.readObject(is);
        
    }
    
}
