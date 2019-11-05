/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modify.facade;

import Modify.ModifySupply;
import javax.ejb.Local;

/**
 *
 * @author angelrg
 */
@Local
public interface ModifySupplyServiceFacade {
    public ModifySupply createModifySupply(ModifySupply modifySupply);
}
