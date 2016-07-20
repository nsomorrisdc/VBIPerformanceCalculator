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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
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
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.Rectangle;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


/**
 * VBI Performance Calculator
 * @author David Morris - Software Engineering Intern NSO
 * 
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TreeView channeltreeView;
    
    @FXML
    private Label infoDSPTextBox;
    
    @FXML
    private Button viewdetailsButton;
    
    @FXML
    private HBox redchannelTimeline;
    
    @FXML
    private HBox bluechannelTimeline;
    
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
    private Pane imagePane;
    
    @FXML
    private Pane profilePane;
    
    @FXML
    private ImageView profileImageView;

    @FXML
    private void handlecommittreeButtonAction(ActionEvent event) {
        //TODO add functionality to save to tree, do not save to file until menu "Save" is selected
        
            System.out.println("Committed to Tree");
            addNode();
            updateTimeline();
            
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
    private int count;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            layoutSetup();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        count = 1;
    }
    
    //Organize Radio button setup
    public void layoutSetup() throws IOException {
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
        ObservableList<String> comboList = FXCollections.observableArrayList("Red - H Alpha 656.3 nm","Red - Red Continuum 668.4 nm","Red - TiO 705.4 nm","Red - Fe XI 789.0 nm",
                "Blue - Ca II K 393.3 nm","Blue - G Band 430.5 nm","Blue - Blue Continuum 450.4 nm","Blue - H Beta 486.4 nm"); 
        filterselectBox.setItems(comboList);
        //Set initial selected buttons
        currentselectedDSP = new infoDSP();
        
        groupField.selectToggle(currentselectedDSP.fieldSample == 0 ? fullfieldRadio : centerfieldRadio);
        groupSpeckle.selectToggle(currentselectedDSP.speckleSelect == true ? onspeckleRadio : offspeckleRadio);
        //Does not work 100% yet below need to have option for fixed, loose and none***
        groupSynch.selectToggle(currentselectedDSP.synchronizationSelect == "Fixed" ? fixedsynchRadio : loosesynchRadio);
        //Set filter selection
        filterselectBox.setValue(comboList.get(0));
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
        //setTextBox();
    
    }
    //Functions used to save the information from RadioButtons
    //Synchronization
    public String updateSynch() {
       
        String synchselectedToggle = groupSynch.getSelectedToggle().toString();
        
        //System.out.println(groupSynch.getSelectedToggle().toString());
        if(loosesynchRadio.isSelected()) {
            System.out.println("Loose Synchronization Selected");
            currentselectedDSP.setSynchronizationSelect("Loose");
        }
        else if(fixedsynchRadio.isSelected()) {
            System.out.println("Fixed Synchronization Selected");
            currentselectedDSP.setSynchronizationSelect("Fixed");
        }
        else {
            System.out.println("No Synchronization Selected");
            currentselectedDSP.setSynchronizationSelect("None");
        }
        currentselectedDSP.toString();
        return synchselectedToggle;
    }
    //Speckle
    public String updateSpeckle() {
       
        String speckleselectedToggle = groupSpeckle.getSelectedToggle().toString();
        
        //Can change what the output of the selected radio button is with setUserData("Whatever you want");
        //System.out.println(groupSpeckle.getSelectedToggle().toString());
        if(onspeckleRadio.isSelected()) {
            System.out.println("Speckle ON");
            currentselectedDSP.setSpeckleSelect(true);
            framesinputField.setDisable(true);
        }
        else {
            System.out.println("Speckle OFF");
            currentselectedDSP.setSpeckleSelect(false);
            framesinputField.setDisable(false);
            
        }
        currentselectedDSP.toString();
        return speckleselectedToggle;
    }
    
    
    //Camera Field
    public String updateField() {
        
        String fieldselectedToggle = groupField.getSelectedToggle().toString();
        updateReticle();
        
        //System.out.println(groupField.getSelectedToggle().toString());
        if(fullfieldRadio.isSelected()) {
            System.out.println("Full Camera Field Selected");
            currentselectedDSP.setFieldSample(0);
            
        }
        else {
            System.out.println("Center Camera Field Selected");
            currentselectedDSP.setFieldSample(1);
        }
        currentselectedDSP.toString();
        return fieldselectedToggle;
    }
    
    //Overlay reticle on main image
    public void updateReticle() {
        
        //Scene goes from: Y: 195 to 5, X: 23 to 213
        //Group reticleGroup = new Group();
        Line vleftLine = LineBuilder.create().startX(85).startY(195).endX(85).endY(5).fill(Color.BLUE).strokeWidth(2.0).build();
        Line vrightLine = LineBuilder.create().startX(150).startY(195).endX(150).endY(5).fill(Color.RED).strokeWidth(2.0).build();
        Line htopLine = LineBuilder.create().startX(23).startY(65).endX(213).endY(65).fill(Color.BLUEVIOLET).strokeWidth(2.0).build();
        Line hbotLine = LineBuilder.create().startX(23).startY(130).endX(213).endY(130).fill(Color.CHARTREUSE).strokeWidth(2.0).build();
        Rectangle centerRect = new Rectangle();
        centerRect.setX(87);
        centerRect.setY(67);
        centerRect.setWidth(61);
        centerRect.setHeight(61);
        centerRect.setFill(Color.BROWN);
        centerRect.setOpacity(.20);
        Rectangle fullRect = new Rectangle();
        fullRect.setX(23);
        fullRect.setY(5);
        fullRect.setWidth(190);
        fullRect.setHeight(190);
        fullRect.setFill(Color.TEAL);
        fullRect.setOpacity(.20);
        //reticleGroup.getChildren().addAll(vleftLine,vrightLine,htopLine,hbotLine);
        
        if(fullfieldRadio.isSelected()) {
            //centerRect.setVisible(false);
            //imagePane.getChildren().removeAll();
            imagePane.getChildren().addAll(vleftLine,vrightLine,htopLine,hbotLine,fullRect);
            
        }
        else {
            //fullRect.setVisible(false);
            //imagePane.getChildren().removeAll();
            imagePane.getChildren().addAll(vleftLine,vrightLine,htopLine,hbotLine,centerRect);
        }
        
        
    }
    
    //Handle ComboBox event
    public String updateCombo() {
        
     
        String selectedCombo = filterselectBox.getSelectionModel().getSelectedItem();
        currentselectedDSP.setFilterSelect(selectedCombo);
        
        
        //Change filter image based on combobox selection
        switch (selectedCombo) {
            case "Red - H Alpha 656.3 nm":
                
                Image halphaImage = new Image("/img/alanfriedman_sun_halpha.jpg");
                filterselectImageView.setImage(halphaImage);
               
                
                break;
            case "Blue - Ca II K 393.3 nm":
                Image caiikImage = new Image("/img/Sun-6May-2013.jpg");
                filterselectImageView.setImage(caiikImage);
               
                break;
        
            case "Blue - G Band 430.5 nm":
                
                break;
            case "Blue - Blue Continuum 450.4 nm":
                
                break;
            default:
                break;
        }
        System.out.println(selectedCombo);
        currentselectedDSP.toString();
        return selectedCombo;
        
    }
    
    //Handle rectangle draw in timeline
    public Rectangle updateTimeline() {
      
        String selectedCombo = filterselectBox.getSelectionModel().getSelectedItem();
        
        int x = 100;
        int y = 100;
        
        switch (selectedCombo) {
            //When Commit button selected create the rectangle in timeline
            case "Red - H Alpha 656.3 nm":
                {
                    Rectangle rect1 = new Rectangle(x,y);
                    //Set popup tooltip contents
                    Tooltip t = new Tooltip("H Alpha 656.3 nm");
                    Tooltip.install(rect1, t);
                    rect1.setFill(Color.CORNFLOWERBLUE);
                    Rectangle rect2 = new Rectangle(x/5,y);
                    redchannelTimeline.getChildren().addAll(rect1, rect2);
                    break;
                }
      
            case "Red - Red Continuum 668.4 nm":
                {
                    Rectangle rect1 = new Rectangle(x/3,y);
                    //Set popup tooltip contents
                    Tooltip t = new Tooltip("Red Continuum 668.4 nm");
                    Tooltip.install(rect1, t);
                    rect1.setFill(Color.CORAL);
                    Rectangle rect2 = new Rectangle(x/8,y);
                    redchannelTimeline.getChildren().addAll(rect1, rect2);
                    break;
                }
            case "Blue - Ca II K 393.3 nm":
                {
                    Rectangle rect1 = new Rectangle(x,y);
                    //Set popup tooltip contents
                    Tooltip t = new Tooltip("Ca II K 393.3 nm");
                    Tooltip.install(rect1, t);
                    rect1.setFill(Color.CADETBLUE);
                    Rectangle rect2 = new Rectangle(x/5,y);
                    bluechannelTimeline.getChildren().addAll(rect1, rect2);
                    break;
                }
            default:
                break;
        }
        //Will return which rectangle was created and assign it a value to save in file
        Rectangle rect1 = null;
        
        return rect1;
        
    }
    
    private void addNode() {
        String selectedCombo = filterselectBox.getSelectionModel().getSelectedItem();
        TreeItem<String> parent = (TreeItem<String>) channeltreeView.getSelectionModel().getSelectedItem();
        
        if (parent==null) {
            parent = channeltreeView.getRoot();
        }
        parent.setExpanded(true);
        //Add section where check if selectedCombo is already present within tree, if so add count to child's name in tree and increment count
        count++;
        final TreeItem<String> newNode = new TreeItem<>(selectedCombo+" "+count);
        parent.getChildren().add(newNode);
        
        channeltreeView.getSelectionModel().select(parent);
        
    }
    /*
    public void setTextBox(String myString) {
        infoDSPTextBox.setText(myString);
        infoDSPTextBox.setWrapText(true);
        
    }
    */
    
    public void loadFile() {
        
    }
    
    public void saveFile() {
        
    }
    
    public class infoDSP {
        private int ROI;
        private int exposureTime;
        private int exposureRate;
        private int Binning;
        private int fieldSample;
        private String filterSelect;
        private String synchronizationSelect;
        private boolean speckleSelect;
        
        public infoDSP() {
            //Default configuration upon load of application
             ROI = 1;
             exposureTime = 20;
             exposureRate = 2;
             Binning = 2;
             fieldSample = 0;
             filterSelect = "Red - H Alpha 656.3 nm";
             synchronizationSelect = "Fixed";
             speckleSelect = true;
             toString();
        }
        
        @Override
        public String toString() {
            
            String myString = new String();
            //Can we abstract this up into the UI setup class above?
            myString = "ROI: "+ ROI + ", Total Exposure Time: " + exposureTime + ", Exposure Rate: "+ exposureRate + ", Binning: " + Binning
                    + ", Camera Field: " + fieldSample + ", Filter Selection: " + filterSelect + ", Synchronization Mode: " + synchronizationSelect
                    + ", Speckle Selection: " + speckleSelect;
            //myString.textProperty().bind(filterSelect);
            infoDSPTextBox.setText(myString);
            infoDSPTextBox.setWrapText(true);
            return myString;
            
        }
        
        //Set filter combobox selection to specific image file
        public HashMap setfilterImage(String filterSelect, String mainImage) {
            HashMap<String, String> filterimageMap = new HashMap();
            filterimageMap.put("Red - H Alpha 656.3 nm","/img/alanfriedman_sun_halpha.jpg");
            
            
            return filterimageMap;
        }

        /**
         * @return the ROI
         */
        public int getROI() {
            return ROI;
        }

        /**
         * @param ROI the ROI to set
         */
        public void setROI(int ROI) {
            this.ROI = ROI;
        }

        /**
         * @return the exposureTime
         */
        public int getExposureTime() {
            return exposureTime;
        }

        /**
         * @param exposureTime the exposureTime to set
         */
        public void setExposureTime(int exposureTime) {
            this.exposureTime = exposureTime;
        }

        /**
         * @return the exposureRate
         */
        public int getExposureRate() {
            return exposureRate;
        }

        /**
         * @param exposureRate the exposureRate to set
         */
        public void setExposureRate(int exposureRate) {
            this.exposureRate = exposureRate;
        }

        /**
         * @return the Binning
         */
        public int getBinning() {
            return Binning;
        }

        /**
         * @param Binning the Binning to set
         */
        public void setBinning(int Binning) {
            this.Binning = Binning;
        }

        /**
         * @return the fieldSample
         */
        public int getFieldSample() {
            return fieldSample;
        }

        /**
         * @param fieldSample the fieldSample to set
         */
        public void setFieldSample(int fieldSample) {
            this.fieldSample = fieldSample;
        }

        /**
         * @return the filterSelect
         */
        public String getFilterSelect() {
            return filterSelect;
        }

        /**
         * @param filterSelect the filterSelect to set
         */
        public void setFilterSelect(String filterSelect) {
            this.filterSelect = filterSelect;
        }

        /**
         * @return the synchronizationSelect
         */
        public String getSynchronizationSelect() {
            return synchronizationSelect;
        }

        /**
         * @param synchronizationSelect the synchronizationSelect to set
         */
        public void setSynchronizationSelect(String synchronizationSelect) {
            this.synchronizationSelect = synchronizationSelect;
        }

        /**
         * @return the speckleSelect
         */
        public boolean isSpeckleSelect() {
            return speckleSelect;
        }

        /**
         * @param speckleSelect the speckleSelect to set
         */
        public void setSpeckleSelect(boolean speckleSelect) {
            this.speckleSelect = speckleSelect;
        }
        
        
        
    }
    
    private infoDSP currentselectedDSP;
    
}


