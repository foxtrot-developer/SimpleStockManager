package com.development.simplestockmanager.business.object.helper;

import com.development.simplestockmanager.business.persistence.controller.PriceTypeJpaController;

/**
 * Helper class for PriceType object
 *
 * @author foxtrot
 */
public class PriceTypeHelper extends BaseHelper {

    public PriceTypeJpaController getJpaController() {
        return new PriceTypeJpaController(entityManagerFactory);
    }
}
