package com.development.simplestockmanager.web.object.component.selector.type;

import com.development.simplestockmanager.business.object.controller.specific.EmployeeTypeSpecificController;
import com.development.simplestockmanager.business.object.nullpackage.EmployeeTypeNull;
import com.development.simplestockmanager.business.object.nullpackage.EmployeeTypeTranslationNull;
import com.development.simplestockmanager.business.persistence.EmployeeType;
import com.development.simplestockmanager.business.persistence.EmployeeTypeTranslation;
import com.development.simplestockmanager.web.common.WebConstant;
import com.development.simplestockmanager.web.object.component.selector.BaseSelector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Selector class for EmployeeType object
 *
 * @author foxtrot
 */
public class EmployeeTypeSelector extends CommonTypeSelector implements BaseSelector {

    private final EmployeeTypeSpecificController specificController;
    private HashMap<String, EmployeeType> hashMap;

    public EmployeeTypeSelector(long mode, String language) {
        super(mode, language);
        this.specificController = new EmployeeTypeSpecificController();
        search();
    }

    public EmployeeTypeSelector(long mode, String language, EmployeeType employeeType) {
        this(mode, language);
        this.selection = getDisplayName(getTranslation(employeeType));
    }

    @Override
    public void search() {
        clear();
        List<EmployeeType> employeeTypeList;

        if (mode == WebConstant.SELECTOR.MODE.ALL) {
            employeeTypeList = specificController.getFindAll();
        } else {
            employeeTypeList = specificController.getFindEnable();
        }

        for (EmployeeType employeeType : employeeTypeList) {
            String key = getDisplayName(getTranslation(employeeType));
            hashMap.put(key, employeeType);
            list.add(key);
        }
    }

    @Override
    public void clear() {
        list = new ArrayList<>();
        hashMap = new HashMap<>();
    }
    
    public EmployeeType getSelectedValue() {
        EmployeeType employeeType = new EmployeeTypeNull();

        if (!selection.isEmpty()) {
            employeeType = hashMap.get(selection);
        }

        return employeeType;
    }

    public String getDisplayName(EmployeeType employeeType) {
        return (employeeType != null ? getDisplayName(getTranslation(employeeType)) : "");
    }
    
    private String getDisplayName(EmployeeTypeTranslation employeeTypeTranslation) {
        return employeeTypeTranslation.getTranslation();
    }
    
    private EmployeeTypeTranslation getTranslation(EmployeeType employeeType) {
        EmployeeTypeTranslation translation = new EmployeeTypeTranslationNull();
        
        for (EmployeeTypeTranslation employeeTypeTranslation : employeeType.getEmployeeTypeTranslationList()) {
            if (employeeTypeTranslation.getLanguage().getCode().equals(language)) {
                translation = employeeTypeTranslation;
            }
        }
        
        return translation;
    }

}
