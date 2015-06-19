/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.development.simplestockmanager.business.object.helper;

import com.development.simplestockmanager.business.persistence.controller.PaymentTypeJpaController;
import javax.persistence.Query;

/**
 *
 * @author foxtrot
 */
public class PaymentTypeHelper {

    public static PaymentTypeJpaController getJpaController() {
        return new PaymentTypeJpaController(EntityManagerHelper.getEntityManagerFactory());
    }

    public static Query getFindByIdQuery(long id) {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("PaymentType.findById");
        query.setParameter("id", id);

        return query;
    }
    
    public static Query getFindByTypeQuery(String type) {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("PaymentType.findByType");
        query.setParameter("type", type);
        
        return query;
    }
}