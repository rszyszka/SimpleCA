/*
 * Copyright (C) 2018 Szysz
 */
package main;

import automata_1.CellularAutomat;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import gui.*;
import viewer.CellViewer;
import viewer.ConsoleCellViewer;

/**
 *
 * @author Szysz
 */
public class Main extends Application {

    FXMLController controller;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader mainLoader = new FXMLLoader(this.getClass().getResource("../gui/FXML.fxml"));
        Parent mainNode = mainLoader.load();
        controller = mainLoader.getController();
        Scene scene = new Scene(mainNode);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public void view(){
        controller.view();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
