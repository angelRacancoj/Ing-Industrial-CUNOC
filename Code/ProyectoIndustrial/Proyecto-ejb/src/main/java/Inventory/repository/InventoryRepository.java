package Inventory.repository;

import Design.Design;
import Inventory.objects.DesignUnits;
import Inventory.objects.SupplyQuantity;
import Production.NecessarySupply;
import Production.Production;
import Production.repository.DesignRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class InventoryRepository {

    private DesignRepository designRepository;

    @EJB
    public void setDesignRepository(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    /**
     * TODO needs a function that get the best options
     *
     * @return
     */
    public List<Production> getBestProductsBaseOnAvailableMaterial() {
        return null;
    }

    /**
     * Return the cost of produce the Design units
     *
     * @param designUnits
     * @return
     */
    public double totalCost(DesignUnits designUnits) {
        return unitCost(designUnits) * designUnits.getUnits();
    }

    /**
     * Return the cost of produce a Design
     *
     * @param designUnits
     * @return
     */
    public double unitCost(DesignUnits designUnits) {
        Design design = designRepository.findDesignByID(designUnits.getDesign().getIdDesign()).get();
        double cost = 0;
        for (NecessarySupply necessarySupply : design.getNecessarySupplyList()) {
            cost += (necessarySupply.getSupplyCode().getCost() * necessarySupply.getQuantity());
        }
        return cost;
    }

    /**
     * Return the necessary supplies to produce the units of a Design
     *
     * @param designUnits
     * @return
     */
    public List<SupplyQuantity> getNecessarySupplies(DesignUnits designUnits) {
        Design design = designRepository.findDesignByID(designUnits.getDesign().getIdDesign()).get();
        ArrayList<SupplyQuantity> necesarySupplies = new ArrayList<>();

        for (NecessarySupply necessaryS : design.getNecessarySupplyList()) {
            necesarySupplies.add(new SupplyQuantity(necessaryS.getSupplyCode(), (necessaryS.getQuantity() * designUnits.getUnits())));
        }

        return necesarySupplies;
    }

    /**
     * Return all Designs and an Integer number to manage the quantity
     *
     * @param id
     * @param nameProduction
     * @return
     */
    public List<DesignUnits> DesignWithUnitsPlaces(Integer id, String nameProduction) {
        List<Design> designs = designRepository.getDesign(id, nameProduction);
        List<DesignUnits> designUnits = new ArrayList<>();
        for (Design design : designs) {
            designUnits.add(new DesignUnits(design, 1));
        }
        return designUnits;
    }
}
