# RetoJava
Reto realizado en base al Seniority de Junior ": Implementar los diferentes endpoints para cumplir las funcionalidades: F1, F2, F3"
=======

# Tecnologías Utilizadas

- **Java 21** (OpenLogic 21.0.7.6)
- **Spring Boot**
- **Gradle** 8.7 (versión local)
- **PostgreSQL** como base de datos relacional
- **Lombok** (para simplificar el código Java)

# Funcionalidades
# F1: Generación de CRUDS (Crear, editar, actualizar y eliminar registros - Entidades: Cliente, Cuenta y Movimiento).
# Los nombres de los endpoints a generar son:
    • /cuentas
    • /clientes
    • /movimientos
    
# F2: Registro de movimientos: al registrar un movimiento en la cuenta se debe tener en cuenta lo siguiente:
    • Para un movimiento se pueden tener valores positivos o negativos.
    • Al realizar un movimiento se debe actualizar el saldo disponible.
    • Se debe llevar el registro de las transacciones realizadas
    
# F3: Registro de movimientos: Al realizar un movimiento el cual no cuente con saldo, debe alertar mediante el siguiente mensaje “Saldo no disponible”
    • Defina, según su expertise, la mejor manera de capturar y mostrar el error.

# F5: Pruebas unitarias: Implementar 1 prueba unitaria para la entidad de dominio Cliente.

# F6: Pruebas de Integración: Implementar 1 prueba de integración.

## Estructura del proyecto

```
────src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───tcs
    │   │           └───reto
    │   │               │   Application.java
    │   │               │
    │   │               ├───bindings
    │   │               │       ApiResponse.java
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
    │       │   BaseDatos.sql
    │       │   test.json
    │       │
    │       ├───static
    │       │       .gitkeep
    │       │
    │       └───templates
    │               .gitkeep
    │
    └───test
        └───java
            └───com
                └───tcs
                    └───reto
                        └───services
                            └───impl
                                    ClienteIntegrationTest.java
                                    ClienteTest.java
```
