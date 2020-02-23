package Modify;

import java.io.Serializable;

/**
 *
 * @author angelrg
 */
public enum ModificationType implements Serializable {
    POR_FALTANTE,
    POR_ROBO,
    ATRIBUTOS;
    
    public String dropDownName(){
        switch(this){
            case POR_FALTANTE:
                return "Por Faltante";
            case POR_ROBO:
                return "Por Robo";
            default:
                return "Por Atributos";
        }
    }
    
    
}
