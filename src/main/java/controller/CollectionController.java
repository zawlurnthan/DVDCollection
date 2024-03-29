/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.CollectionDao;
import model.DVD;
import view.CollectionView;

/**
 *
 * @author Zaw L Than
 */
public class CollectionController {
    private final CollectionView view;
    private final CollectionDao dao;

    public CollectionController(CollectionView view, CollectionDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        
        while (keepGoing) {
            int menuSelection = view.printMenuAndGetSelection();
            
            switch(menuSelection) {
                case 1:
                    // create dvd
                    createDVD();
                    break;
                    
                case 2:
                    // remove dvd
                    removeDVD();
                    break;
                    
                case 3:
                    // edit dvd info
                    editDVD();
                    break;
                    
                case 4:
                    // list all DVDs
                    listAllDVDs();
                    break;
                    
                case 5:
                    // get a dvd info
                    getDVDInfo();
                    break;
                    
                case 6:
                    // search by title
                    searchByTitle();
                    break;
                    
                case 7:
                    keepGoing = false;
                    break;
                    
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }
    
    private void createDVD() {
        DVD dvd = view.getNewDVDInfo();
        dao.addDvd(dvd.getId(), dvd);
    }
    
    private void removeDVD() {
        String id = view.getDVDId();
        DVD dvd = dao.removeDvd(id);
        view.displayRemoveResult(dvd);
    }
    
    private void editDVD() {
        String id = view.getDVDId();
        DVD dvd = dao.getADvd(id);
        view.displayADVD(dvd);
        DVD editedDvd = view.getDVDInfoToEdit(id);
        dao.addDvd(id, editedDvd);
        view.displayEditResult(editedDvd);
    }
    
    private void listAllDVDs() {
        List<DVD> list = dao.getAllDvds();
        view.displayDVDList(list);
    }
    
    private void getDVDInfo() {
        String id = view.getDVDId();
        DVD dvd = dao.getADvd(id);
        view.displayADVD(dvd);
        view.continueMessage();
    }
    
    private void searchByTitle() {
        String title = view.getTitle();
        DVD dvd = dao.searchByTitle(title);
        view.displayADVD(dvd);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommand();
    }
    
    private void exitMessage() {
        view.displayExitMessage();
    }
}
