/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.development.simplestockmanager.business.object.nullpackage;

import com.development.simplestockmanager.business.common.Constant;
import com.development.simplestockmanager.business.persistence.old.EmployeeType;

/**
 *
 * @author foxtrot
 */
public class EmployeeTypeNull extends EmployeeType {

    public EmployeeTypeNull() {
        super(Constant.IDENTIFIER.INVALID);
    }
    
}
