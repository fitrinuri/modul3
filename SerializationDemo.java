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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.out;
import java.util.List;

public class SerializationDemo {

    public void serialize(List<Participant> pList, String fileName) throws FileNotFoundException {
        try 
            (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(pList);
            
            }catch (IOException ex) {
                        System.out.println("a problem accured during serialization \n" + ex.getMessage());
                    }
    }
        
        public List<Participant> deserialize (String fileName) throws ClassNotFoundException{
            List<Participant> pList= null;
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
                pList = (List<Participant>) in.readObject();              
            }catch (IOException ex){
                System.out.printf("a problem accured deserializing %s%n", fileName);
                System.out.println("ex.getMessage");
            }
            return pList;
        }

}

    
