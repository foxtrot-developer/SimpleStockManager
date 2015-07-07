package com.development.simplestockmanager.business.object.helper;

import com.development.simplestockmanager.business.persistence.controller.PriceJpaController;

/**
 * Helper class for Price object
 *
 * @author foxtrot
 */
public class PriceHelper {

    public PriceJpaController getJpaController() {
        return new PriceJpaController(EntityManagerHelper.getEntityManagerFactory());
    }
}
