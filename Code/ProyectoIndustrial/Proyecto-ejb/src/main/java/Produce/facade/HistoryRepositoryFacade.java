/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produce.facade;

import Produce.History;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

/**
 *
 * @author angelrg
 */
@Local
public interface HistoryRepositoryFacade {

    public Optional<History> findById(int id);

    public List<History> getAll();
}
