# 🧱 Sistema de Monitoreo de Logs con Quarkus, Loki, Promtail y Grafana

Este proyecto implementa una arquitectura ligera y open-source para recolectar, almacenar y visualizar logs generados por una aplicación **Quarkus (Java 17)** utilizando **Loki**, **Promtail** y **Grafana**.

---

## 🚀 Objetivos del Proyecto

- Centralizar los logs generados por la aplicación Quarkus.
- Enviarlos de forma segura y eficiente usando Promtail.
- Almacenarlos en Loki utilizando un backend optimizado.
- Visualizarlos de forma amigable mediante Grafana.
- Permitir debugging, análisis y observabilidad completa del sistema.

---

# 🏗 Arquitectura General

El sistema está compuesto por cuatro servicios principales:

1. **Quarkus** – Genera los logs de la aplicación.
2. **Promtail** – Agente que lee los logs y los envía a Loki.
3. **Loki** – Backend donde se almacenan y consultan los logs.
4. **Grafana** – Herramienta de observabilidad para visualizar los logs.

---

## 🔗 Diagrama de Arquitectura (Flujo de Datos)

```mermaid
flowchart LR
    A[Quarkus App<br/>Java 17] -->|Genera logs| B[Promtail]
    B -->|Push logs| C[Loki]
    C -->|LogQL Queries| D[Grafana]
    D -->|Dashboards| User((Usuario))
```
![img_1.png](img_1.png)

```mermaid
graph TD

subgraph Cliente
    User[Usuario]
end

subgraph MonitoringStack[Stack de Monitoreo]
    G[Grafana]
    L[Loki]
    P[Promtail]
end

subgraph AppLayer[Capa de Aplicación]
    Q[Quarkus App]
end

User --> G

Q -->|Genera logs| P
P -->|Envía logs| L
G -->|Consultas LogQL| L

```

![img.png](img.png)