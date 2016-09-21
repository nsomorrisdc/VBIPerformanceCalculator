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
<<<<<<< HEAD
import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.round;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
=======
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
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
<<<<<<< HEAD
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeCell;
=======
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.Rectangle;
<<<<<<< HEAD
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;



=======
import javafx.beans.binding.BooleanBinding;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4


/**
 * VBI Performance Calculator
 * @author David Morris - Software Engineering Intern NSO
 * 
 */
public class FXMLDocumentController implements Initializable {
    
<<<<<<< HEAD
    int redcount = 0;
    int bluecount = 0;
    
    @FXML
    private Label infoDSPTextBox;
    
    @FXML
    private Button expandButton;
    
    @FXML
    private AnchorPane navList;
=======
    @FXML
    private TreeView channeltreeView;
    
    @FXML
    private Label infoDSPTextBox;
    
    @FXML
    private Button viewdetailsButton;
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
    
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
<<<<<<< HEAD
    private ImageView filterselectImageView;
    
    @FXML
    private Pane imagePane;
    
    @FXML
    private Pane reticlePane;
=======
    private Button combineButton;
    
    @FXML
    private ImageView filterselectImageView;
    
    @FXML
    private Pane imagePane;
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
    
    @FXML
    private Pane profilePane;
    
    @FXML
    private ImageView profileImageView;
<<<<<<< HEAD
    
    @FXML
    private TreeView<Object> redchanneltreeView;
    
    @FXML
    private TreeView<Object> bluechanneltreeView;
    
    @FXML
    private Button redremoveButton;
    
    @FXML
    private Button redcombineButton;
    
    @FXML
    private Button blueremoveButton;
    
    @FXML
    private Button bluecombineButton;
    
    @FXML
    private Button redcutButton;
    
    @FXML
    private Button redpasteButton;
    
    @FXML
    private Button bluecutButton;
    
    @FXML
    private Button bluepasteButton;
    
    @FXML
    private StackPane dspEditorStack;
    
    @FXML
    private TitledPane dspEditor;
    
    @FXML
    private TitledPane dspGroupEditor;
    
    @FXML
    private TitledPane dspRootEditor;
    
    @FXML
    private Label editorGridName;
    
    @FXML
    private Label editorrootGridName;
    
    @FXML
    private Label editorGridName2;
    
    @FXML
    private Label editorrootGridName2;
    
    @FXML
    private Label editorGridCycles;
    
    @FXML
    private Label editorrootGridCycles;
    
    @FXML
    private TextField editorGridCyclesTextField;
    
    @FXML
    private TextField editorrootGridCyclesTextField;
    
    @FXML
    private Button saveCyclesButton;
    
    @FXML
    private Button saverootCyclesButton;
    
    @FXML
    private Label redtotaltimeDisplay;
    
    @FXML
    private Label bluetotaltimeDisplay;
    
    @FXML
    private Label redcycletimeDisplay;
    
    @FXML
    private Label bluecycletimeDisplay;
    
    @FXML
    private Label redpeakdataRate;
    
    @FXML
    private Label bluepeakdataRate;
    
    @FXML
    private Label redtotaldataVolume;
    
    @FXML
    private Label bluetotaldataVolume;
    
    int rednumrootCycles = 1;
    int bluenumrootCycles = 1;
    
    //Saves the selected number of cycles to the rootInfo object
    @FXML
    private void saverootcyclesButtonAction(ActionEvent event) {
        int numrootCycles = Integer.valueOf(editorrootGridCyclesTextField.getText());
        String title;
        TreeView<Object> treeView;
        
        if (editorrootGridName2.getText().charAt(0) =='R') {
            treeView = redchanneltreeView;
            rednumrootCycles = numrootCycles;
            title = "Red";
            
        }
        else {
            treeView = bluechanneltreeView;
            bluenumrootCycles = numrootCycles;
            title = "Blue";
            
        }
        
        treeView.getSelectionModel().select(treeView.getRoot());
        TreeItem<Object> selectedrootItem = treeView.getSelectionModel().getSelectedItem();
        System.out.println(selectedrootItem);
        settotaltimeCycles();
        editorrootGridName2.setText(selectedrootItem.getValue().toString());
        editorrootGridCyclesTextField.setText(Integer.toString(numrootCycles));
        selectedrootItem.setValue(" ");
        
        selectedrootItem.setValue(title + ", " + "Cycles: "+ "x" + numrootCycles);
        
    }
    
    public void setsingletimeCycle() {
        double redtotalDuration = calcscaleTimelineRecursive(redchanneltreeView.getRoot().getChildren());
        double bluetotalDuration = calcscaleTimelineRecursive(bluechanneltreeView.getRoot().getChildren());
        
        redcycletimeDisplay.setText(Double.toString(redtotalDuration));
        bluecycletimeDisplay.setText(Double.toString(bluetotalDuration));
        
    }
    
    public void settotaltimeCycles() {
        
        System.out.println(editorrootGridName2);
        System.out.println(editorrootGridName2.getText().charAt(0));
        
        double redtotalDuration = calcscaleTimelineRecursive(redchanneltreeView.getRoot().getChildren());
        double bluetotalDuration = calcscaleTimelineRecursive(bluechanneltreeView.getRoot().getChildren());
        
        //int maxrootCycles = Math.max(rednumrootCycles, bluenumrootCycles);
        //TreeItem<Object> selectedComponent = redchanneltreeView.getSelectionModel().getSelectedItem();
        double redtotalTime = rednumrootCycles * redtotalDuration;
        double bluetotalTime = bluenumrootCycles * bluetotalDuration;
        redtotaltimeDisplay.setText(Double.toString(redtotalTime));
        bluetotaltimeDisplay.setText(Double.toString(bluetotalTime));
        
    }
    
    //Saves the selected number of cycles to the groupInfo object
    @FXML
    private void savecyclesButtonAction(ActionEvent event) {
        
        //TreeItem<Object> newcycledGroup = new TreeItem<>(new String(currentselectedInfoGroup.getGroupName() + "X" + currentselectedInfoGroup.getgroupNumCycles()));
        int numCycles = Integer.valueOf( editorGridCyclesTextField.getText() );
        TreeView<Object> treeView;
        System.out.println(editorGridName2.getText().charAt(0));
        if (editorGridName2.getText().charAt(0) == 'R') {
            
            treeView = redchanneltreeView;
        }
        else {
            treeView = bluechanneltreeView;
        }
        
        TreeItem<Object> selectedItem = treeView.getSelectionModel().getSelectedItem();
        ((groupInfo) selectedItem.getValue()).setgroupNumCycles(numCycles);
        Object obj = selectedItem.getValue();
        selectedItem.setValue(null);
        selectedItem.setValue(obj);
        setsingletimeCycle();
        settotaltimeCycles();
        //int numCycles = currentselectedGroupInfo.getgroupNumCycles();
        //String groupselectedItem = (String) selectedItem.getValue();
        //final TreeItem<Object> newgroupInfo = new TreeItem<>(currentselectedGroupInfo);
//        System.out.println(numCycles);
        clearredTimeline();
        clearblueTimeline();
        drawTimeline(redchanneltreeView.getRoot());
        drawTimeline(bluechanneltreeView.getRoot());
        
        //currentselectedGroupInfo = new groupInfo("Group 1");
        //editorGridCyclesTextField.clear();
    }
    
    @FXML
    private void fieldSelectionAction(ActionEvent event) {
        
    }
    @FXML
    private void speckleSelectionAction(ActionEvent event) {
        
    }
    @FXML
    private void synchronizationSelectionAction(ActionEvent event) {
        
    }
    @FXML
    private void filterSelectionAction(ActionEvent event) {
        
    }
    
