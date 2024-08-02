# README - Backend del Proyecto

## Descripción del Proyecto

Este proyecto es el backend utilizado para la gestión de clientes dada por la prueba técnica de GML Software para aplicar al puesto de Sofware Full Stack Developer.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para desarrollar aplicaciones de backend con soporte para microservicios.
- **Spring Data JPA**: Para la gestión de datos y la interacción con la base de datos.
- **Maven**: Sistema de gestión de proyectos y dependencias.
- **Oracle**: Sistemas de gestión de bases de datos.

## Funcionalidades Principales

1. **Gestión de Clientes**:
   - **CRUD**: Crear, leer, actualizar y eliminar clientes.
   - **Consultas**: Filtrado y búsqueda de clientes por varios criterios.
   - **Validaciones**: Validación de datos de entrada y salida.

2. **Seguridad**:
   - Por temas de tiempo y alcance no se implementó ningún tipo de sistema de autenticación y/o autorización.

3. **Servicios**:
   - **Microservicios**: Desarrollados utilizando Spring Boot para manejar diferentes aspectos del dominio del problema.
   - **API REST**: Exposición de endpoints RESTful para interacción con el frontend.

4. **Persistencia de Datos**:
   - **ORM**: Utilización de JPA para mapear objetos Java a la base de datos.
   - **Consultas Personalizadas**: Implementación de consultas específicas usando Query Criteria.

## Instalación y Configuración

1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio](https://github.com/wnicolas/gml-back.git
1. **Scripts de base de datos Oracle**:
   ```bash
   --Ejecutar desde un usuario con permisos de creación de usuarios
   alter session set "_ORACLE_SCRIPT"=true;
   CREATE TABLESPACE gml_data
   DATAFILE 'user_data.dbf'
   SIZE 50M
   AUTOEXTEND ON
   NEXT 10M MAXSIZE UNLIMITED
   EXTENT MANAGEMENT LOCAL;
   
   
   CREATE USER gml IDENTIFIED BY gml_password
   DEFAULT TABLESPACE gml_data
   TEMPORARY TABLESPACE temp
   QUOTA UNLIMITED ON gml_data;
   
   GRANT CONNECT, RESOURCE TO gml;
   GRANT CREATE SESSION TO gml;
   GRANT CREATE TABLE TO gml;
   GRANT CREATE SEQUENCE TO gml;
   GRANT CREATE VIEW TO gml;
   GRANT CREATE PROCEDURE TO gml;
   GRANT CREATE SYNONYM TO gml;
   GRANT CREATE TRIGGER TO gml;
   -- Crear la tabla CLIENTS
   CREATE TABLE CLIENTS (
       Shared_Key VARCHAR2(50) PRIMARY KEY,
       Business_Id VARCHAR2(50) NOT NULL,
       Email VARCHAR2(100),
       Phone VARCHAR2(20),
       Date_Added DATE DEFAULT SYSDATE
   );
   
   
   -- Insertar datos en la tabla CLIENTS
   INSERT INTO CLIENTS (Shared_Key, Business_Id, Email, Phone, Date_Added) VALUES ('SK001', 'BID001', 'user1@example.com', '123-456-7890', TO_DATE('2024-01-01', 'YYYY-MM-DD'));
   INSERT INTO CLIENTS (Shared_Key, Business_Id, Email, Phone, Date_Added) VALUES ('SK002', 'BID002', 'user2@example.com', '098-765-4321', TO_DATE('2024-02-01', 'YYYY-MM-DD'));
   INSERT INTO CLIENTS (Shared_Key, Business_Id, Email, Phone, Date_Added) VALUES ('SK003', 'BID003', 'user3@example.com', '555-123-4567', TO_DATE('2024-03-01', 'YYYY-MM-DD'));
   INSERT INTO CLIENTS (Shared_Key, Business_Id, Email, Phone, Date_Added) VALUES ('SK004', 'BID004', 'user4@example.com', '555-987-6543', TO_DATE('2024-04-01', 'YYYY-MM-DD'));
   INSERT INTO CLIENTS (Shared_Key, Business_Id, Email, Phone, Date_Added) VALUES ('SK005', 'BID005', 'user5@example.com', '555-555-5555', TO_DATE('2024-05-01', 'YYYY-MM-DD'));
   
   SELECT * FROM CLIENTS;

