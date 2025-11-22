# Websocket
## Ciclo de vida
Resumen ultra simple

WebSocket comienza como HTTP

Cambia (“Upgrade”) a un canal bidireccional

La conexión se mantiene viva

Cliente y servidor pueden enviarse mensajes cuando quieran

Ideal para:

notificaciones

chats

dashboards en tiempo real

IoT

juegos

streams de datos
## Ciclo de vida
```text
┌──────────────────┐
|   CONNECTING      |  (Handshake HTTP Upgrade)
└───────┬──────────┘
        | 
        v
┌──────────────────┐
|     OPEN          |  (Conexión WebSocket lista)
└───────┬──────────┘
        |
        v
┌──────────────────┐
|   COMMUNICATING   |  (Envío/recepción de mensajes)
└───────┬──────────┘
        |
        v
┌──────────────────┐
|    CLOSING        |  (Cerrar conexión)
└───────┬──────────┘
        |
        v
┌──────────────────┐
|    CLOSED         |  (Conexión terminada)
└──────────────────┘
```
## Ejemplo de notificaciones
```text
                         ┌──────────┐
                         | Servidor |
                         | WebSocket|
                         └────┬─────┘
                              |  Enviar notificación
             ┌────────────────┼───────────────┐
             v                v               v
      ┌──────────┐     ┌──────────┐     ┌──────────┐
      | Cliente 1 |     | Cliente 2 |     | Cliente 3 |
      └──────────┘     └──────────┘     └──────────┘

```
## Diagrama de flujo
```text
+-------------------+          +----------------------+
|   Javascript      |          |     Quarkus Server  |
| (browser client)  |          |   WebSocket endpoint |
+---------┬---------+          +-----------┬----------+
          |                                |
          | new WebSocket(url)             |
          |------------------------------->|
          |                                |
          |        101 Switching           |
          |<-------------------------------|
          |                                |
          |   socket.send("hola")          |
          |------------------------------->|
          |                                |
          |   socket.onmessage(event)      |
          |<-------------------------------|
          |                                |
```

