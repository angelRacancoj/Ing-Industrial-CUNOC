package Supply.facade;

import Supply.Measure;
import Supply.Supply;
import Supply.exception.MandatoryAttributeSupplyException;
import Supply.repository.AvailabilityFilter;
import Supply.repository.ExpirationDateFilter;
import java.util.List;
import User.User;
import User.exception.UserException;
import java.time.LocalDate;
import javax.ejb.Local;

@Local
public interface SupplyFacadeLocal {

    /**
     * Obtiene todas las medidas
     *
     * @return Lista de medidas
     */
    public List<Measure> getAllMeasures();

    /**
     * *
     * Obtiene una medida por medio de su id
     *
     * @param measure Objeto de tipo measure que encapsulo el id a buscar
     * @return La medida con el id proporcionado
     * @throws MandatoryAttributeSupplyException Si hace falta algun atributo
     * obligatorio
     */
    public List<Measure> getMeasure(Measure measure) throws MandatoryAttributeSupplyException;

    /**
     * *
     * Crea un nuevo Insumo en BD
     *
     * @param newSupply Objeto Supply a crear en BD
     * @return El Objeto creado en la BD
     * @throws MandatoryAttributeSupplyException Si hace falta algun atributo
     * obligatorio
     */
    public Supply createSupply(Supply newSupply) throws MandatoryAttributeSupplyException;

    /**
     * *
     * Busca los Insumos que cumplan con los criterios de busqueda
     * proporcionados
     *
     * @param codeSupply codigo del Insumo a buscar
     * @param nameSupply Nombre del Insumo a buscar
     * @param availabilitySupply Disponibilidad del Insumo a Buscar
     * @param expirationDateSupply Fecha de Expiracion del Insumo a Buscar
     * @return
     */
    public List<Supply> searchSupplies(Integer codeSupply, String nameSupply, AvailabilityFilter availabilitySupply, ExpirationDateFilter expirationDateSupply);

    /**
     * Set the Quantity to cero and save a who do the change
     *
     * @param supplyToChange
     * @param user
     * @param noteModify
     * @return
     */
    public Supply modifyByTheft(Supply supplyToChange, User user, String noteModify);

    /**
     * This option allow to modify the quantity available, and save the identity
     * of the modifier user
     *
     * @param supplyToChange
     * @param newQuantity
     * @param user
     * @param noteModify
     * @return
     * @throws Supply.exception.MandatoryAttributeSupplyException
     */
    public Supply modifyByMissing(Supply supplyToChange, Double newQuantity, User user, String noteModify) throws MandatoryAttributeSupplyException;

    /**
     * This option allow to modify simple attributes
     *
     * @param supply
     * @param newName
     * @param newExpirationDate
     * @param newCost
     * @param newDescription
     * @return
     */
    public Supply modifySupply(Supply supply) throws UserException;
}
