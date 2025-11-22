package org.thony.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.thony.notifier.ws.NotificacionSocket;

@ApplicationScoped
public class NotificacionService {

    @Inject
    NotificacionSocket socket;

    public void send(String mensssage) {
        socket.enviarNotificacion(mensssage);
    }
}
