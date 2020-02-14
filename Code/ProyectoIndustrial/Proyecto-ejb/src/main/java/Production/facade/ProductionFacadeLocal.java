/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Production.facade;

import Production.Product;
import Production.Production;
import Production.exceptions.MandatoryAttributeProductionException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface ProductionFacadeLocal {
    
    public void createProduction(Production production)throws MandatoryAttributeProductionException;
    public void editProduction(Production production)throws MandatoryAttributeProductionException;
    public List<Product> getProduct();
}
