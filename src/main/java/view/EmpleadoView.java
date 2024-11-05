package view;

// Importing EmpleadoController for managing CRUD operations on Empleado entity
import Controllers.EmpleadoController;

/**
 * EmpleadoView class serves as an entry point for demonstrating CRUD operations
 * on the Empleado entity using EmpleadoController.
 */
public class EmpleadoView {
    /**
     * Main entry point of the application that demonstrates how to interact
     * with the EmpleadoController to perform various operations.
     * 
     * @param args Command-line arguments (not used here).
     */
    public static void main(String[] args) {
        // Creates an employee using EmpleadoController.
        // This example specifically creates a new employee named "Manuel" with a salary
        // of 2500.00.
        String creationResult = new EmpleadoController().createEmpleado(0, 0, "Manuel", 2500.00);
        System.out.println(creationResult);

        // The following lines are commented out to prevent multiple operations from
        // executing simultaneously.
        // Uncomment each line to test individual operations.

        // Deletes an employee by their ID using EmpleadoController.
        // String deletionResult = new EmpleadoController().deleteEmpleado(2);
        // System.out.println(deletionResult);

        // Updates the name of an existing employee by their ID using
        // EmpleadoController.
        // String updateResult = new EmpleadoController().updateEmpleado(1, "Raul");
        // System.out.println(updateResult);

        // Retrieves the string representation of an employee by their ID using
        // EmpleadoController.
        // String employeeDetails = new EmpleadoController().getEmpleado(1);
        // System.out.println(employeeDetails);
    }
}