    @FXML
    private void handlecommittreeButtonAction(ActionEvent event) {
        //TODO do not save to file until menu "Save" is selected
        System.out.println("Committed to Tree");
        addNode();

        //clearTimeline();
        clearredTimeline();
        clearblueTimeline();
        settotaltimeCycles();
        setsingletimeCycle();
        //prints out all objects in tree
        drawTimeline(redchanneltreeView.getRoot());
        drawTimeline(bluechanneltreeView.getRoot());
        currentselectedDSP = new infoDSP("Select Filter...");

        layoutReset();
            
    }
    
    //Give walktreerecursive the current values in tree
    public void drawTimeline(TreeItem<Object> rootItem2) {
        
        ObservableList<TreeItem<Object>> children = rootItem2.getChildren();   
        walkTreeRecursive(children);
        
    }
    
    //Walk through the tree and call redraw timeline
    private void walkTreeRecursive(ObservableList<TreeItem<Object>> children) {
        
        for (TreeItem<Object> treeItem: children) {
            
            if(treeItem.isLeaf() ) {
                System.out.println(((infoDSP)treeItem.getValue()).alltoString());
                updateTimeline((infoDSP)(treeItem.getValue()));
            }
            else {
                //Check if the item is a group node
                if( treeItem.getValue() instanceof groupInfo) {
                   int cycles = ((groupInfo) treeItem.getValue()).getgroupNumCycles();
                   for(int i = 0; i < cycles; i++) {
                       walkTreeRecursive(treeItem.getChildren());
                       System.out.println("Inside walktreeRecursive " + treeItem.getChildren());
                   }
                }
                else{
                    walkTreeRecursive(treeItem.getChildren());
                }
            }
            
        }
        
    }
    
//    private void calctotalDuration(ObservableList<TreeItem<Object>> children) {
//        
//        for (TreeItem<Object> treeItem: children) {
//            //System.out.println(((infoDSP)treeItem.getValue()).alltoString());
//            //updateTimeline((infoDSP)(treeItem.getValue()));
//            calctotalDuration(treeItem.getChildren());
//            if (treeItem.getValue() instanceof groupInfo) {
//                groupInfo treeItem = (groupInfo)(treeItem.getValue());
//                int i = Integer.toString(treeItem.getgroupNumCycles());
//            }
//            else {
//                
//            }
//        }
//        
//    }
    
    ArrayList<TreeItem<Object>> redsaveselectedNode = new ArrayList<TreeItem<Object>>();
    ArrayList<TreeItem<Object>> bluesaveselectedNode = new ArrayList<TreeItem<Object>>();
    //Button actions to cut/paste treeItem
    @FXML
    private void redcutButtonAction(ActionEvent event) {
        
        //ObservableList<TreeItem<Object>> saveselectedNode = getselectedCutPaste();
        ObservableList<TreeItem<Object>> selectedItems = redchanneltreeView.getSelectionModel().getSelectedItems();
        //ArrayList<TreeItem<Object>> saveselectedNode = (ArrayList<TreeItem<Object>>) redchanneltreeView.getSelectionModel().getSelectedItems();
        //System.out.println(saveselectedNode + " Cut saved nodes");
        //redsaveselectedNode = (ArrayList<TreeItem<Object>>) saveselectedNode;
        System.out.println(redsaveselectedNode + " post assign cut save nodes");
        int numNodes = selectedItems.size();

        for (int i =0; i < numNodes ; i++) 
        //for(TreeItem<Object> treeItem: selectedNode) 
        {
            //TreeItem<Object> treeItem = new TreeItem<>(selectedNode.get(0));
            TreeItem<Object> treeItem = selectedItems.get(0);
            System.out.println(treeItem);
            redsaveselectedNode.add(treeItem);
            System.out.println(treeItem);
            
            if (treeItem != null) {
                TreeItem<Object> parentNode = treeItem.getParent();
                System.out.println(parentNode);
                if(parentNode != null) {
                    parentNode.getChildren().remove(treeItem);
                    System.out.println("Leaf Cut");
                }
                else {
                    System.out.println("No parent found");
                }
            }
            else {
                System.out.println("No item selected");
            }
        }
        
        System.out.println(redsaveselectedNode + " post loop saved");
        redpasteButton.setDisable(false);
        redcutButton.setDisable(true);
=======

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
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        
    }
    
    @FXML
<<<<<<< HEAD
    private void redpasteButtonAction(ActionEvent event) {
        //System.out.println(redsaveselectedNode +" Saved nodes from member variable");
        ArrayList<TreeItem<Object>> saveselectedItems = redsaveselectedNode;
        //System.out.println(saveselectedItems + "Paste saved nodes to put back in tree");
        TreeItem<Object> selected = (TreeItem<Object>) redchanneltreeView.getSelectionModel().getSelectedItem();
        int numNodes = saveselectedItems.size();
        //System.out.println(numNodes + " Number of cut nodes to paste");
        for(int i = 0; i < numNodes; i++) {
            TreeItem<Object> treeItem = saveselectedItems.get((numNodes -1) - i);
            //System.out.println(treeItem);
            if (selected==null) {
                //Nothing is selected
                selected = redchanneltreeView.getRoot();
                redchanneltreeView.getRoot().getChildren().add(treeItem);
                redchanneltreeView.getRoot().setExpanded(true);
            } 
            //Add after selected item
            else if (selected.isLeaf() && selected != redchanneltreeView.getRoot()) {
                System.out.println("ELSE IF");
                TreeItem<Object> selectedParent = selected.getParent();
                ObservableList<TreeItem<Object>> children = selectedParent.getChildren();
                int index = children.indexOf(selected);
                selectedParent.getChildren().add(index+1,treeItem);
                
            }
            //Add to end of parent group
            else{
                System.out.println("ELSE");
                selected.getChildren().add(treeItem); 
            }
            redchanneltreeView.getSelectionModel().select(treeItem);
        }
        
        redchanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        redchanneltreeView.getSelectionModel().select(selected);
        redchanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        redsaveselectedNode.clear();
        
        clearredTimeline();
        drawTimeline(redchanneltreeView.getRoot());
        redpasteButton.setDisable(true);
        redcutButton.setDisable(false);
        
    }
    
