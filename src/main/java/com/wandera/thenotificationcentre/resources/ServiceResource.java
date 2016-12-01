/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wandera.thenotificationcentre.resources;
import com.wandera.thenotificationcentre.db.CSVParser;
import com.wandera.thenotificationcentre.db.Notification;
import com.wandera.thenotificationcentre.NotificationConfiguration;
import com.wandera.thenotificationcentre.Resources;
import com.wandera.thenotificationcentre.db.DataController;
import com.wandera.thenotificationcentre.db.Notifications;
import java.util.ArrayList;
import javax.ws.rs.DELETE;


import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
        
@Path(value = "/notifications")
public class ServiceResource {
    
    private final NotificationConfiguration conf;

    public ServiceResource(NotificationConfiguration conf) {
        this.conf = conf;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Notification> displayAllNotifications() {
        try{
            return DataController.GetAllNotifications().getListNotification();
        }catch(Exception e){
            return null;
        }
    }
    
    @GET
    @Path(value = "/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Notification displaySingleNotification(@PathParam("id") String id) {
        try{
            return DataController.FindNotificationWithID(id);
        }catch(Exception e){
            return null;
        }
    }
    
    
    @GET
    @Path(value = "/isread/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Boolean isReadNotification(@PathParam("id") String id) {
        try{
            return DataController.FindNotificationWithID(id).isIsRead();
        }catch(Exception e){
            return null;
        }
    }
    
    @PUT
    @Path(value = "/update/read/{id}/{status}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateReadNotification(@PathParam("id") String id, @PathParam("status") Boolean status) {
        ResponseBuilder response;
        try{
            DataController.FindNotificationWithID(id).setRead(status);
            response = Response.ok("Notification is updated successfully!", MediaType.TEXT_PLAIN);
        }catch(Exception e){
            response = Response.status(Response.Status.NOT_FOUND);
        }
        return response.build();
    }
    
    @DELETE
    @Path(value = "/delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteNotification(@PathParam("id") String id) {
        ResponseBuilder response;
        try{
            if(DataController.DeleteNotificationWithID(id)){
                response = Response.ok("Notification is deleted successfully!", MediaType.TEXT_PLAIN);
            }
            else{
                response = Response.status(Response.Status.NOT_FOUND);
            }
        }catch(Exception e){
            response = Response.status(Response.Status.NOT_FOUND);
        }
        return response.build();
    }

}



