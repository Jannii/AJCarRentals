/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Johan Nilsson
 */
@Entity
@Table(name = "office")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Office.findAll", query = "SELECT o FROM Office o")
    , @NamedQuery(name = "Office.findByIdOffice", query = "SELECT o FROM Office o WHERE o.idOffice = :idOffice")
    , @NamedQuery(name = "Office.findByOfficeName", query = "SELECT o FROM Office o WHERE o.officeName = :officeName")
    , @NamedQuery(name = "Office.findByOfficeAdress", query = "SELECT o FROM Office o WHERE o.officeAdress = :officeAdress")
    , @NamedQuery(name = "Office.findByOfficeLocation", query = "SELECT o FROM Office o WHERE o.officeLocation = :officeLocation")
    , @NamedQuery(name = "Office.findByOfficePhone", query = "SELECT o FROM Office o WHERE o.officePhone = :officePhone")})
public class Office implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOffice")
    private Integer idOffice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "OfficeName")
    private String officeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "OfficeAdress")
    private String officeAdress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "OfficeLocation")
    private String officeLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "OfficePhone")
    private String officePhone;
    @ManyToMany(mappedBy = "officeCollection")
    private Collection<Booking> bookingCollection;

    public Office() {
    }

    public Office(Integer idOffice) {
        this.idOffice = idOffice;
    }

    public Office(Integer idOffice, String officeName, String officeAdress, String officeLocation, String officePhone) {
        this.idOffice = idOffice;
        this.officeName = officeName;
        this.officeAdress = officeAdress;
        this.officeLocation = officeLocation;
        this.officePhone = officePhone;
    }

    public Integer getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Integer idOffice) {
        this.idOffice = idOffice;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeAdress() {
        return officeAdress;
    }

    public void setOfficeAdress(String officeAdress) {
        this.officeAdress = officeAdress;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOffice != null ? idOffice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Office)) {
            return false;
        }
        Office other = (Office) object;
        if ((this.idOffice == null && other.idOffice != null) || (this.idOffice != null && !this.idOffice.equals(other.idOffice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.Office[ idOffice=" + idOffice + " ]";
    }
    
}
