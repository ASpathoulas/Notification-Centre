package com.wandera.thenotificationcentre;


import com.wandera.thenotificationcentre.db.DataController;
import com.wandera.thenotificationcentre.resources.ServiceResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NotificationCentreApplication extends Application<NotificationCentreConfiguration> {
    
    
    
    public static void main(final String[] args) throws Exception {
        DataController.LoadData(Resources.DataFilePath);
        new NotificationCentreApplication().run(args);
    }

    @Override
    public String getName() {
        return "NotificationCentre";
    }

    @Override
    public void initialize(final Bootstrap<NotificationCentreConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(NotificationCentreConfiguration conf,Environment environment) throws Exception{
        // TODO: implement application
        environment.jersey().register(new ServiceResource(conf.getMessages()));
    }

}
