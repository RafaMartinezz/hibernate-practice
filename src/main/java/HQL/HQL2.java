package HQL;

// Necessary imports from Hibernate and Java
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import modulos.Departamento;
import modulos.Empleado;

/**
 * HQL2 class demonstrates the use of HQL (Hibernate Query Language)
 * to perform a CROSS JOIN operation between two entities: Empleado and
 * Departamento.
 */
public class HQL2 {
    /**
     * Main method that executes the application.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Configure and initialize the SessionFactory from the Hibernate configuration
        // file
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Empleado.class); // Register Empleado entity
        configuration.addAnnotatedClass(Departamento.class); // Register Departamento entity
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a Hibernate session
        Session session = sessionFactory.openSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Define the HQL query to perform a CROSS JOIN between Empleado and
            // Departamento
            // Note: A CROSS JOIN creates a Cartesian product between the two tables, which
            // can be resource-intensive
            // and may not be desirable without a specific join condition.
            String hql = "SELECT e.id, e.nombre, e.sueldo, d.nombre FROM Empleado e CROSS JOIN Departamento d";
            Query<Object[]> query = session.createQuery(hql, Object[].class);

            // Execute the query and retrieve the results as a list of Object arrays
            List<Object[]> filas = query.getResultList();

            // Iterate over the results and output them to the console
            for (Object[] fila : filas) {
                System.out.println("ID: " + fila[0] + ", Nombre: " + fila[1] + ", Sueldo: " + fila[2]
                        + ", Departamento: " + fila[3]);
            }

        } catch (Exception e) {
            // If there is an error, roll back the transaction
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace(); // Print the error stack trace
        } finally {
            // Close the session after completing the process
            session.close();
        }

        // Close the SessionFactory
        sessionFactory.close();
    }
}
