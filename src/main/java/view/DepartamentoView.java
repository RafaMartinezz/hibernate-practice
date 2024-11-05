package view;

// Importing the DepartamentoController to manage department creation
import Controllers.DepartamentoController;

/**
 * DepartamentoView class that serves as the view in an MVC application.
 * This class contains the main method to execute the application and
 * demonstrate
 * creating a department using the DepartamentoController.
 */
public class DepartamentoView {
    /**
     * Main entry point of the application.
     * 
     * @param args Command-line arguments (not used here).
     */
    public static void main(String[] args) {
        // Creates a new department named "Tecnologia aplicada"
        // by utilizing the DepartamentoController.
        String departmentCreationResult = new DepartamentoController().createDepartamento("Tecnologia aplicada");

        // Prints the result of the department creation operation,
        // which may be a success or error message.
        System.out.println(departmentCreationResult);
    }
}
