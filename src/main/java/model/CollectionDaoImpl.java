/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Zaw L Than
 */
public class CollectionDaoImpl implements CollectionDao {

    // have a data structure to hold all the information
    private Map<String, DVD> collection = new HashMap<>();
    
    
    @Override
    public DVD addDvd(String id, DVD dvd) {
        return collection.put(id, dvd);
    }

    @Override
    public DVD removeDvd(String id) {       
        return collection.remove(id);
    }

    @Override
    public DVD editDvd(String id) {
        return collection.get(id);
    }

    @Override
    public List<DVD> getAllDvds() {
        return new ArrayList<DVD>(collection.values());
    }

    @Override
    public DVD getADvd(String id) {
        return collection.get(id);
    }

//    @Override
//    public DVD searchByTitle(String title) {
//        DVD dvd = collection.containsValue(title);
//        return dvd;
//    }
}
