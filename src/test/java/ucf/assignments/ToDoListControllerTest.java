package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Christian Klingbiel
 */

import org.junit.jupiter.api.Test;

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
        //hardcode several ToDoLists
        //ensure that the output follows a string format
    }

    @Test
    void displayIncompleteTest(){
        //hardcode several ToDoLists with at least one considered complete and incomplete by boolean complete either...
        //...being true or false respectively
        //assert that the print is only incomplete tasks
    }

    @Test
    void displayCompletionsTest(){
        //hardcode several ToDoLists with at least one considered complete and incomplete by boolean complete either...
        //...being true or false respectively
        //assert that the print is only completed tasks
    }

    @Test
    void saveItemsTest(){
        //consult TAs
    }

    @Test
    void loadListTest(){
        //consult TAs
    }

}
