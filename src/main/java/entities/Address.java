/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Staal
 */
@Entity
public class Address extends InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String Street;
    private String AdditionalInfo;
    @OneToMany(mappedBy = "adress")
    private List<InfoEntity> infoentity;
    @ManyToOne
    private CityInfo cityinfo;

    public Address() {
    }

    /**
     * @return the Street
     */
    public String getStreet() {
        return Street;
    }

    /**
     * @param Street the Street to set
     */
    public void setStreet(String Street) {
        this.Street = Street;
    }

    /**
     * @return the AdditionalInfo
     */
    public String getAdditionalInfo() {
        return AdditionalInfo;
    }

    /**
     * @param AdditionalInfo the AdditionalInfo to set
     */
    public void setAdditionalInfo(String AdditionalInfo) {
        this.AdditionalInfo = AdditionalInfo;
    }

}
