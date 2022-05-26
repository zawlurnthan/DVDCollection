/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Zaw L Than
 */
public class CollectionDaoImpl implements CollectionDao {

    // have a data structure to hold all the information
    private final Map<String, DVD> collection = new HashMap<>();
    public static final String COLLECTION_FILE = "collection.txt";
    public static final String DELIMITER = "::";
    
    
    @Override
    public DVD addDvd(String id, DVD dvd) {
        DVD newDvd = collection.put(id, dvd);
        writeTextFile();
        return newDvd;
    }

    @Override
    public DVD removeDvd(String id) {    
        readTextFile();
        DVD dvd = collection.remove(id);
        writeTextFile();
        return dvd;
    }

//    @Override
//    public DVD editDvd(String id) {
//        readTextFile();
//        DVD dvd = collection.get(id);
//        writeTextFile();
//        return dvd;
//    }

    @Override
    public List<DVD> getAllDvds() {
        readTextFile();
        return new ArrayList<>(collection.values());
    }

    @Override
    public DVD getADvd(String id) {
        readTextFile();
        return collection.get(id);
    }

    @Override
    public DVD searchByTitle(String title) {
        readTextFile();
//        for (DVD dvd : collection.values())
//            if (title.equals(dvd.getTitle())) {
//                return dvd; 
//            }
        return collection.values().stream().filter(x -> x.getTitle().equalsIgnoreCase(title)).findAny().get();
    }
    
    // convert object to text
    // write object into text file
    private String marshallDVD(DVD dvd) {
        String dvdAsText = dvd.getId() + DELIMITER 
                + dvd.getTitle() + DELIMITER 
                + dvd.getReleaseDate() + DELIMITER
                + dvd.getMPAArating() + DELIMITER
                + dvd.getDirector() + DELIMITER
                + dvd.getStudio() + DELIMITER
                + dvd.getUserRating();
        return dvdAsText;
    }
    
        // Write text file by using PrinWriter
    // Open file by using FileWriter to write 
    private void writeTextFile() {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(COLLECTION_FILE));
            String text;
//            List<DVD> list = this.getAllDvds();
            for (DVD dvd : collection.values()) {
                // convert dvd object to text
                text = marshallDVD(dvd);
                out.println(text);
                out.flush();
            }
            out.close();
            
        } catch (IOException e) {
            System.out.println("Could not save dvd data");
        }
    }
        
    // convert text to object
    // read record from text file 
    private DVD unmarshallDVD(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String id = dvdTokens[0];
        DVD dvd = new DVD(id);
        dvd.setTitle(dvdTokens[1]);
        dvd.setReleaseDate(dvdTokens[2]);
        dvd.setMPAArating(dvdTokens[3]);
        dvd.setDirector(dvdTokens[4]);
        dvd.setStudio(dvdTokens[5]);
        dvd.setUserRating(dvdTokens[6]);
        return dvd;
    }
    
    // Read text file by using Scanner
    // Use BufferedReader
    // Open File by using FileReader to read
    private void readTextFile() {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(COLLECTION_FILE)));
            String line;
            DVD dvd;

            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                dvd = unmarshallDVD(line);
                collection.put(dvd.getId(), dvd);
            }
            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("-_- Could not load collection data into memory."); 
        }
    }
}
