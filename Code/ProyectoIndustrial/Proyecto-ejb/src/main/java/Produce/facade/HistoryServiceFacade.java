/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produce.facade;

import Produce.History;
import javax.ejb.Local;

/**
 *
 * @author angelrg
 */
@Local
public interface HistoryServiceFacade {
    public History createHistory(History history);
}
