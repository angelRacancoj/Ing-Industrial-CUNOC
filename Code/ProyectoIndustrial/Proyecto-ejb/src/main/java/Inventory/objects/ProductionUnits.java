/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory.objects;

import Production.Production;
import java.io.Serializable;

/**
 *
 * @author angelrg
 */
public class ProductionUnits implements Serializable {

    Production production;
    int units;

    public ProductionUnits() {
    }

    public ProductionUnits(Production production, int units) {
        this.production = production;
        this.units = units;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

}
