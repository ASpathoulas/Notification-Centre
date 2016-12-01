/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wandera.thenotificationcentre;

import javax.validation.constraints.NotNull;

public class NotificationConfiguration {
    
    @NotNull
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
    
    
    //public void dateFromCSVFile(){

        //String fileName = "NotificationData.csv";
        //File file = new File(fileName); 
        //try {
          //  Scanner inputStream = new Scanner(file);
           // while (inputStream.hasNext()){
            //    String data = inputStream.next();
            //    System.out.println(data);
           // }
           // inputStream.close();

        //} catch (FileNotFoundException e) {
        //    // TODO Auto-generated catch block
        //    e.printStackTrace();
       // }
        
    //}
    
}
