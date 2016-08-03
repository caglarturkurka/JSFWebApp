/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import services.HelloService;

/**
 *
 * @author caglarturkurka
 */
@ManagedBean
@RequestScoped
public class HelloController {

    /**
     * Creates a new instance of HelloController
     */
    
    private String name;
    private String surname;
    private int age;
    
    
    private HelloService helloService;
    
    
    @PostConstruct
    public void init(){
        this.helloService = new HelloService();
    }
    
    public HelloController() {
        
    }
    
    public void welcomeMessage(ActionEvent actionEvent){
        int newAge=0;
        if(age>0){
            newAge=helloService.yasToplama(this.age);
            
            addMessage("Merhaba " + name + " " + surname +" Yasınız + 10 = "+newAge);
        }else{
            addMessage("Daha Dogmadın");
        }
        
        
    }
    
  
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
