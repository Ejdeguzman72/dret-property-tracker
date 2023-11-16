package com.dret.propertytracker.jpa;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Table(name = "MAINTENANCE")
@Entity
@CrossOrigin
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenance_id")
    long maintenanceId;
    @Column(name = "amount")
    double amount;
    @Column(name = "trxType")
    String trxType;
    @Column(name = "trxDate")
    String trxDate;
    @ManyToOne
    @JoinColumn(name = "property_id")
    Property property;

    public long getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(long maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
