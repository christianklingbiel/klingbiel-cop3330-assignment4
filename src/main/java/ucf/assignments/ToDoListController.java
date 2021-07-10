package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christian Klingbiel
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ToDoListController {

    ToDoItem t = new ToDoItem();
    List<ToDoItem> list = new ArrayList<>();

    @FXML
    private TextField textOutput;

    @FXML
    private TextField textName;

    @FXML
    private TextField textDesc;

    @FXML
    private TextField textDate;

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        addItem();
    }

    @FXML
    public void removeItemButtonClicked(ActionEvent actionEvent) {
        removeItem();
    }

    @FXML
    public void editDescriptionButtonClicked(ActionEvent actionEvent) {
        editDescription();
    }

    @FXML
    public void editDueDateButtonClicked(ActionEvent actionEvent) {
        editDueDate();
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
    public void loadListButtonClicked(ActionEvent actionEvent) {
        loadList();
    }

    public void addItem(){
        //get items from TextField
        t.name = getText(textName);
        t.date = getText(textDesc);
        t.desc = getText(textDate);

        t.complete = false;

        //add item to ToDoList
        if(!t.name.isEmpty()){
            list.add(t);
            if(list.contains(t))
                setTextOutput("Task added successfully.");
            else setTextOutput("Couldn't add task.");
        }
        else setTextOutput("Enter a task name.");
        clearText(textName);
        clearText(textDesc);
        clearText(textDate);
    }

    public void removeItem(){
        //get item from TextField
        t.name = getText(textName);

        //if the item is in the list, remove it
        for(int i = 0;i < list.size();i++){
            if (t.name.equalsIgnoreCase(list.get(i).name)){
                list.remove(t);
                i--;
                setTextOutput(getText(textName) + " removed successfully.");
            }
            else if (!(t.name.equalsIgnoreCase(list.get(i).name)))
                setTextOutput(getText(textName) + " wasn't found in the list.");
        }

        clearText(textName);
        clearText(textDesc);
        clearText(textDate);
    }

    public void editDescription(){
        //receive items from user
        t.name = getText(textName);
        t.desc = getText(textDesc);

        //test whether inputs are correct
        if (t.name.isEmpty() || t.desc.isEmpty())
            setTextOutput("Enter name and new desc.");

        else{
            //test whether the task is in the list and change its description
            for (ToDoItem toDoItem : list) {
                if (toDoItem.name.equalsIgnoreCase(t.name)) {
                    toDoItem.desc = t.desc;
                    setTextOutput("Description was changed.");
                } else setTextOutput("Couldn't find task.");
            }
        }


        clearText(textName);
        clearText(textDesc);
    }

    public void editDueDate(){
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

    public void loadList(){
        //consult with office hours
    }
    public String getText(TextField t){
        return t.getText();
    }
    public void setTextOutput(String text){
        textOutput.setText(text);
    }
    public void clearText(TextField t){
        t.setText("");
    }
}
