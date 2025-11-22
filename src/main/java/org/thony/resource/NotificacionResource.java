package org.thony.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.thony.service.NotificacionService;

@Path( "/notificaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificacionResource {

    @Inject
    NotificacionService service;

    @POST
    @Path("/send")
    public String send(NotificacionRequest req) {
        service.send(req.mensssage);
        return "Notificación enviada: " + req.mensssage;
    }

    public static class NotificacionRequest {
        public String mensssage;
    }
}
