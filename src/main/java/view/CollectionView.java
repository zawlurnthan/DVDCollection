/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import model.DVD;

/**
 *
 * @author Zaw L Than
 */
public class CollectionView {
    private final UserIO io;

    public CollectionView(UserIO io) {
        this.io = io;
    } 
    
    public int printMenuAndGetSelection(){
        io.print("\nMain Menu");
        io.print("1. Add new DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List of all DVDs");
        io.print("5. Get a DVD info");
        io.print("6. Search a DVD by Title");
        io.print("7. Exit");
        return io.readInt("Please select the choices.", 1, 7);
    }
    
    public DVD getNewDVDInfo() {
        String id = io.readString("\nPlease enter DVD ID");
        String title = io.readString("Please enter DVD title");
        String date = io.readString("Please enter DVD releaseDate");
        String rating = io.readString("Please enter DVD MPAA rating");
        String director = io.readString("Please enter DVD director Name");
        String studio = io.readString("Please enter studio name");
        String userRating = io.readString("Please enter user rating");
                
        return new DVD(id, title, date, rating, director, studio, userRating);
    }
    
    public void displayDVDList(List<DVD> list) {
        for (DVD dvd : list) {
            io.print("\n"+dvd.getId());
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAArating());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            System.out.println();
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayADVD(DVD dvd) {
        if (dvd != null) {
            io.print("\n"+dvd.getId());
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAArating());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
        } else {
            io.print("No such student");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public String getDVDId() {
        return io.readString("\nPlease enter the dvd ID.");
    }
    
    public void displayRemoveResult(DVD dvd) {
        if (dvd != null) {
            io.print("\nDVD is successfully removed.");
        } else {
            io.print("No such a dvd.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayEditResult(DVD dvd) {
        if (dvd != null) {
            io.print("\nDVD is successfully edited.");
        } else {
            io.print("No such a dvd.");
        }
        io.readString("Please hit enter to continue.");        
    }
    
    public String getTitle() {
        return io.readString("\nEnter title to search DVD.");
    }
    
    public void displayUnknownCommand() {
        io.print("\nUnknown Command!!!");
    }
}
