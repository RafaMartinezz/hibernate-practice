package modulos;

// Imports from Jakarta Persistence API for Object-Relational Mapping (ORM)
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Departamento class represents the "departamento" entity in the database.
 * This class is mapped to work with Hibernate and the Jakarta Persistence API,
 * enabling instances of this class to be persisted in a database.
 */
@Entity // Indicates that this class is a JPA entity.
@Table(name = "departamento") // Specifies the table in the database that this entity maps to.
public class Departamento {

    @Id // Marks the 'id' field as the primary key for the entity.
    @Column(name = "id") // Maps the 'id' property to the "id" column in the "departamento" table.
    private int id;

    @Column(name = "nombre") // Maps the 'nombre' property to the "nombre" column in the "departamento"
                             // table.
    private String nombre;

    /**
     * No-argument constructor required by JPA.
     */
    public Departamento() {
    }

    /**
     * Constructor that initializes a new Departamento with its name.
     * 
     * @param nombre The name of the department.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    // Getters and setters for the entity's properties.

    /**
     * Gets the department ID.
     * 
     * @return The department's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the department ID.
     * 
     * @param id The department's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the department name.
     * 
     * @return The name of the department.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the department name.
     * 
     * @param nombre The name of the department.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * toString method provides a string representation of the department.
     * 
     * @return A string representing the department.
     */
    @Override
    public String toString() {
        return "Departamento [id=" + id + ", nombre=" + nombre + "]";
    }
}
