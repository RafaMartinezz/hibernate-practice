package Controllers;

// Necessary imports for Hibernate
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
// Import the Departamento entity
import modulos.Departamento;

/**
 * Controller for managing the Departamento entity in the database.
 */
public class DepartamentoController {

    /**
     * Creates a new department in the database.
     *
     * @param nombre The name of the department to create.
     * @return A message indicating the result of the operation.
     */
    public String createDepartamento(String nombre) {
        // Create a SessionFactory based on the Hibernate configuration file
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // Load the Hibernate configuration file
                .addAnnotatedClass(Departamento.class) // Register the Departamento class as an entity
                .buildSessionFactory();

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        try {
            // Create a new Departamento instance with the provided name
            Departamento departamento1 = new Departamento(nombre);

            // Begin a new transaction for this session
            session.beginTransaction();

            // Save the Departamento object to the database
            session.save(departamento1);

            // Commit the transaction to persist changes
            session.getTransaction().commit();

            // Close the SessionFactory after use
            sessionFactory.close();

            // Return a success message if all operations complete successfully
            return "Departamento creado";

        } catch (Exception e) {
            // Print the stack trace if an exception occurs during the transaction
            e.printStackTrace();
        } finally {
            // Ensure the session is closed if an error occurs
            if (session.isOpen()) {
                session.close();
            }
        }

        // Return an error message if an exception was caught
        return "Error al registrar departamento";
    }
}
