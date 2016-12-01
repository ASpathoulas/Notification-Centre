/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.thenotificationcentre.db;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;


public class CSVParser {
    private Notifications notificationsData;
    private String filePath;
    
    public CSVParser(String filePath) {
        this.notificationsData = new Notifications();
        this.filePath = filePath;
    }
    
    public void parseFile(){
        File file = new File(this.filePath);
        try {
            this.notificationsData = readObjectsFromCsv(file);
        } catch (Exception ex) {
            System.out.println("===== Failed to load file! =====");
            ex.printStackTrace();
        }
        
    }
    
    public Notifications getData(){
        if (this.notificationsData == null){
            return new Notifications();
        }
        return this.notificationsData;
    }
    
    private Notifications readObjectsFromCsv(File file) throws IOException {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(file));
            br.readLine(); //To ignore the first line
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] notifData = line.split(cvsSplitBy);
                if(notifData[0] != null){ //Do not create notification if guid is null
                    Notification notif = new Notification();
                    try{
                        notif.setNotificationGuid(UUID.fromString(notifData[0]));
                        if(notifData[1] != null)
                            notif.setDeviceGuid(UUID.fromString(notifData[1]));
                        if(notifData[2] != null)
                            notif.setUserGuid(UUID.fromString(notifData[2]));
                        if(notifData[3] != null)
                            notif.setEventType(notifData[3]);
                        if(notifData[4] != null)
                            notif.setEventSubtype(notifData[4]);
                        
                        notif.setGeofenceLat(getDouble(notifData[5]));
                        notif.setGeofenceLon(getDouble(notifData[6]));
                        notif.setGeofenceRadiusMetres(getDouble(notifData[7]));
                        
                        if(notifData[8] != null)
                            notif.setTitle(notifData[8]);
                        if(notifData[9] != null)
                            notif.setContent(notifData[9]);
                        
                        notif.setEventTimestamp(getTimestamp(notifData[10]));
                        notif.setSentTimestamp(getTimestamp(notifData[11]));
                        
                        this.notificationsData.AddNotification(notif);
                    }
                    catch(Exception ex){
                        System.out.println("=== Entity cannot be parsed. ===");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return this.notificationsData;
                
    }
    
    private Double getDouble(String d){
        try{
            return Double.parseDouble(d);
        }
        catch(Exception e){
            return null;
        }
    }
    
    private Timestamp getTimestamp(String str_date){
        try {
            long val = new BigDecimal(str_date).longValue();
            Timestamp timeStampDate = new Timestamp(val);
            return timeStampDate;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return null;
        }
    }
}
