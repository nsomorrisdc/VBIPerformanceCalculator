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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.collections.*;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javax.imageio.ImageIO;

/**
 * VBI Performance Calculator
 * @author David Morris - Software Engineering Intern NSO
 * 
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<String> filterselectBox;
    
    @FXML
    private TextField filterselectText;

    @FXML
    private RadioButton loosesynchRadio;

    @FXML
    private Button committreeButton;

    @FXML
    private RadioButton centerfieldRadio;

    @FXML
    private RadioButton nonesynchRadio;

    @FXML
    private RadioButton fixedsynchRadio;

    @FXML
    private RadioButton offspeckleRadio;

    @FXML
    private RadioButton onspeckleRadio;

    @FXML
    private TextField framesinputField;

    @FXML
    private RadioButton fullfieldRadio;
    
    @FXML
    private Button combineButton;
    
    @FXML
    private ImageView filterselectImageView;

    @FXML
    private void handlecommittreeButtonAction(ActionEvent event) {
        //TODO add functionality to save to tree, do not save to file until menu "Save" is selected
        
            System.out.println("Committed to Tree");
            
    }
    
    @FXML
    private void combineButtonAction(ActionEvent event) {
        System.out.println("Combining Subgroup");
    }
    
    @FXML
    public void recordFieldGroupAction(ActionEvent event) {
        //probably not going to be void will need to know which radio button is selected
      
    }
    
    @FXML
    public void speckleSelectionAction(ActionEvent event) {
        
    }
    
    @FXML
    public void fieldSelectionAction(ActionEvent event) {
        //probably not going to be void will need to know which radio button is selected
    }
    
    @FXML
    public void synchronizationSelectionAction(ActionEvent event) {
        //probably not going to be void will need to know which radio button is selected
    }
    
    private ToggleGroup groupField;
    private ToggleGroup groupSpeckle;
    private ToggleGroup groupSynch;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            layoutSetup();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Organize Radio button setup
    private void layoutSetup() throws IOException {
        //Create Camera Field, Speckle, Synchronization radio groups
        groupField = new ToggleGroup();
        groupSpeckle = new ToggleGroup();
        groupSynch = new ToggleGroup();
        
        //Set the group that both Field radio buttons will be in 
        fullfieldRadio.setToggleGroup(groupField);
        centerfieldRadio.setToggleGroup(groupField);
        //Set the group that both Speckle radio buttons will be in
        onspeckleRadio.setToggleGroup(groupSpeckle);
        offspeckleRadio.setToggleGroup(groupSpeckle);
        //Set the group that both Synchronization radio buttons will be in
        loosesynchRadio.setToggleGroup(groupSynch);
        fixedsynchRadio.setToggleGroup(groupSynch);
        nonesynchRadio.setToggleGroup(groupSynch);
        //Set initial selected buttons
        groupField.selectToggle(fullfieldRadio);
        groupSpeckle.selectToggle(onspeckleRadio);
        groupSynch.selectToggle(fixedsynchRadio);
        //Set 
        filterselectBox.setValue("Red - H Alpha 656.3 nm");
        //Add event listener
        groupField.selectedToggleProperty().addListener(event -> updateField());
        groupSpeckle.selectedToggleProperty().addListener(event -> updateSpeckle());
        groupSynch.selectedToggleProperty().addListener(event -> updateSynch());
        //Add event Listener for Combo
        filterselectBox.getSelectionModel().selectedIndexProperty().addListener(event -> updateCombo());
        
        //Control onAction events for radios and combobox
        updateField();
        updateSpeckle();
        updateSynch();
        updateCombo();
    }
    //Functions used to save the information from RadioButtons
    //Synchronization
    private void updateSynch() {
        String synchselectedToggle = groupSynch.getSelectedToggle().toString();
        //System.out.println(groupSynch.getSelectedToggle().toString());
        if(loosesynchRadio.isSelected()) {
            System.out.println("Loose Synchronization Selected");
        }
        else if(fixedsynchRadio.isSelected()) {
            System.out.println("Fixed Synchronization Selected");
        }
        else {
            System.out.println("No Synchronization Selected");
        }
    }
    //Speckle
    private void updateSpeckle() {
        String speckleselectedToggle = groupSpeckle.getSelectedToggle().toString();
        //System.out.println(groupSpeckle.getSelectedToggle().toString());
        if(onspeckleRadio.isSelected()) {
            System.out.println("Speckle ON");
            
        }
        else {
            System.out.println("Speckle OFF");
        }
    }
    //Camera Field
    private void updateField() {
        String fieldselectedToggle = groupField.getSelectedToggle().toString();
        //System.out.println(groupField.getSelectedToggle().toString());
        if(fullfieldRadio.isSelected()) {
            System.out.println("Full Camera Field Selected");
        }
        else {
            System.out.println("Center Camera Field Selected");
        }
    }
    
    //Handle ComboBox event
    public void updateCombo() {
     
        String selectedCombo = filterselectBox.getSelectionModel().getSelectedItem();
        if (selectedCombo.equals("Red - H Alpha 656.3 nm")) {
            
            Image halphaImage = new Image("/img/alanfriedman_sun_halpha.jpg");
            filterselectImageView.setImage(halphaImage);
            
            //halphaImage = new Image("file:src/images/alanfriedman_sun_halpha.jpg");
            //filterselectImageView.setImage(halphaImage);
            
            /*
            switch(selectedCombo) {
                case "Red - H Alpha 656.3 nm": halphaImage.setVisible(true); break;
                case "Blue - Ca II K 393.3 nm": caiikImage.setVisible(true); break;
            }
            */
        }
        else if(selectedCombo.equals("Blue - Ca II K 393.3 nm")) {
            Image caiikImage = new Image("/img/Sun-6May-2013.jpg");
            filterselectImageView.setImage(caiikImage);
        }
        System.out.println(selectedCombo);
        
    }
    
}
