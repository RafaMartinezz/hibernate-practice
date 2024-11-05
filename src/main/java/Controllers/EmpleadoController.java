package Controllers;

// Hibernate imports
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
// Import the Empleado entity
import modulos.Empleado;

/**
 * Controller for managing CRUD operations for the Empleado entity.
 */
public class EmpleadoController {

    /**
     * Creates a new employee in the database.
     *
     * @param departamento The department ID to which the employee belongs.
     * @param id           The unique ID of the employee.
     * @param nombre       The name of the employee.
     * @param sueldo       The salary of the employee.
     * @return A message indicating the result of the operation.
     */
    public String createEmpleado(int departamento, int id, String nombre, double sueldo) {
        // Configuring the SessionFactory and opening a session
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empleado.class) // Register Empleado as an entity
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            // Create an instance of Empleado with the provided information
            Empleado empleado1 = new Empleado(departamento, id, nombre, sueldo);

            // Begin transaction, save the employee, and commit changes
            session.beginTransaction();
            session.save(empleado1);
            session.getTransaction().commit();

            // Return success message if no exceptions occur
            return "Empleado creado con exito";
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace if an exception occurs
        } finally {
            // Ensure the session is closed to release resources
            if (session.isOpen()) {
                session.close();
            }
            sessionFactory.close(); // Close the SessionFactory
        }

        return "Ha habido un error al crear el empleado";
    }

    /**
     * Deletes an existing employee from the database by ID.
     *
     * @param id The ID of the employee to delete.
     * @return A message indicating the result of the operation.
     */
    public String deleteEmpleado(int id) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empleado.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            // Retrieve the employee by ID and delete it
            Empleado empleado1 = session.get(Empleado.class, id);
            session.beginTransaction();
            session.delete(empleado1);
            session.getTransaction().commit();

            // Return success message if deletion is successful
            return "Empleado eliminado con exito";
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace if an exception occurs
        } finally {
            // Ensure session and factory are closed
            if (session.isOpen()) {
                session.close();
            }
            sessionFactory.close();
        }

        return "Ha habido un error al eliminar el empleado";
    }

    /**
     * Updates the name of an existing employee in the database.
     *
     * @param id     The ID of the employee to update.
     * @param nombre The new name of the employee.
     * @return A message indicating the result of the operation.
     */
    public String updateEmpleado(int id, String nombre) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empleado.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            // Retrieve the employee by ID and update its name
            Empleado empleado1 = session.get(Empleado.class, id);
            empleado1.setNombre(nombre);

            session.beginTransaction();
            session.update(empleado1);
            session.getTransaction().commit();

            // Return success message if update is successful
            return "Empleado actualizado con exito";
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace if an exception occurs
        } finally {
            // Ensure session and factory are closed
            if (session.isOpen()) {
                session.close();
            }
            sessionFactory.close();
        }

        return "Ha habido un error al actualizar el empleado";
    }

    /**
     * Retrieves an employee by ID and returns its string representation.
     *
     * @param id The ID of the employee to retrieve.
     * @return The string representation of the employee or an error message if not
     *         found.
     */
    public String getEmpleado(int id) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empleado.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            // Retrieve the employee by ID
            session.beginTransaction();
            Empleado empleado1 = session.get(Empleado.class, id);
            session.getTransaction().commit();

            // Return the employee's details as a string if found
            return empleado1.toString();
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace if an exception occurs
        } finally {
            // Ensure session and factory are closed
            if (session.isOpen()) {
                session.close();
            }
            sessionFactory.close();
        }

        return "El empleado no existe";
    }
}
