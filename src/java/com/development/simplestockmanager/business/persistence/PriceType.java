/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.development.simplestockmanager.business.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monica
 */
@Entity
@Table(name = "PRICE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PriceType.findAll", query = "SELECT p FROM PriceType p"),
    @NamedQuery(name = "PriceType.findById", query = "SELECT p FROM PriceType p WHERE p.id = :id"),
    @NamedQuery(name = "PriceType.findByType", query = "SELECT p FROM PriceType p WHERE p.type = :type"),
    @NamedQuery(name = "PriceType.findByIsEnable", query = "SELECT p FROM PriceType p WHERE p.isEnable = :isEnable"),
    @NamedQuery(name = "PriceType.findByCreatedDate", query = "SELECT p FROM PriceType p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PriceType.findByCreatedUser", query = "SELECT p FROM PriceType p WHERE p.createdUser = :createdUser"),
    @NamedQuery(name = "PriceType.findByLastModifiedDate", query = "SELECT p FROM PriceType p WHERE p.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "PriceType.findByLastModifiedUser", query = "SELECT p FROM PriceType p WHERE p.lastModifiedUser = :lastModifiedUser")})
public class PriceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "IS_ENABLE")
    private boolean isEnable;
    @Basic(optional = false)
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "CREATED_USER")
    private String createdUser;
    @Basic(optional = false)
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Basic(optional = false)
    @Column(name = "LAST_MODIFIED_USER")
    private String lastModifiedUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priceType")
    private List<Price> priceList;
    @JoinColumn(name = "LANGUAGE_TYPE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private LanguageType languageType;
    @OneToMany(mappedBy = "referencedType")
    private List<PriceType> priceTypeList;
    @JoinColumn(name = "REFERENCED_TYPE", referencedColumnName = "ID")
    @ManyToOne
    private PriceType referencedType;

    public PriceType() {
    }

    public PriceType(Long id) {
        this.id = id;
    }

    public PriceType(Long id, String type, boolean isEnable, Date createdDate, String createdUser, Date lastModifiedDate, String lastModifiedUser) {
        this.id = id;
        this.type = type;
        this.isEnable = isEnable;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    @XmlTransient
    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public void setLanguageType(LanguageType languageType) {
        this.languageType = languageType;
    }

    @XmlTransient
    public List<PriceType> getPriceTypeList() {
        return priceTypeList;
    }

    public void setPriceTypeList(List<PriceType> priceTypeList) {
        this.priceTypeList = priceTypeList;
    }

    public PriceType getReferencedType() {
        return referencedType;
    }

    public void setReferencedType(PriceType referencedType) {
        this.referencedType = referencedType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PriceType)) {
            return false;
        }
        PriceType other = (PriceType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.PriceType[ id=" + id + " ]";
    }
    
}