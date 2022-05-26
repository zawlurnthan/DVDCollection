/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Zaw L Than
 */
public interface CollectionDao {
    DVD addDvd(String id, DVD dvd);
    DVD removeDvd(String id);
    DVD editDvd(String id);
    List<DVD> getAllDvds();
    DVD getADvd(String id);
    DVD searchByTitle(String title);
}
