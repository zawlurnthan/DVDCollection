package Collection;

import controller.CollectionController;
import model.CollectionDao;
import model.CollectionDaoImpl;
import view.CollectionView;
import view.UserIO;
import view.UserIOImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zaw L Than
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        CollectionView view = new CollectionView(io);
        CollectionDao dao = new CollectionDaoImpl();
        CollectionController controller = new CollectionController(view, dao);
        controller.run();
    }
}

// Step 1
// List Requirements
 
// Step 2
// Design (Identify the required Classes)
//  DATA
//      1. DTO
//      2. DAO
//  View
//      3. UserIO
//      4. View
//  Controller
//      5. controller
//      7. AppMain


// Step 3
// Define properties and methods for each class.

// Step 4
// Formatting database or files

// Step 5
// Construction