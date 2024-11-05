# Employee and department management system using Hibernate ORM

This project implements a simple **Employee and Department Management System** using **Hibernate ORM** to perform basic CRUD (Create, Read, Update, Delete) operations on a MySQL database. The project showcases key aspects of using Hibernate, including entity mappings, session management, and HQL (Hibernate Query Language) for complex queries.

## Project Overview

The system is organized into the following main packages:

- **Controllers**: Contains classes that handle CRUD operations for `Empleado` (Employee) and `Departamento` (Department).
- **modulos**: Defines entity classes (`Empleado` and `Departamento`) that are mapped to the database tables.
- **view**: Provides classes that serve as the entry point for executing and demonstrating CRUD operations via the controllers.
- **HQL**: Demonstrates the use of HQL for running cross-join queries and retrieving data from the `Empleado` and `Departamento` tables.

## Key Components

### Controllers
The controller classes are responsible for managing CRUD operations and interact directly with the Hibernate sessions to handle the persistence layer:

1. **`DepartamentoController`**:
   - Manages the `Departamento` entity.
   - Includes a method to create new department records in the database.

2. **`EmpleadoController`**:
   - Manages the `Empleado` entity.
   - Includes methods for creating, updating, deleting, and retrieving employee records.

### HQL Demonstration Classes
The classes in the **HQL** package demonstrate complex data retrieval using HQL:

- **`HQL1`**: Fetches all departments and employees from the database.
- **`HQL2`**: Shows how to perform a cross join using HQL to display employees and departments in a combined manner.

### Entity Classes
The **modulos** package defines the entity classes:

- **`Empleado`** and **`Departamento`**:
  - Annotated with Hibernate and Jakarta Persistence API annotations to map the fields to database columns.
  - Include constructors, getters, setters, and `toString()` methods for clear representation.

### Hibernate Configuration
The Hibernate configuration file (`hibernate.cfg.xml`) specifies the database connection details and basic Hibernate settings. It is located at the root level of the project structure and includes:

- Database driver and connection URL for MySQL.
- User credentials for connecting to the `Hibernate1` database on `localhost`.
- `hibernate.show_sql` set to `true` to output SQL statements to the console, useful for debugging and monitoring Hibernate's operations.

```xml
<hibernate-configuration>
    <session-factory>
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost/Hibernate1</property>
        <property name="connection.username">root</property>
        <property name="connection.password">your_password</property>
        <property name="hibernate.show_sql">true</property>
    </session-factory>
</hibernate-configuration>
```

> **Note**: Replace `"your_password"` with the actual password for the MySQL `root` user.

## Usage Notes

1. **Setting Up the Database**: Ensure the MySQL database named `Hibernate1` is created with appropriate tables (`Empleado` and `Departamento`).
2. **Configuring Hibernate**: Adjust the `hibernate.cfg.xml` file with correct credentials and database details.
3. **Running CRUD Operations**: Use the `DepartamentoView` and `EmpleadoView` classes in the `view` package to perform CRUD operations.
4. **Viewing SQL Output**: With `hibernate.show_sql` enabled, all SQL statements executed by Hibernate will be printed to the console, aiding in debugging and performance monitoring.

## Summary

This project demonstrates how to use Hibernate ORM to manage relational data in a MySQL database, making use of advanced configurations and HQL for data management and retrieval. It serves as a foundation for applications that require efficient data persistence and flexible querying capabilities using an ORM framework. 

