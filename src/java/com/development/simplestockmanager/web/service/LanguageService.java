package com.development.simplestockmanager.web.service;

import com.development.simplestockmanager.common.constant.CommonConstant;
import com.development.simplestockmanager.common.language.Header;
import com.development.simplestockmanager.common.language.LanguageController;
import com.development.simplestockmanager.web.service.general.AuthenticationService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Service class for internationalization functionality
 *
 * @author foxtrot
 */
@ManagedBean(name = "language")
@SessionScoped
public class LanguageService implements Serializable {

    private final LanguageController controller;
    
    private final String entity;
    private final String type;
    private final String relation;
    
    private final Header brand;
    private final Header client;
    private final Header employee;
    private final Header product;
    private final Header provider;
    private final Header store;
    private final Header employee_type;
    private final Header payment_type;
    private final Header price_type;
    private final Header product_type;
    private final Header sex_type;
    
    
    
    private String attributes;
    private String browser;
    private String credentials;
    private String list;
    private String manager;
    private String viewer;
    private String visibility;
    
    public LanguageService() {        
        controller = new LanguageController(new AuthenticationService().getCurrentEmployee().getLanguage().getCode());

        entity = controller.getWord(CommonConstant.TRANSLATION.ENTITY.TEXT);
        type = controller.getWord(CommonConstant.TRANSLATION.TYPE.TEXT);
        relation = "null";
        
        brand = new Header(controller, CommonConstant.TRANSLATION.ENTITY.BRAND);
        client = new Header(controller, CommonConstant.TRANSLATION.ENTITY.CLIENT);
        employee = new Header(controller, CommonConstant.TRANSLATION.ENTITY.EMPLOYEE);
        product = new Header(controller, CommonConstant.TRANSLATION.ENTITY.PRODUCT);
        provider = new Header(controller, CommonConstant.TRANSLATION.ENTITY.PROVIDER);
        store = new Header(controller, CommonConstant.TRANSLATION.ENTITY.STORE);
        
        employee_type = new Header(controller, CommonConstant.TRANSLATION.TYPE.EMPLOYEE_TYPE);
        payment_type = new Header(controller, CommonConstant.TRANSLATION.TYPE.PAYMENT_TYPE);
        price_type = new Header(controller, CommonConstant.TRANSLATION.TYPE.PRICE_TYPE);
        product_type = new Header(controller, CommonConstant.TRANSLATION.TYPE.PRODUCT_TYPE);
        sex_type = new Header(controller, CommonConstant.TRANSLATION.TYPE.SEX_TPE);
    }
    
    public void reload() {
        FacesContext.getCurrentInstance().getExternalContext().
    }

    public String getEntity() {
        return entity;
    }

    public String getType() {
        return type;
    }

    public String getRelation() {
        return relation;
    }

    public Header getBrand() {
        return brand;
    }

    public Header getClient() {
        return client;
    }

    public Header getEmployee() {
        return employee;
    }

    public Header getProduct() {
        return product;
    }

    public Header getProvider() {
        return provider;
    }

    public Header getStore() {
        return store;
    }

    public Header getEmployee_type() {
        return employee_type;
    }

    public Header getPayment_type() {
        return payment_type;
    }

    public Header getPrice_type() {
        return price_type;
    }

    public Header getProduct_type() {
        return product_type;
    }

    public Header getSex_type() {
        return sex_type;
    }

}
