package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christian Klingbiel
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListControllerTest extends ToDoListController{

    @Test
    void addItemTest(){
        //set texts to valid credentials
        textDesc.setText("Laundry");
        textDate.setText("2021-07-10");
        textComplete.setText("Complete");

        //call method
        addItem();

        //assert that the texts in the same if statement as the added list is the same as the one provided
        assertEquals("Added item successfully.", getText(textOutput));
    }

    @Test
    void removeItemTest(){
        //hard code a ToDoList with an item
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2021-07-10";
        t.complete = true;
        list.add(t);

        //texts also have same item
        textDesc.setText("Laundry");
        textDate.setText("2021-07-10");
        textComplete.setText("Complete");

        //call removeItem() and remove the same item
        removeItem();

        //assert that the ToDoList is blank
        assertFalse(list.contains(t));
    }

    @Test
    void editDescriptionTest(){
        //add item to list
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2021-07-10";
        t.complete = true;
        list.add(t);

        //set text to new description
        textDesc.setText("Wash clothes ONLY");
        textDate.setText("2021-07-10");
        textComplete.setText("Complete");

        //call editDescription
        editDescription();

        //assert description changed
        assertEquals("Successfully changed desc.", getText(textOutput));
    }

    @Test
    void editDueDateTest(){
        //add item to list
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2021-07-10";
        t.complete = true;
        list.add(t);

        //set text to new description
        textDesc.setText("Laundry");
        textDate.setText("2021-07-11");
        textComplete.setText("Complete");

        //call editDueDate
        editDueDate();

        //assert description changed
        assertEquals("Successfully changed date.", getText(textOutput));
    }


    @Test
    void markItemCompleteTest(){
        //add item to list
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2021-07-10";
        t.complete = true;
        list.add(t);

        //set text to new description
        textDesc.setText("Wash clothes ONLY");
        textDate.setText("2021-07-10");
        textComplete.setText("Incomplete");

        //call markItems
        markItemComplete();

        //assert description changed
        assertEquals("Successfully changed status.", getText(textOutput));
    }


    @Test
    void displayAllItemsTest(){
        //add item to list
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2021-07-10";
        t.complete = true;
        list.add(t);

        //call displayItems()
        displayAllItems();

        //create observable list and assign list to it
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(int i = 0;i < list.size();i++)
            observableList.add(listToString(i));

        //assert that listDisplay has the list
        assertEquals(listDisplay.getItems(),observableList);
    }

    @Test
    void displayIncompleteTest(){
        //add item to list
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2021-07-10";
        t.complete = false;
        list.add(t);

        //call displayIncomplete()
        displayIncomplete();

        //create observable list and assign list to it
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(int i = 0;i < list.size();i++){
            if (list.get(i).complete = false){
                observableList.add(listToString(i));
            }
        }

        //assert that listDisplay has the list
        assertEquals(listDisplay.getItems(),observableList);
    }

    @Test
    void displayCompletionsTest(){
        //add item to list
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2021-07-10";
        t.complete = true;
        list.add(t);

        //call displayCompletions
        displayCompletions();

        //create observable list and assign list to it
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(int i = 0;i < list.size();i++){
            if (list.get(i).complete = true){
                observableList.add(listToString(i));
            }
        }

        //assert that listDisplay has the list
        assertEquals(listDisplay.getItems(),observableList);
    }

    @Test
    void saveItemsTest(){
        //add item to list
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2020-07-10";
        t.complete = true;
        list.add(t);

        //call saveItems()
        saveItems();

        //assert that savedList contains list
        assertEquals(list, savedList);
    }

    @Test
    void loadListTest(){
        //add item to list
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2020-07-10";
        t.complete = true;
        list.add(t);

        //call saveItems()
        saveItems();

        //call loadList()
        loadList();
    }

    @Test
    void getTextTest(){
        //make and assign new TextField
        TextField t = new TextField();
        t.setText("Go Knights");

        //initialize a string to the called method
        String test = getText(t);

        //assert that the string and the TextField text are equal
        assertEquals(test, t.getText());
    }

    @Test
    void setTextOutputTest(){
        //create string and call method
        String test = "Go Knights";
        setTextOutput(test);

        //assert that textOutput displays the string
        assertEquals(getText(textOutput), test);
    }

    @Test
    void clearTextTest(){
        //create TextField and assign text
        TextField t = new TextField();
        t.setText("Go Knights");

        //call clearText
        clearText(t);

        //assert that the TextField cleared
        assertEquals(t.getText(),"");
    }

    @Test
    void getDescTest(){
        //create item and add to list
        ToDoItem t = new ToDoItem();
        textDesc.setText("Go Knights");

        //call method
        getDesc(t);

        //assert that the description of t equals textDesc
        assertEquals(t.desc,textDesc.getText());
    }

    @Test
    void getDateTest(){
        //create item and add to list
        ToDoItem t = new ToDoItem();
        textDate.setText("2012-12-24");

        //call method
        getDate(t);

        //assert that the date of t equals textDate
        assertEquals(t.date,textDate.getText());
    }

    @Test
    void getCompleteTest(){
        //create item and add to list
        ToDoItem t = new ToDoItem();
        textComplete.setText("Complete");

        //call method
        getComplete(t);

        //assert that the description of t equals textDesc
        assertTrue(t.complete);
    }

    @Test
    void validateDescTest(){
        //set textDesc to a description shorter than 256 characters
        textDesc.setText("supercalifragilisticexpialidocious");

        //assertTrue if validateDesc is true
        assertTrue(validateDesc());
    }

    @Test
    void validateDateTest(){
        //set textDate to a date formatted by YYYY-MM-DD
        textDate.setText("1999-12-31");

        //assertTrue if validateDate is true
        assertTrue(validateDate());
    }

    @Test
    void validateCompleteTest(){
        //set textComplete to Complete or Incomplete
        textComplete.setText("Incomplete");

        //assert that validateComplete works
        assertTrue(validateComplete());
    }

    @Test
    void listDisplayTest(){
        //add item to a list
        ToDoItem t = new ToDoItem();
        t.desc = "Laundry";
        t.date = "2021-07-10";
        t.complete = true;
        List<ToDoItem> list1 = new ArrayList<>();
        list1.add(t);

        //call displayList(list1)
        displayList(list1);

        //create observableList
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("Laundry\t2021-07-10\tComplete");

        //assert that listDisplay has observableList
        assertEquals(listDisplay.getItems(),observableList);
    }
}
