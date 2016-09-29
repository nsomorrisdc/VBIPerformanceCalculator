/*
/*
 * Copyright 2016
 * National Solar Observatory, operated by the Association of Universities
 * for Research in Astronomy, Inc., under cooperative agreement with the
 * National Science Foundation.
 *
 * This copy of ATST software is licensed to you under the terms
 * described in the LICENSE file included in this distribution.
 *
 */

package vbiperformancecalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * VBI Performance Calculator
 * @author David Morris - Software Engineering Intern NSO
 * 
 */
public class VBIPerformanceCalculator extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = (Parent)loader.load();
        
        //FXMLDocumentController controller = (FXMLDocumentController)loader.getController();
        //controller.menufileChooser(stage);
        //Create the Scene
        Scene scene = new Scene(root);
        
        //Set the scene to the stage
        stage.setScene(scene);
        //Set the title to the stage
        stage.setTitle("VBI Instrument Performance Calculator");
        //Display the stage
        stage.show();
        
        
    }
    

   
}