    @FXML
    private void bluecutButtonAction(ActionEvent event) {
        //ObservableList<TreeItem<Object>> saveselectedNode = getselectedCutPaste();
        ObservableList<TreeItem<Object>> selectedItems = bluechanneltreeView.getSelectionModel().getSelectedItems();
        //ArrayList<TreeItem<Object>> saveselectedNode = (ArrayList<TreeItem<Object>>) redchanneltreeView.getSelectionModel().getSelectedItems();
        //System.out.println(saveselectedNode + " Cut saved nodes");
        //redsaveselectedNode = (ArrayList<TreeItem<Object>>) saveselectedNode;
        System.out.println(bluesaveselectedNode + " post assign cut save nodes");
        int numNodes = selectedItems.size();

        for (int i =0; i < numNodes ; i++) 
        //for(TreeItem<Object> treeItem: selectedNode) 
        {
            //TreeItem<Object> treeItem = new TreeItem<>(selectedNode.get(0));
            TreeItem<Object> treeItem = selectedItems.get(0);
            System.out.println(treeItem);
            bluesaveselectedNode.add(treeItem);
            System.out.println(treeItem);
            
            if (treeItem != null) {
                TreeItem<Object> parentNode = treeItem.getParent();
                System.out.println(parentNode);
                if(parentNode != null) {
                    parentNode.getChildren().remove(treeItem);
                    System.out.println("Leaf Cut");
                }
                else {
                    System.out.println("No parent found");
                }
            }
            else {
                System.out.println("No item selected");
            }
        }
        
        System.out.println(bluesaveselectedNode + " post loop saved");
        bluepasteButton.setDisable(false);
        bluecutButton.setDisable(true);
        
    }
    @FXML
    private void bluepasteButtonAction(ActionEvent event) {
        //System.out.println(redsaveselectedNode +" Saved nodes from member variable");
        ArrayList<TreeItem<Object>> saveselectedItems = bluesaveselectedNode;
        //System.out.println(saveselectedItems + "Paste saved nodes to put back in tree");
        TreeItem<Object> selected = (TreeItem<Object>) bluechanneltreeView.getSelectionModel().getSelectedItem();
        int numNodes = saveselectedItems.size();
        //System.out.println(numNodes + " Number of cut nodes to paste");
        for(int i = 0; i < numNodes; i++) {
            TreeItem<Object> treeItem = saveselectedItems.get((numNodes -1) - i);
            //System.out.println(treeItem);
            if (selected==null) {
                //Nothing is selected
                selected = bluechanneltreeView.getRoot();
                bluechanneltreeView.getRoot().getChildren().add(treeItem);
                bluechanneltreeView.getRoot().setExpanded(true);
            } 
            //Add after selected item
            else if (selected.isLeaf() && selected != bluechanneltreeView.getRoot()) {
                //System.out.println("ELSE IF");
                TreeItem<Object> selectedParent = selected.getParent();
                ObservableList<TreeItem<Object>> children = selectedParent.getChildren();
                int index = children.indexOf(selected);
                selectedParent.getChildren().add(index+1,treeItem);
                
            }
            //Add to end of parent group
            else{
                //System.out.println("ELSE");
                selected.getChildren().add(treeItem); 
            }
            bluechanneltreeView.getSelectionModel().select(treeItem);
        }
        
        bluechanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        bluechanneltreeView.getSelectionModel().select(selected);
        bluechanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        bluesaveselectedNode.clear();
        
        clearblueTimeline();
        drawTimeline(bluechanneltreeView.getRoot());
        bluepasteButton.setDisable(true);
        bluecutButton.setDisable(false);
        
    }
    
    //Buttons and functionality to remove selected items in tree
    @FXML
    private void redremoveButtonAction(ActionEvent event) {
        
        TreeItem<Object> selectedNode = (TreeItem<Object>) redchanneltreeView.getSelectionModel().getSelectedItem();
        if (selectedNode != null) {
            TreeItem<Object> parentNode = selectedNode.getParent();
            if(parentNode != null) {
                parentNode.getChildren().remove(selectedNode);
            }
        }
        
        TreeItem<Object> parent = redchanneltreeView.getRoot();
        
        ObservableList<TreeItem<Object>> children = parent.getChildren();
        walkTreeRecursive(parent.getChildren());
     
        if (children.isEmpty() == true) {
            
            redremoveButton.setDisable(true);
        }
        else {
            
            redremoveButton.setDisable(false);
        }
        
        clearredTimeline();
        clearblueTimeline();
        drawTimeline(redchanneltreeView.getRoot());
        drawTimeline(bluechanneltreeView.getRoot());
        
    }
    
    @FXML
    private void blueremoveButtonAction(ActionEvent event) {
        
        TreeItem<Object> selectedNode = (TreeItem<Object>) bluechanneltreeView.getSelectionModel().getSelectedItem();
        if (selectedNode != null) {
            TreeItem<Object> parentNode = selectedNode.getParent();
            if(parentNode != null) {
                parentNode.getChildren().remove(selectedNode);
            }
        }
        
        TreeItem<Object> parent = bluechanneltreeView.getRoot();
        
        ObservableList<TreeItem<Object>> children = parent.getChildren();
        System.out.println(children);
        walkTreeRecursive(parent.getChildren());
        if (children.isEmpty() == true) {
            
            blueremoveButton.setDisable(true);
        }
        else {
            
            blueremoveButton.setDisable(false);
        }
        
        clearblueTimeline();
        clearredTimeline();
        drawTimeline(bluechanneltreeView.getRoot());
        drawTimeline(redchanneltreeView.getRoot());
        
    }
    
    @FXML
    private void redcombineButtonAction(ActionEvent event) {
        redgroupFilter(); 
    }
    
