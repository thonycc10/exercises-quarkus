package org.thony.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/log")
public class LogResource {
    private static final Logger LOG = Logger.getLogger(LogResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String generarLog() {
        LOG.info("Mensaje de prueba para monitoreo en Loki.");
        LOG.debug("Esto es un mensaje DEBUG para pruebas.");
        LOG.warn("Advertencia: algo relevante pasó.");
        LOG.error("Error simulado para verificar stack traces.");

        return "Logs generados!";
    }
}
