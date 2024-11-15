# AsistenciaDeTrabajadores
## Como funciona el proyecto:

### Requisitos:

1. Java instalado localmente.
2. MySQL instalado localmente.
3. GIT instalado para clonar repo.

### Pasos para ejecutar:

1.  Clonar repositorio en maquina local y abrir directorio.

    ```
    git clone https://github.com/Lorena0127/AsistenciaDeTrabajadores
    cd AsistenciaDeTrabajadores
    code .
    ```

2.  Desde la consola de MySQL o desde workbench crear la base de datos.
    ```
    create database asistencia;
    ```
3.  Desde la consola de MySQL o desde workbench crear la tabla users.
    ```
    CREATE TABLE asistencia.users (
     id VARCHAR(255) NOT NULL PRIMARY KEY, -- Primary Key
     name VARCHAR(255),
     username VARCHAR(255) UNIQUE,
     password VARCHAR(255),
     role VARCHAR(255),
     avatar VARCHAR(255),
     gender VARCHAR(255),
     city VARCHAR(255),
     state VARCHAR(255),
     country VARCHAR(255),
     age INT
    );
    ```
4.  Modificar las credenciales para la conexión a la base de datos en el archivo DB.java

    ```
    String url = "jdbc:mysql://localhost:3306/asistencia";
    String usuario = "root";
    String contraseña = "root1234";
    ```

5.  Ejecutar archivo Main.java e interactuar con la consola, en próximas versiones estará disponible la GUI.

### Consideraciones

- Si intentas agregar un username duplicato se lanzará un error.
- Si escribes un número diferente a 1 o 2 en la sección de genero se lanzará un error, en próximas versiones ambos errores tendran su respectivo manejador de errores y válidaciones.

## Division del trabajo

Diana Lorena Salinas Ortegón: Planteamiento del problema y Justificación.

Juan Diego Garzón Becerra: Objetivo especifico.

Danna Sofia Rojas Flórez: Objetivos.

## Planteamiento del problema

En muchas organizaciones y empresas, la gestión de las novedades y el registro de la asistencia de trabajadores, contratistas y otros visitantes a las oficinas no se realiza de manera organizada. La falta de un control registrado y actualizado sobre estos aspectos puede llevar a problemas significativos, como el incumplimiento de horarios, dificultades en la gestión de permisos, y falta de control sobre el ingreso y salida de equipos externos.
Actualmente, muchos sistemas, como los formatos en Excel, minutas, Access, etc., son inadecuados para manejar el registro de asistencia durante los picos de actividad laboral o para revisar si se llegara a presentar incumplimiento o la falta de elementos. Estos métodos pueden resultar en retrasos en la entrada de datos, errores en el registro, y en general, una carga administrativa considerable. Estos problemas se agravan especialmente en horarios de alta demanda, lo que afecta negativamente la precisión del registro y la eficiencia del proceso.

## Justificación

La falta de un sistema de control de asistencia eficiente y actualizado en las organizaciones y empresas pueden llegar a generar varias molestias en temas administrativos que afectan el rendimiento no solo del establecimiento sino también de los trabajadores como: las recepcionistas y el vigilante que deben estar atentos a otro tipo de controles, siendo esto una afectación general. La organización inadecuada de las novedades, los retrasos en el registro de asistencia, y la falta de control sobre la entrada y salida de equipos externos son desafíos significativos que requieren atención inmediata.
Se pretende desarrollar y superar las limitaciones de los sistemas actuales, evitando atrasos y errores durante las horas pico, brindar claridad para mejorar en los registros minuciosos, novedades del personal, gestión y control en los equipos.

## Objetivos

Aumentar la transparencia y confianza entre los empleados y la empresa, ofreciendo acceso en tiempo real a los registros de entrada y salida, así como al cálculo de horas trabajadas y extras.

Proteger los derechos laborales de los empleados, asegurando que las horas extras, recargos nocturnos, y descansos se calculen y respeten correctamente, promoviendo un ambiente laboral justo y equitativo.

Garantizar el cumplimiento de la legislación laboral colombiana en cuanto a la reducción de jornada, horas extras y recargos de los empleados, minimizando el riesgo de sanciones legales para la empresa.

Optimizar la gestión de recursos humanos mediante la automatización del registro y control de la jornada laboral, mejorando la eficiencia y reduciendo el error humano en el cálculo de nómina y horas extras.

Facilitar la toma de decisiones en cuanto a la planificación de horarios, asignación de turnos y gestión de permisos, utilizando datos precisos y actualizados en tiempo real.

Mejorar la productividad y puntualidad del personal al ofrecer una plataforma digital que permita un control riguroso de las horas trabajadas, incentivando la eficiencia y el cumplimiento de horarios.

---

### Objetivo especifico

Desarrollar una aplicación capaz de cumplir con los requerimientos definidos por el equipo técnico en pro de lograr los objetivos generales, dicha aplicación tendrá lugar dentro del entorno de JAVA, tanto la interfaz gráfica como todas las funcionalidades internas del sistema, adicionalmente tendremos persistencia de datos gracias a una base de datos relacional proporcionada por otro equipo especializado, teniendo como requerimiento principal documentar detalladamente los procesos que se lleven a cabo para lograr la conclusión del proyecto.

## Referencias

Ministerio del Trabajo de Colombia. (2017). Leyes y Decretos-Ley.
Recuperado de https://www.mintrabajo.gov.co/normatividad/leyes-y-decretos-ley/leyes

Sistema Integral de Información SISPRO.
https://www.minsalud.gov.co/proteccionsocial/Paginas/SistemaIntegraldeInformaci%C3%B3nSISPRO.aspx#:~:text=El%20Sistema%20Integral%20de%20Informaci%C3%B3n,y%20en%20los%20procesos%20esenciales

Código Sustantivo del Trabajo.
https://www.alcaldiabogota.gov.co/sisjur/normas/Norma1.jsp?i=33104
