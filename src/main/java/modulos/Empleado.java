package modulos;

// Imports from Jakarta Persistence API for mapping annotations
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Empleado class represents the "empleado" entity in the database.
 * This class is designed to work with Hibernate and the Jakarta Persistence
 * API,
 * enabling instances of this class to be persisted in the database.
 */
@Entity // Indicates that this class is a JPA entity.
@Table(name = "empleado") // Specifies the table in the database associated with this entity.
public class Empleado {

    @Column(name = "departamento") // Maps the 'departamento' property to the "departamento" column.
    private int departamento;

    @Id // Marks the 'id' field as the primary key for the entity.
    @Column(name = "id") // Maps the 'id' property to the "id" column in the "empleado" table.
    private int id;

    @Column(name = "nombre") // Maps the 'nombre' property to the "nombre" column.
    private String nombre;

    @Column(name = "sueldo") // Maps the 'sueldo' property to the "sueldo" column.
    private double sueldo;

    /**
     * No-argument constructor required by JPA.
     */
    public Empleado() {
    }

    /**
     * Constructor that initializes a new Empleado with the provided values.
     * 
     * @param departamento The department ID to which the employee belongs.
     * @param id           The unique ID of the employee.
     * @param nombre       The name of the employee.
     * @param sueldo       The salary of the employee.
     */
    public Empleado(int departamento, int id, String nombre, double sueldo) {
        this.departamento = departamento;
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    // Getters and setters for accessing and modifying entity properties.

    /**
     * Gets the department ID associated with the employee.
     * 
     * @return The department ID.
     */
    public int getDepartamento() {
        return departamento;
    }

    /**
     * Sets the department ID associated with the employee.
     * 
     * @param departamento The department ID.
     */
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    /**
     * Gets the employee's unique ID.
     * 
     * @return The employee's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the employee's unique ID.
     * 
     * @param id The employee's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the employee's name.
     * 
     * @return The name of the employee.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the employee's name.
     * 
     * @param nombre The name of the employee.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the employee's salary.
     * 
     * @return The salary of the employee.
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Sets the employee's salary.
     * 
     * @param sueldo The salary of the employee.
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Provides a string representation of an employee.
     * 
     * @return A string representing the employee, including their department, ID,
     *         name, and salary.
     */
    @Override
    public String toString() {
        return "Empleado [departamento=" + departamento + ", id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo
                + "]";
    }
}
