package Inventory.repository;

import Inventory.objects.SupplyQuantity;
import Inventory.objects.productionCost;
import Production.NecessarySupply;
import Production.Production;
import Production.Stage;
import Production.Step;
import Production.repository.ProductionRepository;
import Supply.Supply;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import Supply.repository.SupplyRepository;
import java.util.ArrayList;
import java.util.LinkedList;
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

    private SupplyRepository supplyRepository;
    private ProductionRepository productionRepository;

    @EJB
    public void setSupplyRepository(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    @EJB
    public void setProductionRepository(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public List<productionCost> getBestProductsBaseOnAvailableMaterial() {
        List<Supply> availableSupplies = supplyRepository.getSupply(null, null, null, AvailabilityFilter.AVAILABLE, ExpirationDateFilter.NOT_EXPIRED);
        List<Production> productions = productionRepository.AllProductions();
        List<productionCost> result = new ArrayList<>();

        if (!availableSupplies.isEmpty() && !productions.isEmpty()) {
            for (Production prod : productions) {
                List<Supply> supplies = new ArrayList<>();
                for (NecessarySupply necessarySupplie : getNecessarySupplies(prod)) {
                    supplies.add(necessarySupplie.getSupplyCode());
                }
                if ((!supplies.isEmpty()) && availableSupplies.containsAll(supplies)) {
                    result.add(new productionCost(prod, 0));
                }
            }
        }
        return result;
    }

    public List<productionCost> costByPruductionAndBatch(List<productionCost> selectedProduction) {
//        for (productionCost selectedProd : selectedProduction) {
//            List<SupplyQuantity> supplies = new LinkedList<>();
//            for (NecessarySupply necessarySupplie : getNecessarySupplies(selectedProd.getProduction())) {
//                supplies.add(new SupplyQuantity(necessarySupplie.getSupplyCode(), (necessarySupplie.getQuantity() * selectedProd.getBatch())));
//            }
//            selectedProd.setSupplies(supplies);
//            selectedProd.setCost((selectedProd.getProduction().getPriceLot() * selectedProd.getBatch()));
//        }
//        return selectedProduction;
        return null;
    }

    public List<NecessarySupply> getNecessarySupplies(Production production) {
//        List<NecessarySupply> result = new LinkedList<>();
//        for (Stage stageList : production.getStageList()) {
//            for (Step stepList : stageList.getStepList()) {
//                result.addAll(stepList.getNecessarySupplyList());
//            }
//        }
//        return result;
        return null;
    }
}
