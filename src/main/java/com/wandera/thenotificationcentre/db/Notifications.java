/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.thenotificationcentre.db;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listNotification"
})
@XmlRootElement(name = "Notifications")
public class Notifications {
    
    private ArrayList<Notification> listNotification;

    public ArrayList<Notification> getListNotification() {
        if(this.listNotification == null){
            return new ArrayList<>();
        }
        return this.listNotification;
    }

    public void setListNotification(ArrayList<Notification> listNotification) {
        this.listNotification = listNotification;
    }
    
    public void AddNotification(Notification n){
        if(this.listNotification == null){
            this.listNotification = new ArrayList<>();
        }
        this.listNotification.add(n);
    }
}
