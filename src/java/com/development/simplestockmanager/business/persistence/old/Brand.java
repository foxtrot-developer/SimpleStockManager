/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.development.simplestockmanager.business.persistence.old;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foxtrot
 */
@Entity
@Table(name = "Brand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
    @NamedQuery(name = "Brand.findById", query = "SELECT b FROM Brand b WHERE b.id = :id"),
    @NamedQuery(name = "Brand.findByName", query = "SELECT b FROM Brand b WHERE b.name = :name"),
    @NamedQuery(name = "Brand.findByIsEnable", query = "SELECT b FROM Brand b WHERE b.isEnable = :isEnable")})
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "isEnable")
    private boolean isEnable;

    public Brand() {
    }

    public Brand(Long id) {
        this.id = id;
    }

    public Brand(String name, boolean isEnable) {
        this.name = name;
        this.isEnable = isEnable;
    }

    public Brand(Long id, String name, boolean isEnable) {
        this.id = id;
        this.name = name;
        this.isEnable = isEnable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Brand other = (Brand) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.isEnable != other.isEnable) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "com.simplestockmanager.persistence.Brand[ id=" + id + " ]";
    }
    
}