    @FXML
    private void bluecombineButtonAction(ActionEvent event) {
        bluegroupFilter();
    }
=======
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
    
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            layoutSetup();
<<<<<<< HEAD
        } 
        catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private ToggleGroup groupField;
    private ToggleGroup groupSpeckle;
    private ToggleGroup groupSynch;
    
    //Organize Radio button setup
    public void layoutSetup() throws IOException {
        
        redchanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        bluechanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
=======
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        count = 1;
    }
    
    //Organize Radio button setup
    public void layoutSetup() throws IOException {
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        //Create Camera Field, Speckle, Synchronization radio groups
        groupField = new ToggleGroup();
        groupSpeckle = new ToggleGroup();
        groupSynch = new ToggleGroup();
        
<<<<<<< HEAD
        //Icons designed by Stephen Hutchings from Flaticon
        redcombineButton.setStyle("-fx-background-image: url('/img/combineicon.png')");
        redremoveButton.setStyle("-fx-background-position: center; -fx-background-image: url('/img/delete-button.png')");
        redcutButton.setStyle("-fx-background-position: center; -fx-background-image: url('/img/cut.png')");
        redpasteButton.setStyle("-fx-background-position: center; -fx-background-image: url('/img/paste-from-clipboard.png')");
        bluecombineButton.setStyle("-fx-background-image: url('/img/combineicon.png')");
        blueremoveButton.setStyle("-fx-background-position: center; -fx-background-image: url('/img/delete-button.png')");
        bluecutButton.setStyle("-fx-background-position: center; -fx-background-image: url('/img/cut.png')");
        bluepasteButton.setStyle("-fx-background-position: center; -fx-background-image: url('/img/paste-from-clipboard.png')");
        
        //Set the group that both Field radio buttons will be in 
        fullfieldRadio.setToggleGroup(groupField);
        centerfieldRadio.setToggleGroup(groupField);
        
        //Set the group that both Speckle radio buttons will be in
        onspeckleRadio.setToggleGroup(groupSpeckle);
        offspeckleRadio.setToggleGroup(groupSpeckle);
        
        //Set initial draw window for Hbox
        redchannelTimeline.setPrefWidth(680);
        bluechannelTimeline.setPrefWidth(680);
        
=======
        //Set the group that both Field radio buttons will be in 
        fullfieldRadio.setToggleGroup(groupField);
        centerfieldRadio.setToggleGroup(groupField);
        //Set the group that both Speckle radio buttons will be in
        onspeckleRadio.setToggleGroup(groupSpeckle);
        offspeckleRadio.setToggleGroup(groupSpeckle);
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        //Set the group that both Synchronization radio buttons will be in
        loosesynchRadio.setToggleGroup(groupSynch);
        fixedsynchRadio.setToggleGroup(groupSynch);
        nonesynchRadio.setToggleGroup(groupSynch);
<<<<<<< HEAD
        ObservableList<String> comboList = FXCollections.observableArrayList("Select Filter...","Red - H Alpha 656.3 nm","Red - Continuum 668.4 nm","Red - TiO 705.4 nm","Red - Fe XI 789.0 nm",
                "Blue - Ca II K 393.3 nm","Blue - G Band 430.5 nm","Blue - Continuum 450.4 nm","Blue - H Beta 486.4 nm"); 
        filterselectBox.setItems(comboList);
       
        //Set initial selected buttons
        currentselectedDSP = new infoDSP("Select Filter...");
        //currentselectedGroupInfo = new groupInfo("Group 1");
        groupField.selectToggle(currentselectedDSP.fieldSample == 0 ? fullfieldRadio : centerfieldRadio);
        groupSpeckle.selectToggle(currentselectedDSP.speckleSelect == true ? onspeckleRadio : offspeckleRadio);
        groupSynch.selectToggle(currentselectedDSP.synchronizationSelect.equals("Fixed") ? fixedsynchRadio : currentselectedDSP.synchronizationSelect.equals("Loose") ? loosesynchRadio : nonesynchRadio);
        
        //Set filter selection
        filterselectBox.setValue(comboList.get(0));
        
=======
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
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        //Add event listener
        groupField.selectedToggleProperty().addListener(event -> updateField());
        groupSpeckle.selectedToggleProperty().addListener(event -> updateSpeckle());
        groupSynch.selectedToggleProperty().addListener(event -> updateSynch());
<<<<<<< HEAD
        
        //Add event Listener for Combo
        filterselectBox.getSelectionModel().selectedIndexProperty().addListener(event -> updateCombo());
        
        //Add listener to change side panel view based on item selected
        redchanneltreeView.focusedProperty().addListener(
            (ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> redfocusDSPEditor(newValue));
        redchanneltreeView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> redselectDSPEditor(newValue));
        bluechanneltreeView.focusedProperty().addListener(
            (ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> bluefocusDSPEditor(newValue));
        bluechanneltreeView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> blueselectDSPEditor(newValue));
        
        dspRootEditor.setCollapsible(false);
        dspGroupEditor.setCollapsible(false);
        dspEditor.setCollapsible(false);
        
=======
        //Add event Listener for Combo
        filterselectBox.getSelectionModel().selectedIndexProperty().addListener(event -> updateCombo());
        
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        //Control onAction events for radios and combobox
        updateField();
        updateSpeckle();
        updateSynch();
        updateCombo();
<<<<<<< HEAD
        specklechangeListener();
        cyclechangeListener();
        rootcyclechangeListener();
        //prepareSlideMenuAnimation();
    
    }
    
    //Resets the layout to default selections after an item is committed to the tree
    public void layoutReset() {
        ObservableList<String> comboList = FXCollections.observableArrayList("Select Filter...","Red - H Alpha 656.3 nm","Red - Continuum 668.4 nm","Red - TiO 705.4 nm","Red - Fe XI 789.0 nm",
                "Blue - Ca II K 393.3 nm","Blue - G Band 430.5 nm","Blue - Continuum 450.4 nm","Blue - H Beta 486.4 nm");
        groupField.selectToggle(currentselectedDSP.fieldSample == 0 ? fullfieldRadio : centerfieldRadio);
        groupSpeckle.selectToggle(currentselectedDSP.speckleSelect == true ? onspeckleRadio : offspeckleRadio);
        groupSynch.selectToggle(currentselectedDSP.synchronizationSelect.equals("Fixed") ? fixedsynchRadio : currentselectedDSP.synchronizationSelect.equals("Loose") ? loosesynchRadio : nonesynchRadio);
        
        //Set filter selection
        filterselectBox.setValue(comboList.get(0));
    }
    
    //Find out which tree is focused to set DSP editor window
    public void redfocusDSPEditor(boolean focusedTree) {
        
        if(focusedTree) {
           System.out.println("Red Focus Gained");
           redselectDSPEditor(redchanneltreeView.getSelectionModel().getSelectedItem());
        }
        else {
           System.out.println("Red Focus Lost"); 
        }
    }
    
    public void bluefocusDSPEditor(boolean focusedTree) {
        
        if(focusedTree) {
           System.out.println("Blue Focus Gained");
           blueselectDSPEditor(bluechanneltreeView.getSelectionModel().getSelectedItem());
        }
        else {
           System.out.println("Blue Focus Lost"); 
        }
    }
    
    //Select what side panel information to save
    public void redselectDSPEditor(TreeItem<Object> selectedComponent) {
        System.out.println(selectedComponent);
        //TreeItem<Object> selected = (TreeItem<Object>) bluechanneltreeView.getSelectionModel().getSelectedItem();
        System.out.println(redchanneltreeView.isFocused());
        //System.out.println(selectedComponent.getValue());
        
        if(selectedComponent == null || selectedComponent.getValue() == "Red") {
            dspEditorStack.getChildren().remove(dspRootEditor);
            dspEditorStack.getChildren().add(dspRootEditor);
            editorrootGridName2.setText("Red");
//            //dspRootEditor.setCollapsible(false);
//            rootInfo selectedValue = (rootInfo)(selectedComponent.getValue());
            editorrootGridCyclesTextField.setText("1");
        }
        else {

            if(selectedComponent.getValue() instanceof infoDSP) {
                dspEditorStack.getChildren().remove(dspEditor);
                dspEditorStack.getChildren().add(dspEditor);
                infoDSP selectedValue = (infoDSP)(selectedComponent.getValue());
                infoDSPTextBox.setText(selectedValue.alltoString());
                //dspEditor.setCollapsible(false);
            }

            else if(selectedComponent.getValue() instanceof groupInfo && selectedComponent != redchanneltreeView.getRoot() && selectedComponent.getValue() != "Blue") {
                dspEditorStack.getChildren().remove(dspGroupEditor);
                dspEditorStack.getChildren().add(dspGroupEditor);
                //dspGroupEditor.setCollapsible(false);
                
                //currentselectedGroupInfo.setGroupName(selectedComponent.getValue().toString());
                editorGridName2.setText(selectedComponent.getValue().toString());
                //int i = selectedComponent.getValue().getgroupNumCycles();
                groupInfo selectedValue = (groupInfo)(selectedComponent.getValue());
                editorGridCyclesTextField.setText(Integer.toString(selectedValue.getgroupNumCycles()));
                //Need to set text in textfield for groups to saved cycle number
                //editorGridCyclesTextField.setText(String.valueOf(selectedComponent.getValue().getgroupNumCycles()));
                
            }
            else {
                dspEditorStack.getChildren().remove(dspRootEditor);
                dspEditorStack.getChildren().add(dspRootEditor);
                
                editorrootGridName2.setText(selectedComponent.getValue().toString());
                //System.out.println("Else selected Cycle Test");
                
                //rootInfo selectedValue = (rootInfo)(selectedComponent.getValue());
                //editorrootGridCyclesTextField.setText(Integer.toString(selectedValue.getrootNumCycles()));
            }
        }
        
    }
    //Select what side panel information to save
    public void blueselectDSPEditor(TreeItem<Object> selectedComponent) {
        System.out.println(selectedComponent);
        System.out.println(redchanneltreeView.isFocused());
        //System.out.println(selectedComponent.getValue());
        //TreeItem<Object> selected = (TreeItem<Object>) bluechanneltreeView.getSelectionModel().getSelectedItem();
        if(selectedComponent == null || selectedComponent.getValue() == "Blue") {
            dspEditorStack.getChildren().remove(dspRootEditor);
            dspEditorStack.getChildren().add(dspRootEditor);
            
            editorrootGridName2.setText("Blue");
            //dspRootEditor.setCollapsible(false);
            //rootInfo selectedValue = (rootInfo)(selectedComponent.getValue());
            editorrootGridCyclesTextField.setText("1");
            }
        else {

            if(selectedComponent.getValue() instanceof infoDSP) {
                dspEditorStack.getChildren().remove(dspEditor);
                dspEditorStack.getChildren().add(dspEditor);
                infoDSP selectedValue = (infoDSP)(selectedComponent.getValue());
                infoDSPTextBox.setText(selectedValue.alltoString());
                //dspEditor.setCollapsible(false);
            }

            else if(selectedComponent.getValue() instanceof groupInfo && selectedComponent != bluechanneltreeView.getRoot() && selectedComponent.getValue() != "Red") {
                dspEditorStack.getChildren().remove(dspGroupEditor);
                dspEditorStack.getChildren().add(dspGroupEditor);
                //dspGroupEditor.setCollapsible(false);
                //currentselectedGroupInfo.setGroupName(selectedComponent.getValue().toString());
                editorGridName2.setText(selectedComponent.getValue().toString());
                groupInfo selectedValue = (groupInfo)(selectedComponent.getValue());
                editorGridCyclesTextField.setText(Integer.toString(selectedValue.getgroupNumCycles()));
                //editorGridName2.setText(selectedComponent.getValue().toString());
            }
            else {
                dspEditorStack.getChildren().remove(dspRootEditor);
                dspEditorStack.getChildren().add(dspRootEditor);
                
                editorrootGridName2.setText(selectedComponent.getValue().toString());
                
                //rootInfo selectedValue = (rootInfo)(selectedComponent.getValue());
                //editorrootGridCyclesTextField.setText(Integer.toString(selectedValue.getrootNumCycles()));
            }
        }
        
        
    }
    
    //Record number of Cycles input to group field
    public void rootcyclechangeListener () {
        
        editorrootGridCyclesTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == null || editorrootGridCyclesTextField.getText().trim().isEmpty()) {
                System.out.println("Null Number of Cycles");
                editorrootGridCyclesTextField.clear();
            }
            else if(!isNumeric(newValue)) {
                editorrootGridCyclesTextField.clear();
                editorrootGridCyclesTextField.setText("1");
                //TreeItem<Object> redSelected = (TreeItem<Object>) redchanneltreeView.getSelectionModel().getSelectedItem().getValue();
                //currentselectedGroupInfo.setgroupNumCycles(1);
                System.out.println("Entered cycle change listener non numeric condition");
            }
            else {
                //infoDSP redSelected = (infoDSP) redchanneltreeView.getSelectionModel().getSelectedItem().getValue();
                //TreeItem<Object> redSelected = (TreeItem<Object>) redchanneltreeView.getSelectionModel().getSelectedItem().getValue();
                int numCycles = Integer.parseInt(newValue);
                System.out.println("Inside change listener " + numCycles);
                //currentselectedGroupInfo.setgroupNumCycles(numCycles);
                //newValue.toString();
                //System.out.println(currentselectedGroupInfo.toString());
            }
            
        });
    }
    
    //Record number of Cycles input to group field
    public void cyclechangeListener () {
        
        editorGridCyclesTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == null || editorGridCyclesTextField.getText().trim().isEmpty()) {
                System.out.println("Null Number of Cycles");
                editorGridCyclesTextField.clear();
            }
            else if(!isNumeric(newValue)) {
                editorGridCyclesTextField.clear();
                editorGridCyclesTextField.setText("1");
                //TreeItem<Object> redSelected = (TreeItem<Object>) redchanneltreeView.getSelectionModel().getSelectedItem().getValue();
                //currentselectedGroupInfo.setgroupNumCycles(1);
                System.out.println("Entered cycle change listener non numeric condition");
            }
            else {
                //infoDSP redSelected = (infoDSP) redchanneltreeView.getSelectionModel().getSelectedItem().getValue();
                //TreeItem<Object> redSelected = (TreeItem<Object>) redchanneltreeView.getSelectionModel().getSelectedItem().getValue();
                int numCycles = Integer.parseInt(newValue);
                System.out.println("Inside change listener " + numCycles);
                //currentselectedGroupInfo.setgroupNumCycles(numCycles);
                //newValue.toString();
                //System.out.println(currentselectedGroupInfo.toString());
            }
            
        });
    }
    
    //Functions used to save the information from RadioButtons
    //Synchronization
    public void updateSynch() {
       
        //String synchselectedToggle = groupSynch.getSelectedToggle().toString();
=======
        //setTextBox();
    
    }
    //Functions used to save the information from RadioButtons
    //Synchronization
    public String updateSynch() {
       
        String synchselectedToggle = groupSynch.getSelectedToggle().toString();
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        
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
<<<<<<< HEAD
        currentselectedDSP.alltoString();
        //return synchselectedToggle;
    }
    
    public void specklechangeListener() {
        //Add listener for speckle numFrames textfield changes
        framesinputField.textProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("Frames:" + newValue);

            if(newValue == null || framesinputField.getText().trim().isEmpty()) {

                System.out.println("Null number of frames");
                framesinputField.clear();

            }
            //Replace with 1 if outside range, ***change to: if above 11 change to 11, else set to 1
            else if(!inRange(newValue)) {
                framesinputField.clear();
                framesinputField.setText("1");
                currentselectedDSP.setNumberFrames(1);

            }
            else{
                int numFrames = Integer.parseInt(newValue);
                currentselectedDSP.setNumberFrames(numFrames);
                System.out.println(numFrames);
            }
            updateSpeckle();
        });
        
    }
    
    private boolean isNumeric(String newValue) {
        return newValue.matches("^[0-9]*$");
    }
    
    //Checks speckle textfield to see if within range 1-11
    private boolean inRange(String newValue) {
        return newValue.matches("[1-9]|10");
    }
    
    //Speckle
    public void updateSpeckle() {
       
        //String speckleselectedToggle = groupSpeckle.getSelectedToggle().toString();
=======
        currentselectedDSP.toString();
        return synchselectedToggle;
    }
    //Speckle
    public String updateSpeckle() {
       
        String speckleselectedToggle = groupSpeckle.getSelectedToggle().toString();
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        
        //Can change what the output of the selected radio button is with setUserData("Whatever you want");
        //System.out.println(groupSpeckle.getSelectedToggle().toString());
        if(onspeckleRadio.isSelected()) {
            System.out.println("Speckle ON");
            currentselectedDSP.setSpeckleSelect(true);
<<<<<<< HEAD
            currentselectedDSP.setNumberFrames(80);
            framesinputField.setDisable(true);
            framesinputField.setText("");
=======
            framesinputField.setDisable(true);
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        }
        else {
            System.out.println("Speckle OFF");
            currentselectedDSP.setSpeckleSelect(false);
            framesinputField.setDisable(false);
            
<<<<<<< HEAD
            //String framesInput = framesinputField.getText();
            //int numFrames = Integer.parseInt(framesInput);
            //currentselectedDSP.setNumberFrames(numFrames);
        }
        currentselectedDSP.alltoString();
        //return speckleselectedToggle;
=======
        }
        currentselectedDSP.toString();
        return speckleselectedToggle;
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
    }
    
    
    //Camera Field
