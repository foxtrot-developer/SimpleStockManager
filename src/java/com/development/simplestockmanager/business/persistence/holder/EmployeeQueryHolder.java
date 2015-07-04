package com.development.simplestockmanager.business.persistence.holder;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Query holder for Employee object
 *
 * @author foxtrot
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findByCredentials", query = "SELECT e FROM Employee e WHERE e.username = :username AND e.password = :password AND e.enable = TRUE"),
    @NamedQuery(name = "Employee.findBySession", query = "SELECT e FROM Employee e WHERE e.sessionId = :session AND e.isOnline = TRUE")})
public class EmployeeQueryHolder implements Serializable {

    @Id
    private final long id = 1L;
}