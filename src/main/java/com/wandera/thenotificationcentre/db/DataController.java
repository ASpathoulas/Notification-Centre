/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.thenotificationcentre.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataController {
    
    private static Notifications Notifications = new Notifications();
    
    public static void LoadData(String file){
        System.out.println("=== Start loading data from file... ===");
        CSVParser parser = new CSVParser(file);
        parser.parseFile();
        Notifications = OrderAndGroup(parser.getData());
        System.out.println("=== File loaded successfully! ===");
    }
    
    public static Notification FindNotificationWithID(String guid){
        try{
            for(Notification n: Notifications.getListNotification()){
                if(guid.equals(n.getNotificationGuid().toString()))
                    return n;
            }
            return null;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean DeleteNotificationWithID(String guid){
        try{
            for(Notification n: Notifications.getListNotification()){
                if(guid.equals(n.getNotificationGuid().toString())){
                    Notifications.getListNotification().remove(n);
                    return true;
                }
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public static Notifications GetAllNotifications(){
        return Notifications;
    }
    
    private static Notifications OrderAndGroup(Notifications notifList){
        
        //Group Notifications by EventType
        //=========================================
        HashMap<String, List<Notification>> hashMap = new HashMap<String, List<Notification>>();
        for(Notification n: notifList.getListNotification()){
            if (!hashMap.containsKey(n.getEventType())) {
                List<Notification> list = new ArrayList<Notification>();
                list.add(n);
                hashMap.put(n.getEventType(), list);
            } else {
                hashMap.get(n.getEventType()).add(n);
            }
        }
        
        //Order by date
        //=========================================
        for (List<Notification> list : hashMap.values()) {
            Collections.sort(list, new Comparator<Notification>() {
                public int compare(Notification m1, Notification m2) {
                    return m1.getSentTimestamp().compareTo(m2.getSentTimestamp());
                }
            });
        }
        
        //Merge all lists
        //=========================================
        Notifications result = new Notifications();
        for (List<Notification> list : hashMap.values()) {
            for(Notification n: list){
                result.AddNotification(n);
            }
        }
        return result;
    }
}
