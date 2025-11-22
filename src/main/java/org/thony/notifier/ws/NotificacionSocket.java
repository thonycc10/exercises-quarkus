package org.thony.notifier.ws;

import io.quarkus.websockets.next.*;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
@WebSocket(path = "/ws/notificaciones")
public class NotificacionSocket {

    private static final Set<WebSocketConnection> sessions = ConcurrentHashMap.newKeySet();

    @OnOpen
    public void onOpen(WebSocketConnection connection) {
        // guardar la sesión cuando se abre
        sessions.add(connection);
    }

    @OnTextMessage
    public void onMessage(String msg, WebSocketConnection session) {
        // opcional: responder al cliente
        session.sendTextAndAwait("Conectado correctamente. Mensaje recibido: " + msg);
    }

    @OnClose
    public void onClose(WebSocketConnection connection) {
        // remover la sesión cuando se cierra
        sessions.remove(connection);
    }

    public void enviarNotificacion(String mensssage) {
        sessions.forEach(s -> s.sendTextAndAwait(mensssage));
    }
}