<<<<<<< HEAD
    public void updateField() {
        
        //String fieldselectedToggle = groupField.getSelectedToggle().toString();
=======
    public String updateField() {
        
        String fieldselectedToggle = groupField.getSelectedToggle().toString();
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        updateReticle();
        
        //System.out.println(groupField.getSelectedToggle().toString());
        if(fullfieldRadio.isSelected()) {
            System.out.println("Full Camera Field Selected");
<<<<<<< HEAD
            currentselectedDSP.setNumberFields(9);
        }
        else {
            System.out.println("Center Camera Field Selected");
            currentselectedDSP.setNumberFields(1);
        }
        currentselectedDSP.alltoString();
        //return fieldselectedToggle;
=======
            currentselectedDSP.setFieldSample(0);
            
        }
        else {
            System.out.println("Center Camera Field Selected");
            currentselectedDSP.setFieldSample(1);
        }
        currentselectedDSP.toString();
        return fieldselectedToggle;
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
    }
    
    //Overlay reticle on main image
    public void updateReticle() {
        
<<<<<<< HEAD
        reticlePane.getChildren().clear();
        
        //Scene goes from: Y: 185 to 0, X: 15 to 198
        Line vleftLine = LineBuilder.create().startX(75).startY(185).endX(75).endY(0).fill(Color.BLACK).strokeWidth(2.0).build();
        Line vrightLine = LineBuilder.create().startX(140).startY(185).endX(140).endY(0).fill(Color.BLACK).strokeWidth(2.0).build();
        Line htopLine = LineBuilder.create().startX(15).startY(55).endX(198).endY(55).fill(Color.BLACK).strokeWidth(2.0).build();
        Line hbotLine = LineBuilder.create().startX(15).startY(120).endX(198).endY(120).fill(Color.BLACK).strokeWidth(2.0).build();
        Rectangle centerRect = new Rectangle();
        centerRect.setX(75);
        centerRect.setY(55);
        centerRect.setWidth(64);
        centerRect.setHeight(64);
        centerRect.setFill(Color.WHITE);
        centerRect.setOpacity(.20);
        Rectangle fullRect = new Rectangle();
        fullRect.setX(13);
        fullRect.setY(0);
        fullRect.setWidth(187);
        fullRect.setHeight(185);
        fullRect.setFill(Color.WHITE);
        fullRect.setOpacity(.20);
        
        if(fullfieldRadio.isSelected()) {
            reticlePane.getChildren().addAll(vleftLine,vrightLine,htopLine,hbotLine,fullRect);
        }
        else {
            reticlePane.getChildren().addAll(vleftLine,vrightLine,htopLine,hbotLine,centerRect);
        }
        
=======
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
        
        
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
    }
    
    //Handle ComboBox event
    public String updateCombo() {
<<<<<<< HEAD
    
        String selectedCombo = filterselectBox.getSelectionModel().getSelectedItem();
        currentselectedDSP.setFilterSelect(selectedCombo);
       
        committreeButton.setDisable(false);
        //Change filter image based on combobox selection
        switch (selectedCombo) {
            case "Red - H Alpha 656.3 nm":
                Image halphaImage = new Image("/img/halpha-656nm.png");
                Image halphaProfile = new Image("/img/ha_6563.jpg");
                filterselectImageView.setImage(halphaImage);
                profileImageView.setImage(halphaProfile);
                break;
                
            case "Red - Continuum 668.4 nm":
                Image redcontImage = new Image("/img/redcont-668nm.png");
                Image redcontProfile = new Image("/img/rc_6684.jpg");
                filterselectImageView.setImage(redcontImage);
                profileImageView.setImage(redcontProfile);
                break;
            
            case "Red - TiO 705.4 nm":
                Image redtioImage = new Image("/img/tio-705nm.png");
                Image redtioProfile = new Image("/img/tio_7058.jpg");
                filterselectImageView.setImage(redtioImage);
                profileImageView.setImage(redtioProfile);
                break;
                
            case "Red - Fe XI 789.0 nm":
                Image redfexiImage = new Image("/img/sun-clip-art.jpg");
                Image redfexiProfile = new Image("/img/feXI_7892.jpg");
                filterselectImageView.setImage(redfexiImage);
                profileImageView.setImage(redfexiProfile);
                break;
                
            case "Blue - Ca II K 393.3 nm":
                Image caiikImage = new Image("/img/caiik-393nm.png");
                Image caiikProfile = new Image("/img/ca_3936.jpg");
                filterselectImageView.setImage(caiikImage);
                profileImageView.setImage(caiikProfile);
                break;
        
            case "Blue - G Band 430.5 nm":
                Image gbandImage = new Image("/img/gband-430nm.png");
                Image gbandProfile = new Image("/img/gb_4305.jpg");
                filterselectImageView.setImage(gbandImage);
                profileImageView.setImage(gbandProfile);
                break;
                
            case "Blue - Continuum 450.4 nm":
                Image bluecontImage = new Image("/img/bluecont-450nm.png");
                Image bluecontProfile = new Image("/img/bc_4504.jpg");
                filterselectImageView.setImage(bluecontImage);
                profileImageView.setImage(bluecontProfile);
                break;
                
            case "Blue - H Beta 486.4 nm":
                Image hbetaImage = new Image("/img/hbeta-486nm.png");
                Image hbetaProfile = new Image("/img/hb_4861.jpg");
                filterselectImageView.setImage(hbetaImage);
                profileImageView.setImage(hbetaProfile);
                break;
                
            case "Select Filter...":
                committreeButton.setDisable(true);
                filterselectImageView.setImage(null);
                profileImageView.setImage(null);
                break;
                
=======
        
     
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
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
            default:
                break;
        }
        System.out.println(selectedCombo);
<<<<<<< HEAD
        currentselectedDSP.alltoString();
=======
        currentselectedDSP.toString();
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        return selectedCombo;
        
    }
    
    //Handle rectangle draw in timeline
