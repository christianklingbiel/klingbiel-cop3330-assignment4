package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christian Klingbiel
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListControllerTest {

    @Test
    void addToDoList() {
        //make a new to do list controller
        //initialize addToDoListButtonClicked to some non-blank value
        //call the addToDoList function
        //get the value resultDisplay
        //assert that the new ToDoList was added to the list of ToDoList
    }

    @Test
    void removeToDoList(){
        //make a new to do list controller
        //initialize removeToDoListButtonClicked to some non-blank value
        //call the removeToDoList function
        //get the value resultDisplay
        //assert that the new ToDoList was removed to the list of ToDoList
    }

    @Test
    void editToDoListTitle(){
        //make a new to do list controller
        //initialize editToDoListTitleButtonClicked
        //call the editToDoListTitle function
        //get the value resultDisplay
        //assert that the new ToDoList title equals the resultDisplay value
    }

    @Test
    void addItem(){
        //make a new ToDoList using addToDoList()
        //call addItem()
        //assert the ToDoList has the same item as textDisplay
    }

    @Test
    void removeItem(){
        //hard code a ToDoList with an item
        //call removeItem() and remove the same item
        //assert that the ToDoList is blank
    }

    @Test
    void editItemDescription(){
        //hard code a ToDoList with an item and description
        //call editItemDescription() and enter the new description
        //assert that the item description is equal to textDisplay
    }

    @Test
    void editItemDueDate(){
        //hard code a ToDoList with an item and due date
        //call editItemDueDate() and enter the new due date
        //assert that the item due date is equal to textDisplay
    }

    @Test
    void markItemComplete(){
        //hard code a ToDoList with an item that has boolean complete false
        //call markItemComplete() and enter the ToDoList and item
        //assert that the boolean value is true
    }

    @Test
    void displayAllItems(){
        //hardcode several ToDoLists
        //ensure that the output follows a string format
    }

    @Test
    void displayIncompletions(){
        //hardcode several ToDoLists with at least one considered complete and incomplete by boolean complete either...
        //...being true or false respectively
        //assert that the print is only incomplete tasks
    }

    @Test
    void displayCompletions(){
        //hardcode several ToDoLists with at least one considered complete and incomplete by boolean complete either...
        //...being true or false respectively
        //assert that the print is only completed tasks
    }

    @Test
    void saveItems(){
        //consult TAs
    }

    @Test
    void saveAllItems(){
        //consult TAs
    }

    @Test
    void loadSingleToDoList(){
        //consult TAs
    }

    @Test
    void loadMultToDoList(){
        //consult TAs
    }

}
