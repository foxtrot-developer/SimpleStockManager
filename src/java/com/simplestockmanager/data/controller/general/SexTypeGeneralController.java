/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplestockmanager.data.controller.general;

import com.simplestockmanager.constant.DeleteConstant;
import com.simplestockmanager.constant.IdentifierConstant;
import com.simplestockmanager.constant.UpdateConstant;
import com.simplestockmanager.data.nullpackage.SexTypeNull;
import com.simplestockmanager.helper.SexTypeHelper;
import com.simplestockmanager.persistence.SexType;
import com.simplestockmanager.persistence.controller.SexTypeJpaController;
import javax.persistence.Query;

/**
 * TESTED
 * @author foxtrot
 */
public class SexTypeGeneralController {

    public static long create(String type) {

        SexType sexType;
        Query query = SexTypeHelper.getFindByTypeQuery(type);

        try {
            sexType = (SexType) query.getSingleResult();
        } catch (Exception e) {
            sexType = new SexType(type);

            try {
                SexTypeJpaController sexTypeJpaController = SexTypeHelper.getJpaController();
                sexTypeJpaController.create(sexType);
            } catch (Exception e2) {
                sexType = new SexTypeNull();
            }
        }

        return sexType.getId();
    }

    public static SexType read(long id) {

        SexType sexType;

        try {
            Query query = SexTypeHelper.getFindByIdQuery(id);
            sexType = (SexType) query.getSingleResult();
        } catch (Exception e) {
            sexType = new SexTypeNull();
        }

        return sexType;
    }

    public static long update(long id, String type) {

        long status = UpdateConstant.FAILURE;

        if (read(id).getId() != IdentifierConstant.INVALID) {
            Query query = SexTypeHelper.getFindByTypeQuery(type);

            if (query.getResultList().isEmpty()) {
                SexType sexType = new SexType(id, type);

                try {
                    SexTypeJpaController sexTypeJpaController = SexTypeHelper.getJpaController();
                    sexTypeJpaController.edit(sexType);
                    status = UpdateConstant.SUCCESS;
                } catch (Exception e) {

                }
            }
        }

        return status;
    }

    public static long delete(long id) {

        long status = DeleteConstant.FAILURE;

        if (read(id).getId() != IdentifierConstant.INVALID) {
            try {
                SexTypeJpaController sexTypeJpaController = SexTypeHelper.getJpaController();
                sexTypeJpaController.destroy(id);
                status = DeleteConstant.SUCCESS;
            } catch (Exception e) {

            }
        }

        return status;
    }
}