<<<<<<< HEAD
    public void updateTimeline(infoDSP DSP) {
        
        String filterSelect = DSP.filterSelect;
        //System.out.println(currentselectedDSP.getDuration());
        int y = 105;

        double scaleItem = calcScaleTimeline();
        double scale = floor(scaleItem/680.);
        
        redchannelTimeline.setPrefWidth(scale);
        bluechannelTimeline.setPrefWidth(scale);

        double xRect = floor((DSP.getDuration() * scaleItem))-ceil(DSP.getMoveTime());

        System.out.println(xRect);
        System.out.println(redcount);
        
        Rectangle rect1 = new Rectangle(xRect,y);
        Rectangle rect2 = new Rectangle(ceil(DSP.getMoveTime()),y);
        //Rectangle rect3 = new Rectangle(580,y);
        //redchannelTimeline.setPrefWidth(scaleItem*2);
        //bluechannelTimeline.setPrefWidth(scaleItem*2);
        //Set popup tooltip contents
        Tooltip t = new Tooltip(filterSelect);
        Tooltip.install(rect1, t);
        
        switch (filterSelect) {
            //When Commit button selected create the rectangle in timeline
            case "Red - H Alpha 656.3 nm":
                {
                    //Rectangle rect1 = new Rectangle((currentselectedDSP.getDuration() + offset)/redcount,y);
                    rect1.setFill(Color.BROWN);
                    //rect3.setFill(Color.BROWN);
                    redchannelTimeline.getChildren().addAll(rect1,rect2);
                    //redchannelTimeline.getChildren().add(rect3);
                    break;
                }
      
            case "Red - Continuum 668.4 nm":
                {
                    rect1.setFill(Color.CORAL);
                    redchannelTimeline.getChildren().addAll(rect1,rect2);
                    //redchannelTimeline.getChildren().add(rect1);
                    break;
                }
            case "Red - TiO 705.4 nm":
            {
                    rect1.setFill(Color.SALMON);
                    redchannelTimeline.getChildren().addAll(rect1,rect2);
                    //redchannelTimeline.getChildren().add(rect1);
                    break;
            }
            case "Red - Fe XI 789.0 nm":
            {
                    rect1.setFill(Color.DEEPPINK);
                    redchannelTimeline.getChildren().addAll(rect1,rect2);
                    //redchannelTimeline.getChildren().add(rect1);
                    break;
            }
            case "Blue - Ca II K 393.3 nm":
                { 
                    rect1.setFill(Color.CADETBLUE);
                    bluechannelTimeline.getChildren().addAll(rect1,rect2);
                    //bluechannelTimeline.getChildren().add(rect1);
                    break;
                }
            case "Blue - G Band 430.5 nm":
            {
                    rect1.setFill(Color.AQUAMARINE);
                    bluechannelTimeline.getChildren().addAll(rect1,rect2);
                    //bluechannelTimeline.getChildren().add(rect1);
                    break;
            }
            case "Blue - Continuum 450.4 nm":
            {
                    rect1.setFill(Color.BLUEVIOLET);
                    bluechannelTimeline.getChildren().addAll(rect1,rect2);
                    //bluechannelTimeline.getChildren().add(rect1);
                    break;
            }
            case "Blue - H Beta 486.4 nm":
            {
                    rect1.setFill(Color.CORNFLOWERBLUE);
                    bluechannelTimeline.getChildren().addAll(rect1,rect2);
                    //bluechannelTimeline.getChildren().add(rect1);
                    break;
            }
            default:
                break;
        }
        
        
        
    }
    //Go through tree and calculate scale from items in tree
    private double calcscaleTimelineRecursive(ObservableList<TreeItem<Object>> children) {
        
        if(children == null) {
           return 0.0;
        }
        double totalDuration = 0.0;
        for (TreeItem<Object> treeItem: children) {
            
            if(treeItem.isLeaf() ) {
                totalDuration += ((infoDSP)treeItem.getValue()).getDuration();
                
            }
            //If the item trying to be read from the list if a group item, check to see if it has a specified number of cycles
            //Adjust the scale to reflect cycles if it is a groupInfo item
            else if(treeItem.getValue() instanceof groupInfo) {
                int cycles = ((groupInfo) treeItem.getValue()).getgroupNumCycles();
                for(int i = 0; i < cycles; i++) {
                    if(treeItem.isLeaf() ) {
                        totalDuration += ((infoDSP)treeItem.getValue()).getDuration();
                
                    }
                    else {
                        totalDuration += calcscaleTimelineRecursive(treeItem.getChildren());
                     }
                }
            }
            
            else {
                totalDuration += calcscaleTimelineRecursive(treeItem.getChildren());
            }
            
        }
        
        return totalDuration;
    }
    
    //Calculate the necessary scale for  maximum duration channel in timeline
    private double calcScaleTimeline() {
        double redtotalDuration = calcscaleTimelineRecursive(redchanneltreeView.getRoot().getChildren());
        double bluetotalDuration = calcscaleTimelineRecursive(bluechanneltreeView.getRoot().getChildren());
        
        System.out.println(redtotalDuration);
        System.out.println(bluetotalDuration);
        //int maxrootCycles = Math.max(rednumrootCycles, bluenumrootCycles);
        //TreeItem<Object> selectedComponent = redchanneltreeView.getSelectionModel().getSelectedItem();
        //double totalTime = maxrootCycles * (Math.max(redtotalDuration,bluetotalDuration));
        //totaltimeDisplay.setText(Double.toString(totalTime));
        
        return (680./(Math.max(redtotalDuration,bluetotalDuration)));
        
    }
    
    private void clearredTimeline() {
        redchannelTimeline.getChildren().clear(); 
    }
    
    private void clearblueTimeline() {
        bluechannelTimeline.getChildren().clear();
    }
    
    //Add tree node of current combo box selection when commit to tree button is pressed
    private void addNode() {
        
        TreeView<Object> treeView;
        String selectedFilter = currentselectedDSP.getFilterSelect();
        char firstSelect = selectedFilter.charAt(0);
        
        if (firstSelect == 'R') {
            System.out.println("Red Channel Selected");
            treeView = redchanneltreeView;
            redremoveButton.setDisable(false);
            
        }
        else if (firstSelect == 'B') {
            System.out.println("Blue Channel Selected");
            treeView = bluechanneltreeView;
            blueremoveButton.setDisable(false);
            
        }
        else {
            treeView = null;
        }
        
        final TreeItem<Object> newNode = new TreeItem<>(currentselectedDSP);
        TreeItem<Object> selected = (TreeItem<Object>) treeView.getSelectionModel().getSelectedItem();
        
        if (selected==null) {
            //Nothing is selected
            selected = treeView.getRoot();
            //System.out.println("ROOT");
            treeView.getRoot().getChildren().add(newNode);
            treeView.getRoot().setExpanded(true);
        } 
        else if (selected.isLeaf() && selected != treeView.getRoot()) {
            TreeItem<Object> selectedParent = selected.getParent();
            ObservableList<TreeItem<Object>> children = selectedParent.getChildren();
            int i = children.indexOf(selected);
           
            //System.out.println(i + " IM I");
            selectedParent.getChildren().add(i+1,newNode);
            
        }
        else{
            selected.getChildren().add(newNode); 
        }
        treeView.getRoot().setExpanded(true);
        
        treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        treeView.getSelectionModel().select(newNode);
        
        treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        treeView.requestFocus();
        
    }
    
   int xredGroup = 1;
   int xblueGroup = 1;
    //Merge two or more nodes in tree together into their own group
    private void redgroupFilter() {
        
        TreeItem<Object> root = redchanneltreeView.getRoot();
        final TreeItem<Object> newParent = new TreeItem<>(new groupInfo ("Red Group " + xredGroup)); 
        TreeItem<Object> parent = (TreeItem<Object>) redchanneltreeView.getSelectionModel().getSelectedItem().getParent();
        
        ObservableList<TreeItem<Object>> children = root.getChildren();   
        int treeSize = children.size();
        //Walk through the tree, *dont allow for non adjacent nodes to be grouped!
        
       
        //TreeItem<Object> root = redchanneltreeView.getRoot();
        //***IN DEVELOPMENT***
        ObservableList<TreeItem<Object>> newGroup = redchanneltreeView.getSelectionModel().getSelectedItems();
        int numItems = newGroup.size();
        System.out.println(children);
        System.out.println(newGroup);
        
        parent.getChildren().add(newParent);
        
        for (int i = 0; i < numItems; i++) {
            
            infoDSP newItem = (infoDSP) newGroup.get(i).getValue();
            newParent.getChildren().add(new TreeItem<> (newItem));
            
        }
        
        for(int i = 0; i < numItems; i++) {
            //newGroup.get(0).getParent().remove(newGroup.get(0));
            parent.getChildren().remove(newGroup.get(0));
            
        }
        
        //redcombineButton.setDisable(false);
        newParent.setExpanded(true);
        redchanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        redchanneltreeView.getSelectionModel().select(newParent);
        redchanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        xredGroup++;
    }
    
    private void bluegroupFilter() {
        
        final TreeItem<Object> newParent = new TreeItem<>(new groupInfo("Blue Group " + xblueGroup));
        TreeItem<Object> parent = (TreeItem<Object>) bluechanneltreeView.getSelectionModel().getSelectedItem().getParent();
        //TreeItem<infoDSP> newParent = new TreeItem<>(currentselectedDSP); 
        //TreeItem<Object> root = bluechanneltreeView.getRoot();
        ObservableList<TreeItem<Object>> newGroup = bluechanneltreeView.getSelectionModel().getSelectedItems();
        //System.out.println(newGroup);
        int numItems = newGroup.size();
        //root.getChildren().add(newParent);
        parent.getChildren().add(newParent);
        
        for (int i = 0; i < numItems; i++) {
            
            infoDSP newItem = (infoDSP) newGroup.get(i).getValue();
            newParent.getChildren().add(new TreeItem<> (newItem));
            
        }
        for(int i = 0; i < numItems; i++) {
            //newGroup.get(0).getParent().remove(newGroup.get(0));
            parent.getChildren().remove(newGroup.get(0));
            
        }
        newParent.setExpanded(true);
        bluechanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        bluechanneltreeView.getSelectionModel().select(newParent);
        bluechanneltreeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        xblueGroup++;
    }
    //Set up the expandable side menu to open expert options and allow for more user input
