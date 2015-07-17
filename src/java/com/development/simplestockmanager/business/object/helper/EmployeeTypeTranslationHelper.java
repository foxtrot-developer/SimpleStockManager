package com.development.simplestockmanager.business.object.helper;

import com.development.simplestockmanager.business.persistence.controller.EmployeeTypeJpaController;
import javax.persistence.Query;

/**
 * Helper class for EmployeeTypeTranslation object
 *
 * @author foxtrot
 */
public class EmployeeTypeTranslationHelper extends CommonHelper implements BaseTypeTranslationHelper {

    public EmployeeTypeJpaController getJpaController() {
        return new EmployeeTypeJpaController(entityManagerFactory);
    }

    @Override
    public Query getFindByTranslationAndLanguage(String translation, String language) {
        Query query = entityManager.createNamedQuery("EmployeeTypeTranslation.findByTranslationAndLanguage");
        query.setParameter("translation", translation);
        query.setParameter("language", language);
        
        return query;
    }

}