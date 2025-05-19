# RetoJava
Reto realizado en base al Seniority de Junior ": Implementar los diferentes endpoints para cumplir las funcionalidades: F1, F2, F3"
=======

# Tecnologías Utilizadas

- **Java 21** (OpenLogic 21.0.7.6)
- **Spring Boot**
- **Gradle** 8.7 (versión local)
- **PostgreSQL** como base de datos relacional
- **Lombok** (para simplificar el código Java)

## Estructura del proyecto

```
└───src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───tcs
    │   │           └───reto
    │   │               │   Application.java
    │   │               │
    │   │               ├───bindings
    │   │               │       ApiResponse.java
    │   │               │       ContactEntry.java
    │   │               │
    │   │               ├───controllers
    │   │               │       ClienteController.java
    │   │               │       CuentaController.java
    │   │               │       MovimientoController.java
    │   │               │
    │   │               ├───dto
    │   │               │       .gitkeep
    │   │               │       ContactDto.java
    │   │               │
    │   │               ├───entities
    │   │               │       Cliente.java
    │   │               │       Cuenta.java
    │   │               │       Movimiento.java
    │   │               │       Persona.java
    │   │               │
    │   │               ├───enums
    │   │               │       ContactTypeEnum.java
    │   │               │       TypeMovementEnum.java
    │   │               │
    │   │               ├───repositories
    │   │               │       ClienteRepository.java
    │   │               │       CuentaRepository.java
    │   │               │       MovimientoRepository.java
    │   │               │       PersonaRepository.java
    │   │               │
    │   │               └───services
    │   │                   │   ClienteService.java
    │   │                   │   CuentaService.java
    │   │                   │   MovimientoService.java
    │   │                   │   PersonaService.java
    │   │                   │
    │   │                   └───impl
    │   │                           ClienteServiceImpl.java
    │   │                           CuentaServiceImpl.java
    │   │                           MovimientoServiceImpl.java
    │   │
    │   └───resources
    │       │   application.properties
    │       │   BDD.sql
    │       │   datosPrueba.sql
```
