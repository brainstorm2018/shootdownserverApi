package org.zerhusen.model.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class History {
    @Id
    @Column
    @GeneratedValue
    private Long id;
    private Date opertationDateTime;
    private String typeOfOperation;
    private String message;

    public History() {
        setOpertationDateTime();
    }

    public History(String typeOfOperation, String message) {
        setOpertationDateTime();
        setMessage(message);
        setTypeOfOperation(typeOfOperation);
    }

    public Long getId() {
        return id;
    }

    public Date getOpertationDateTime() {
        return opertationDateTime;
    }

    public void setOpertationDateTime() {
        this.opertationDateTime = new Date();
    }

    public void setOpertationDateTime(Date opertationDateTime) {
        this.opertationDateTime = opertationDateTime;
        if (this.opertationDateTime == null) {
            this.opertationDateTime = new Date();
        }
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
        if (this.typeOfOperation == null) {
            this.typeOfOperation = "Not Specefied!";
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        if (this.message == null) {
            this.message = "Not Specefied!";
        }
    }
}
