package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ToDoListController {
    @FXML
    private TextField resultDisplay;

    @FXML
    public void addToDoListButtonClicked(ActionEvent actionEvent) {
        //click the Add ToDoList button
        //prompt text file
        //get the name of the ToDoList the user would like to add
        //add to the list

        addToDoList();
    }

    @FXML
    public void removeToDoListButtonClicked(ActionEvent actionEvent) {
        //click the Remove ToDoList button
        //prompt text file
        //get the name of the ToDoList the user would like to remove
        //remove from the list
    }

    @FXML
    public void editToDoListTitleButtonClicked(ActionEvent actionEvent) {
        //click the Edit ToDoList Title button
        //prompt text file that displays the ToDoLists and their corresponding number in the list
        //get the corresponding number to the ToDoList title the user would like to change
        //get the new ToDoList title
        //change the ToDoList title
    }

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        //click the Add Item To ToDoList button
        //prompt text file that displays the ToDoLists and their corresponding number in the list
        //get the corresponding number to the ToDoList the user would like to see
        //get the item the user wishes to add
        //add item to ToDoList
    }

    @FXML
    public void removeItemButtonClicked(ActionEvent actionEvent) {
        //click the Remove Item From ToDoList button
        //prompt text file that displays the ToDoLists and their corresponding number in the list
        //get the corresponding number to the ToDoList the user would like to see
        //get the item the user wishes to remove
        //remove item from ToDoList
    }

    @FXML
    public void editItemDescriptionButtonClicked(ActionEvent actionEvent) {
        //click the Edit Item Description button
        //prompt text file that displays the ToDoLists and their corresponding number in the list
        //get the corresponding number to the ToDoList the user would like to see
        //get the item the user wishes to change the description of
        //get the new description
        //change the item description
    }

    @FXML
    public void editItemDueDateButtonClicked(ActionEvent actionEvent) {
        //click the Edit Item Due Date button
        //prompt text file that displays the ToDoLists and their corresponding number in the list
        //get the corresponding number to the ToDoList the user would like to see
        //get the item the user wishes to change the due date of
        //get the new due date
        //change the item due date
    }

    @FXML
    public void markItemCompleteButtonClicked(ActionEvent actionEvent) {
        //click the Mark Item As Complete button
        //prompt text file that displays the ToDoLists and their corresponding number in the list
        //get the corresponding number to the ToDoList the user would like to see
        //get the item the user wishes to mark complete
        //mark the item as complete
        // - use a boolean complete value in the item
    }

    @FXML
    public void displayAllItemsButtonClicked(ActionEvent actionEvent) {
        //click the Display All Items button
        //create a text file that displays each ToDoList and their corresponding items, due dates, whether or not they're complete, and their description
    }

    @FXML
    public void displayIncompletionsButtonClicked(ActionEvent actionEvent) {
        //click the Display Incompletions button
        //create a new list for each ToDoList that only displays their incompletions
        //create a text file that displays all incompleted items in each ToDoList
    }

    @FXML
    public void displayCompletionsButtonClicked(ActionEvent actionEvent) {
        //click the Display Completions button
        //create a new list for each ToDoList that only displays their completions
        //create a text file that displays all completed items in each ToDoList
    }

    @FXML
    public void saveItemsButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void saveAllItemsButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void loadSingleToDoListButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void loadMultToDoListButtonClicked(ActionEvent actionEvent) {
    }

    public void addToDoList(){
        resultDisplay.setText("");
    }
}
