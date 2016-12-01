package com.wandera.thenotificationcentre.db;

import java.sql.Timestamp;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "notificationGuid",
    "deviceGuid",
    "userGuid",
    "eventType",
    "eventSubtype",
    "geofenceLat",
    "geofenceLon",
    "geofenceRadiusMetres",
    "title",
    "content",
    "eventTimestamp",
    "sentTimestamp",
    "read"
})
@XmlRootElement(name = "Notification")
public class Notification {
    
    private UUID notificationGuid;
    private UUID deviceGuid;
    private UUID userGuid;
    private String eventType;
    private String eventSubtype;
    private Double geofenceLat;
    private Double geofenceLon;
    private Double geofenceRadiusMetres;
    private String title;
    private String content;
    private Timestamp eventTimestamp;
    private Timestamp sentTimestamp;
    private boolean read;
    
    public Notification(){
        this.read = false;
    }
    
    public Notification(
            UUID notificationGuid, UUID deviceGuid, UUID userGuid, 
            String eventType, String eventSubtype, Double geofenceLat, 
            Double geofenceLon, Double geofenceRadiusMetres, String title, 
            String content, Timestamp eventTimestamp, Timestamp sentTimestamp) {
        
        this.notificationGuid = notificationGuid;
        this.deviceGuid = deviceGuid;
        this.userGuid = userGuid;
        this.eventType = eventType;
        this.eventSubtype = eventSubtype;
        this.geofenceLat = geofenceLat;
        this.geofenceLon = geofenceLon;
        this.geofenceRadiusMetres = geofenceRadiusMetres;
        this.title = title;
        this.content = content;
        this.eventTimestamp = eventTimestamp;
        this.sentTimestamp = sentTimestamp;
        this.read = false;
    }
    
    public UUID getNotificationGuid() {
        return notificationGuid;
    }

    public UUID getDeviceGuid() {
        return deviceGuid;
    }

    public UUID getUserGuid() {
        return userGuid;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventSubtype() {
        return eventSubtype;
    }

    public Double getGeofenceLat() {
        return geofenceLat;
    }

    public Double getGeofenceLon() {
        return geofenceLon;
    }

    public Double getGeofenceRadiusMetres() {
        return geofenceRadiusMetres;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getEventTimestamp() {
        return eventTimestamp;
    }

    public Timestamp getSentTimestamp() {
        return sentTimestamp;
    }

    public boolean isIsRead() {
        return read;
    }

    public void setNotificationGuid(UUID notificationGuid) {
        this.notificationGuid = notificationGuid;
    }

    public void setDeviceGuid(UUID deviceGuid) {
        this.deviceGuid = deviceGuid;
    }

    public void setUserGuid(UUID userGuid) {
        this.userGuid = userGuid;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventSubtype(String eventSubtype) {
        this.eventSubtype = eventSubtype;
    }

    public void setGeofenceLat(Double geofenceLat) {
        this.geofenceLat = geofenceLat;
    }

    public void setGeofenceLon(Double geofenceLon) {
        this.geofenceLon = geofenceLon;
    }

    public void setGeofenceRadiusMetres(Double geofenceRadiusMetres) {
        this.geofenceRadiusMetres = geofenceRadiusMetres;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEventTimestamp(Timestamp eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public void setSentTimestamp(Timestamp sentTimestamp) {
        this.sentTimestamp = sentTimestamp;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

}