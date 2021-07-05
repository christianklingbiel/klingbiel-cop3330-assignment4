package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christian Klingbiel
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ToDoListController {
    @FXML
    private TextField textDisplay;

    @FXML
    public void addToDoListButtonClicked(ActionEvent actionEvent) {
        addToDoList();
    }

    @FXML
    public void removeToDoListButtonClicked(ActionEvent actionEvent) {
        removeToDoList();
    }

    @FXML
    public void editToDoListTitleButtonClicked(ActionEvent actionEvent) {
        editToDoListTitle();
    }

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        addItem();
    }

    @FXML
    public void removeItemButtonClicked(ActionEvent actionEvent) {
        removeItem();
    }

    @FXML
    public void editItemDescriptionButtonClicked(ActionEvent actionEvent) {
        editItemDescription();
    }

    @FXML
    public void editItemDueDateButtonClicked(ActionEvent actionEvent) {
        editItemDueDate();
    }

    @FXML
    public void markItemCompleteButtonClicked(ActionEvent actionEvent) {
        markItemComplete();
    }

    @FXML
    public void displayAllItemsButtonClicked(ActionEvent actionEvent) {
        displayAllItems();
    }

    @FXML
    public void displayIncompletionsButtonClicked(ActionEvent actionEvent) {
        displayIncompletions();
    }

    @FXML
    public void displayCompletionsButtonClicked(ActionEvent actionEvent) {
        displayCompletions();
    }

    @FXML
    public void saveItemsButtonClicked(ActionEvent actionEvent) {
        saveItems();
    }

    @FXML
    public void saveAllItemsButtonClicked(ActionEvent actionEvent) {
        saveAllItems();
    }

    @FXML
    public void loadSingleToDoListButtonClicked(ActionEvent actionEvent) {
        loadSingleToDoList();
    }

    @FXML
    public void loadMultToDoListButtonClicked(ActionEvent actionEvent) {
        loadMultToDoList();
    }

    public void addToDoList(){
        //add a list of the same string as textDisplay
    }

    public void removeToDoList(){
        //remove a list of the same string as textDisplay
    }

    public void editToDoListTitle(){
        //receive the name of the ToDoList from textDisplay
        //clear the display and prompt the user to enter the new name
        //change String name in List <Object ToDoList>
    }

    public void addItem(){
        //receive name of ToDoList the user would like to edit from textDisplay
        //clear the display and prompt the user to enter the item added
        //clear the display and prompt the user to enter the date (YYYY-MM-DD)
        //clear the display and prompt the user to enter a description
        //add item to ToDoList
    }

    public void removeItem(){
        //receive name of ToDoList the user would like to edit from textDisplay
        //clear the display and prompt the user to enter the item they should remove
        //if the item is in the add item to ToDoList
    }

    public void editItemDescription(){
        //receive name of ToDoList the user would like to edit from textDisplay
        //clear the display and prompt the user to enter the item they should edit
        //clear the display and prompt the user to enter the item description
        //set the item description
    }

    public void editItemDueDate(){
        //receive name of ToDoList the user would like to edit from textDisplay
        //clear the display and prompt the user to enter the item they should edit
        //clear the display and prompt the user to enter the item due date
        //set the item due date
    }
    public void markItemComplete(){
        //receive the name of the ToDoList the user would like to edit from textDisplay
        //clear the display and prompt the user to enter the item they should mark
        //change the boolean complete value in the item list to true
    }

    public void displayAllItems(){
        //display the lists useing nested for loops and string format
        // - take from json
    }

    public void displayIncompletions(){
        // call displayItem
        // if boolean completion is false ... display the item
    }

    public void displayCompletions(){
        // call displayItem
        // if boolean completion is true ... display the item
    }

    public void saveItems(){
        //save changes in a single ToDoList to json
        // - refer to TAs and the internet
    }

    public void saveAllItems(){
        //save changes in all ToDoLists to json
    }

    public void loadSingleToDoList(){
        //consult with office hours
    }
    public void loadMultToDoList(){
        //consult with office hours
    }
}