//    private void prepareSlideMenuAnimation() {
//        TranslateTransition openNav = new TranslateTransition(new Duration(350), navList);
//        openNav.setToX(816.0);
//        TranslateTransition closeNav = new TranslateTransition(new Duration(350), navList);
//        expandButton.setOnAction((ActionEvent evt) -> {
//            if(navList.getTranslateX()!=816.0) {
//                openNav.play();
//            }
//            else{
//                //closeNav.setToX(-(navList.getWidth()));
//                closeNav.setToX(636.0);
//                closeNav.play();
//            }
//        });
//        
//    }
    
    
  
=======
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
    
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
    public void loadFile() {
        
    }
    
    public void saveFile() {
        
    }
    
<<<<<<< HEAD
    //Class which holds all data contained within a DSP, filter selection and selected options
    public class infoDSP {
        private int ROI;
        private double exposureTime;
        private int exposureRate;
        private int Binning;
        private int numberFrames;
        private int numberFields;
        private int fieldSample;
        private double moveTime;
        private String filterSelect;
        private String synchronizationSelect;
        private boolean speckleSelect;
        private int numCycles;
        
        public infoDSP(String filterName) {
            //Default configuration upon load of application
             ROI = 1;
             exposureTime = 0.002;
             exposureRate = 2;
             numberFrames = 80;
             numberFields = 9;
             moveTime = 0.3;
             Binning = 2;
             fieldSample = 0;
             filterSelect = filterName;
             synchronizationSelect = "Fixed";
             speckleSelect = true;
             numCycles = 1;
             alltoString();
        }
        
        public double getDuration() {
            
            double duration = (double) (((1./exposureRate) * getNumberFrames() + getMoveTime()) * getNumberFields());
            //System.out.println(exposureRate);
            //System.out.println(numberFrames);
            //System.out.println(moveTime);
            //System.out.println(numberFields);
            //System.out.println(duration);
            return duration;
=======
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
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        }
        
        @Override
        public String toString() {
            
            String myString = new String();
<<<<<<< HEAD
            myString = getFilterSelect();
            char firstSelect = myString.charAt(0);
            if (myString != null) {
                if (firstSelect == 'R') {
                   myString = myString.replace("Red - ","");
                   return myString;
                }
                else if (firstSelect == 'B'){
                   myString = myString.replace("Blue - ", "");
                   return myString;
                }
                else {
                    return null;
                }
                
            }
            else {
                return null;
            }
            
        }
        
        
        public String alltoString() {
            
            String myString = new String();
            //Can we abstract this up into the UI setup class above?
            myString = "ROI: "+ getROI()+ "\nExposure Time: " + getExposureTime() + "\nExposure Rate: "+ getExposureRate() + "\nBinning: " + getBinning()
                    + "\nCamera Field: " + getNumberFields() + "\nFilter Selection: " + getFilterSelect() + "\nNumber of Frames: " + getNumberFrames() + "\nSynchronization Mode: " + getSynchronizationSelect()
                    + "\nSpeckle Selection: " + isSpeckleSelect(); //+ "\nTotal Time: " + Math.max(calcscaleTimelineRecursive(redchanneltreeView.getRoot().getChildren()),calcscaleTimelineRecursive(bluechanneltreeView.getRoot().getChildren()));
            
            //infoDSPTextBox.setText(myString);
=======
            //Can we abstract this up into the UI setup class above?
            myString = "ROI: "+ ROI + ", Total Exposure Time: " + exposureTime + ", Exposure Rate: "+ exposureRate + ", Binning: " + Binning
                    + ", Camera Field: " + fieldSample + ", Filter Selection: " + filterSelect + ", Synchronization Mode: " + synchronizationSelect
                    + ", Speckle Selection: " + speckleSelect;
            //myString.textProperty().bind(filterSelect);
            infoDSPTextBox.setText(myString);
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
            infoDSPTextBox.setWrapText(true);
            return myString;
            
        }
        
        //Set filter combobox selection to specific image file
<<<<<<< HEAD
        //public HashMap setfilterImage(String filterSelect) {
        //    HashMap<String, String> filterimageMap = new HashMap();
            //filterimageMap.put("Red - H Alpha 656.3 nm","/img/alanfriedman_sun_halpha.jpg");
            //filterimageMap.put(,);
             
        //    return filterimageMap;
        //}
=======
        public HashMap setfilterImage(String filterSelect, String mainImage) {
            HashMap<String, String> filterimageMap = new HashMap();
            filterimageMap.put("Red - H Alpha 656.3 nm","/img/alanfriedman_sun_halpha.jpg");
            
            
            return filterimageMap;
        }
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4

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
<<<<<<< HEAD
        public double getExposureTime() {
=======
        public int getExposureTime() {
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
            return exposureTime;
        }

        /**
<<<<<<< HEAD
=======
         * @param exposureTime the exposureTime to set
         */
        public void setExposureTime(int exposureTime) {
            this.exposureTime = exposureTime;
        }

        /**
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
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
<<<<<<< HEAD
        
        public void setFilterSelect(String selectedFilter) {
            this.filterSelect = selectedFilter;
=======

        /**
         * @param filterSelect the filterSelect to set
         */
        public void setFilterSelect(String filterSelect) {
            this.filterSelect = filterSelect;
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
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
<<<<<<< HEAD

        /**
         * @return the numberFrames
         */
        public int getNumberFrames() {
            return numberFrames;
        }

        /**
         * @param numberFrames the numberFrames to set
         */
        public void setNumberFrames(int numberFrames) {
            this.numberFrames = numberFrames;
        }

        /**
         * @return the numberFields
         */
        public int getNumberFields() {
            return numberFields;
        }

        /**
         * @param numberFields the numberFields to set
         */
        public void setNumberFields(int numberFields) {
            this.numberFields = numberFields;
        }

        /**
         * @return the moveTime
         */
        public double getMoveTime() {
            return moveTime;
        }

        /**
         * @param moveTime the moveTime to set
         */
        public void setMoveTime(int moveTime) {
            this.moveTime = moveTime;
        }

        /**
         * @param exposureTime the exposureTime to set
         */
        public void setExposureTime(double exposureTime) {
            this.exposureTime = exposureTime;
        }

        /**
         * @param moveTime the moveTime to set
         */
        public void setMoveTime(double moveTime) {
            this.moveTime = moveTime;
        }

        /**
         * @return the numCycles
         */
        public int getNumCycles() {
            return numCycles;
        }

        /**
         * @param numCycles the numCycles to set
         */
        public void setNumCycles(int numCycles) {
            this.numCycles = numCycles;
        }  
=======
        
        
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
        
    }
    
    private infoDSP currentselectedDSP;
<<<<<<< HEAD
    //private infoDSP treeitemnameinfoDSP;
    //private groupInfo currentselectedGroupInfo;
=======
>>>>>>> 014ddb9b01f7ed28757a64e8be1c8f63cbfd5db4
    
}


