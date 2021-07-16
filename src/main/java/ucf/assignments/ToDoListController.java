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
    public List<ToDoItem> list = new ArrayList<>();
    List<ToDoItem> savedList = new ArrayList<>();

    @FXML
    public TextField textOutput;

    @FXML
    public TextField textDesc;

    @FXML
    public TextField textDate;

    @FXML
    public TextField textComplete;

    @FXML
    public ListView<String> listDisplay;


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
        displayList(list);

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

        for (int  i = 0;i < list.size();i++){
            if (list.get(i).desc.equals(t.desc)){
                list.remove(t);
                setTextOutput("Removed item successfully.");
            }
            else setTextOutput("Item not found in list.");
        }

        displayList(list);

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

        displayList(list);
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

        displayList(list);


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

        displayList(list);

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

        displayList(list);

        //clear texts
        clearText(textComplete);
        clearText(textDate);
        clearText(textDesc);
    }

    public void displayAllItems(){
        //call displayList
        displayList(list);
        setTextOutput("Displaying all items.");
    }

    public void displayIncomplete(){

        //make new list
        List <ToDoItem> listIncomplete = new ArrayList<>();

        //if item status is incomplete, add all items to new list
        for (int i = 0;i < list.size();i++){
            if (!list.get(i).complete){
                listIncomplete.add(list.get(i));
            }
        }

        //display new list
        displayList(listIncomplete);

        setTextOutput("Displaying incomplete items.");
    }

    public void displayCompletions(){

        //make new list
        List <ToDoItem> listComplete = new ArrayList<>();

        //if item status is incomplete, add all items to new list
        for (int i = 0;i < list.size();i++){
            if (list.get(i).complete){
                listComplete.add(list.get(i));
            }
        }

        //display new list
        displayList(listComplete);

        setTextOutput("Displaying complete items.");
    }

    public void saveItems(){
        //saves items into another  list
        savedList = list;
        setTextOutput("List saved successfully.");
    }

    public void loadList(){
        //loads saved list
        list.addAll(savedList);
        displayList(list);
    }

    public String getText(TextField t){
        //return the text from a TextField
        return t.getText();
    }

    public void setTextOutput(String text){
        //sets the text of textOutput to the parameter
        textOutput.setText(text);
    }

    public void clearText(TextField t){
        //sets the text of the TextField in the parameter blank
        t.setText("");
    }

    public void getDesc(ToDoItem t){
        //gets data from textDesc and sets it to t
        t.desc = getText(textDesc);
    }

    public void getDate(ToDoItem t) {
        //gets data from textDate and sets it to t
        t.date = getText(textDate);
    }

    public void getComplete(ToDoItem t){
        //gets data from textComplete and determines whether the boolean is true or false
        if (getText(textComplete).equalsIgnoreCase("Complete"))
            t.complete = true;
        else if (getText(textComplete).equalsIgnoreCase("Incomplete"))
            t.complete = false;
        else t.complete = false;
    }

    public boolean validateDesc(){
        //assures that the description is less than 256 characters
        return getText(textDesc).length() > 0 && getText(textDesc).length() < 256;
    }

    public boolean validateDate(){
        //create a string array that splits textDate by -'s
        String [] stringArray = getText(textDate).split("-");

        //create integer array and parseInt each element
        ArrayList<Integer> intArray = new ArrayList<>();
        for (int i = 0;i < stringArray.length; i++){
            intArray.add(Integer.parseInt(stringArray[i]));
        }

        //assure that the date is valid by Gregorian standards
        if (intArray.size() == 3){
            return intArray.get(0) < 10000 && intArray.get(1) < 13 && intArray.get(2) < 32;
        }
        else return false;
    }

    public boolean validateComplete(){
        //returns true if textComplete is "complete"
        return getText(textComplete).equalsIgnoreCase("Complete") ||
                getText(textComplete).equalsIgnoreCase("Incomplete");
    }

    public String listToString(int i){
        //determines the output of a toDoItem on a list by its status
        if (list.get(i).complete){
            return String.format("%s\t%s\tComplete",list.get(i).desc,list.get(i).date);
        }
        else return String.format("%s\t%s\tIncomplete",list.get(i).desc,list.get(i).date);
    }

    public void displayList(List<ToDoItem> list){
        //create observableList
        ObservableList<String> observableList = FXCollections.observableArrayList();

        //add each element in list to observableList
        for(int i = 0;i < list.size();i++){
            observableList.add(listToString(i));
        }

        //displays the list on listDisplay
        listDisplay.setItems(observableList);
    }
}
