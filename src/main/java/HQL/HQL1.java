package HQL;

// Required imports for working with Hibernate and entities
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import modulos.Departamento;
import modulos.Empleado;

/**
 * The HQL1 class demonstrates basic usage of Hibernate Query Language (HQL)
 * to perform simple queries and retrieve complete entities.
 */
public class HQL1 {
    /**
     * The main method that runs the application.
     * 
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Configures and initializes the SessionFactory from the Hibernate
        // configuration file
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Empleado.class); // Register Empleado entity
        configuration.addAnnotatedClass(Departamento.class); // Register Departamento entity
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a Hibernate session
        Session session = sessionFactory.openSession();

        try {
            // Begin a transaction for the first query
            session.beginTransaction();

            // Create and execute the HQL query to retrieve all departments
            String hql = "from Departamento";
            Query<Departamento> query = session.createQuery(hql, Departamento.class);
            List<Departamento> departamentos = query.getResultList();

            // Iterate and display the department results
            for (Departamento departamento : departamentos) {
                System.out.println(departamento);
            }

            // Commit the transaction for the first query
            session.getTransaction().commit();

            // Begin a new transaction for the second query
            session.beginTransaction();

            // Create and execute the second HQL query to retrieve all employees
            String hql2 = "from Empleado";
            Query<Empleado> query2 = session.createQuery(hql2, Empleado.class);
            List<Empleado> empleados = query2.getResultList();

            // Iterate and display the employee results
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }

            // Commit the transaction for the second query
            session.getTransaction().commit();

        } catch (Exception e) {
            // If there is an error, rollback the current transaction
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
