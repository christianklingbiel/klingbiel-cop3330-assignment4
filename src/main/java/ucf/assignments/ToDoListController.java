package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christian Klingbiel
 */

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
    private TextField textComplete;

    @FXML
    public void addItemButtonClicked() { addItem(); }

    @FXML
    public void removeItemButtonClicked() { removeItem(); }

    @FXML
    public void editDescriptionButtonClicked() {
        editDescription();
    }

    @FXML
    public void editDueDateButtonClicked() {
        editDueDate();
    }

    @FXML
    public void markItemCompleteButtonClicked() {
        markItemComplete();
    }

    @FXML
    public void displayAllItemsButtonClicked() {
        displayAllItems();
    }

    @FXML
    public void displayIncompleteButtonClicked() { displayIncomplete(); }

    @FXML
    public void displayCompletionsButtonClicked() {
        displayCompletions();
    }

    @FXML
    public void saveItemsButtonClicked() { saveItems(); }

    @FXML
    public void loadListButtonClicked() {
        loadList();
    }

    @FXML
    public void clearListButtonClicked(){clearList();}


    public void addItem(){
        //get items from TextField
        getName();
        getDate();
        getDescription();
        getComplete();

        //validate credentials and add item to ToDoList
        if(validateComplete() && validateDate() && validateDesc() && validateName()){
            list.add(t);
            setTextOutput("Added item successfully.");
        }
        else setTextOutput("Make sure everything is correct.");

        //clear texts
        clearText(textName);
        clearText(textDesc);
        clearText(textDate);
        clearText(textComplete);
    }

    public void removeItem(){
        //get item from TextField
        getName();
        getComplete();
        getDate();
        getDescription();

        //remove it
        if(list.contains(t)){
            list.remove(t);
            setTextOutput("Successfully removed item.");
        }
        else setTextOutput("Item wasn't found in system.");

        //clear texts
        clearText(textName);
        clearText(textDesc);
        clearText(textDate);
        clearText(textComplete);
    }
    public void clearList(){
        //for loop that flushes out list
        for (int i = 0;i < list.size();i++){
            list.remove(i);
            i--;
        }
        setTextOutput("Successfully cleared list.");
    }

    public void editDescription(){
        //receive items from user
        getName();
        getDescription();

        //if the list has the task, add new description
        if (validateName() && validateDesc()){
            for (int i = 0;i < list.size();i++){
                if (list.get(i).name.equalsIgnoreCase(t.name)){
                    list.get(i).desc = t.desc;
                    setTextOutput("Successfully changed desc.");
                    break;
                }
                else setTextOutput("Task wasn't found.");
            }
        }
        else  setTextOutput("Make sure the task name is correct.");


        //clear text
        clearText(textName);
        clearText(textDesc);
        clearText(textDate);
        clearText(textComplete);
    }

    public void editDueDate(){
        //get name and date
        getName();
        getDate();

        //if the list has the task, add its due date
        if (validateName() && validateDate()){
            for (int i = 0;i < list.size();i++){
                if (list.get(i).name.equalsIgnoreCase(t.name)){
                    list.get(i).date = t.date;
                    setTextOutput("Successfully changed desc.");
                    break;
                }
                else setTextOutput("Task wasn't found.");
            }
        }
        else  setTextOutput("Make sure the task name is correct.");

        //clear texts
        clearText(textName);
        clearText(textDesc);
        clearText(textDate);
        clearText(textComplete);

    }
    public void markItemComplete(){
        //receive the name of the ToDoList the user would like to edit from textDisplay
        getName();
        getComplete();


        if (validateComplete() && validateName()){
            for (int i = 0;i < list.size();i++) {
                if (t.name.equalsIgnoreCase(list.get(i).name)) {
                    list.get(i).complete = t.complete;
                    setTextOutput("Task has been changed.");
                }
                else setTextOutput("Task wasn't found.");
            }
        }
        else setTextOutput("Make sure the task name is correct.");
    }

    public void displayAllItems(){
        //display the lists using nested for loops and string format
        // - take from json
    }

    public void displayIncomplete(){
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

    public void getDescription(){
        t.desc = getText(textDesc);
    }
    public void getDate(){
        t.date = getText(textDate);
    }
    public void getName(){
        t.name = getText(textName);
    }
    public void getComplete(){
        if (getText(textComplete).equalsIgnoreCase("Complete"))
            t.complete = true;
        else if (getText(textComplete).equalsIgnoreCase("Incomplete"))
            t.complete = false;
        else t.complete = false;
    }
    public boolean validateName(){
        return !getText(textName).equals("");
    }
    public boolean validateDesc(){
        return getText(textDesc).length() > 0 && getText(textDesc).length() < 256;
    }
    public boolean validateDate(){
        String [] stringArray = getText(textDate).split("-");
        ArrayList<Integer> intArray = new ArrayList<>();
        for (int i = 0;i < stringArray.length; i++){
            intArray.add(Integer.parseInt(stringArray[i]));
        }
        if (intArray.size() == 3){
            return intArray.get(0) < 10000 && intArray.get(1) < 13 && intArray.get(2) < 32;
        }
        else return false;
    }
    public boolean validateComplete(){
        return getText(textComplete).equalsIgnoreCase("Complete") ||
                getText(textComplete).equalsIgnoreCase("Incomplete");
    }
}
