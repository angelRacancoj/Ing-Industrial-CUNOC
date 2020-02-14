/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory.objects;

import Production.Production;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author angelrg
 */
public class productionCost implements Serializable{

    Production production;
    List<SupplyQuantity> supplies;
    Double cost;
    int batch;

    public productionCost() {
    }

    public productionCost(Production production, int batch) {
        this.production = production;
        this.batch = batch;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public List<SupplyQuantity> getSupplies() {
        return supplies;
    }

    public void setSupplies(List<SupplyQuantity> supplies) {
        this.supplies = supplies;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}
