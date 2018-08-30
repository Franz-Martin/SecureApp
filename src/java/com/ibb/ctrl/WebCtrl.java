package com.ibb.ctrl;

import com.ibb.model.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author schulung
 */
@ManagedBean
@SessionScoped
public class WebCtrl {
    
    private Person person;

    public WebCtrl() {
        person=new Person();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    //-------------- meine Methoden
    
    public void doSomething(){
        System.out.println("Ausgabe:"+person.getPasswort());
    }
    
    public void login(){
        try {
            HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.login(person.getUsername(), person.getPasswort());
            
        } catch (ServletException ex) {
            Logger.getLogger(WebCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
