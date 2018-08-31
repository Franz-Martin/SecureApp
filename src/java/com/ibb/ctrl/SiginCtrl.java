/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.ctrl;

import com.ibb.model.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author schulung
 */
@ManagedBean
@SessionScoped
public class SiginCtrl {
    
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    
    
    
    
    
    
    public boolean checkLogin(){
        boolean check=false;
        HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if(request.isUserInRole("konfigurator")||request.isUserInRole("user")){
            return true;
        }
        
        return check;
    }
    
    public void login(){
        try {
            HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.login(person.getUsername(), person.getPasswort());
            
        } catch (ServletException ex) {
            Logger.getLogger(WebCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void logout(){
         HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(WebCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
