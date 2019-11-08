package Produce;

import Group.Group;
import Production.Production;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

/**
 *
 * @author angelrg
 */
@Entity
@Table(
        name = "HISTORY"
)

public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer history_id;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "total_cost", scale = 2)
    private double totalCost;
    @Column(name = "batches_produced")
    private Integer batchesProduced;
    @Column(name = "is_active")
    private boolean isActive;
    @JoinColumn(name = "group_id", referencedColumnName = "id_group")
    @ManyToOne(optional = false)
    private Group group;
    @JoinColumn(name = "production_id", referencedColumnName = "id_production")
    @ManyToOne(optional = false)
    private Production production;

    public History() {
    }

    public History(Integer history_id, LocalDate startDate, LocalDate endDate, double totalCost, Integer batchesProduced, boolean isActive, Production production, Group group) {
        this.history_id = history_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.batchesProduced = batchesProduced;
        this.isActive = isActive;
        this.production = production;
        this.group = group;
    }

    public History(LocalDate startDate, Integer batchesProduced, boolean isActive, Production production, Group group) {
        this.startDate = startDate;
        this.batchesProduced = batchesProduced;
        this.isActive = isActive;
        this.production = production;
        this.group = group;
    }

    public Integer getHistory_id() {
        return history_id;
    }

    public void setHistory_id(Integer history_id) {
        this.history_id = history_id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getBatchesProduced() {
        return batchesProduced;
    }

    public void setBatchesProduced(Integer batchesProduced) {
        this.batchesProduced = batchesProduced;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }
}
