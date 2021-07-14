package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christian Klingbiel
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ToDoListController {
    List<ToDoItem> list = new ArrayList<>();

    @FXML
    private TextField textOutput;

    @FXML
    private TextField textDesc;

    @FXML
    private TextField textDate;

    @FXML
    private TextField textComplete;

    @FXML
    private ListView<String> listDisplay;

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
        ToDoItem t = new ToDoItem();

        //get items from TextField
        getDate(t);
        getDesc(t);
        getComplete(t);

        //validate credentials and add item to ToDoList
        if(validateComplete() && validateDate() && validateDesc()){
            list.add(t);
            setTextOutput("Added item successfully.");
        }
        else setTextOutput("Make sure everything is correct.");

        //display list
        displayList();

        //clear texts
        clearText(textDesc);
        clearText(textDate);
        clearText(textComplete);
    }

    public void removeItem(){
        ToDoItem t = new ToDoItem();

        //get item from TextField
        getDesc(t);
        getComplete(t);
        getDate(t);

        //remove it
        for(int i = 0;i < list.size();i++) {
            if (list.get(i).desc.equalsIgnoreCase(t.desc)) {
                list.remove(t);
                setTextOutput("Successfully removed item.");
                i--;
            }
            else setTextOutput("Item wasn't found in system.");
        }

        displayList();

        //clear texts
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

        displayList();
    }

    public void editDescription(){
        ToDoItem t = new ToDoItem();
        //receive items from user
        getDesc(t);
        getDate(t);
        getComplete(t);

        //if the list has the task, add new description
        if (validateDesc() && validateDate() && validateComplete()){
            for (int i = 0;i < list.size();i++){
                if (list.get(i).date.equalsIgnoreCase(t.date) && list.get(i).complete == t.complete){
                    list.get(i).desc = t.desc;
                    setTextOutput("Successfully changed desc.");
                    break;
                }
                else setTextOutput("Task wasn't found.");
            }
        }
        else  setTextOutput("Make sure date and status are correct.");

        displayList();


        //clear text
        clearText(textDesc);
        clearText(textDate);
        clearText(textComplete);
    }

    public void editDueDate(){
        ToDoItem t = new ToDoItem();
        //get name and date
        getDesc(t);
        getDate(t);
        getComplete(t);

        //if the list has the task, add its due date
        if (validateDesc() && validateDate() && validateComplete()){
            for (int i = 0;i < list.size();i++){
                if (list.get(i).desc.equalsIgnoreCase(t.desc) && list.get(i).complete == t.complete){
                    list.get(i).date = t.date;
                    setTextOutput("Successfully changed date.");
                    break;
                }
                else setTextOutput("Task wasn't found.");
            }
        }
        else  setTextOutput("Make sure desc. and status are correct.");

        displayList();

        //clear texts
        clearText(textDesc);
        clearText(textDate);
        clearText(textComplete);

    }
    public void markItemComplete(){
        ToDoItem t = new ToDoItem();

        //receive the name of the ToDoList the user would like to edit from textDisplay
        getDesc(t);
        getDate(t);
        getComplete(t);


        if (validateComplete() && validateDesc() && validateDate()){
            for (int i = 0;i < list.size();i++) {
                if (t.desc.equalsIgnoreCase(list.get(i).desc) && t.date.equalsIgnoreCase(list.get(i).date)) {
                    list.get(i).complete = t.complete;
                    setTextOutput("Successfully changed status.");
                }
                else setTextOutput("Task wasn't found.");
            }
        }
        else setTextOutput("Make sure date and desc. are correct.");

        displayList();

        //clear texts
        clearText(textComplete);
        clearText(textDate);
        clearText(textDesc);
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

    public void getDesc(ToDoItem t){
        t.desc = getText(textDesc);
    }
    public void getDate(ToDoItem t) {
        t.date = getText(textDate);
    }
    public void getComplete(ToDoItem t){
        if (getText(textComplete).equalsIgnoreCase("Complete"))
            t.complete = true;
        else if (getText(textComplete).equalsIgnoreCase("Incomplete"))
            t.complete = false;
        else t.complete = false;
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
    public String listToString(int i){
        if (list.get(i).complete){
            return String.format("%s\t%s\tComplete",list.get(i).desc,list.get(i).date);
        }
        else return String.format("%s\t%s\tIncomplete",list.get(i).desc,list.get(i).date);
    }
    public void displayList(){
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(int i = 0;i < list.size();i++){
            observableList.add(listToString(i));
        }
        listDisplay.setItems(observableList);
    }
}
