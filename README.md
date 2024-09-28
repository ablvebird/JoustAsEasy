# Joust As Easy - La Aplicación Tutorial con Hibernate & H2 preferida de GRRM 🐉

### Descripción General
Este proyecto se originó como parte de una práctica para la asignatura de **Acceso a Datos** del **Ciclo Superior de Desarrollo de Aplicaciones Multiplataforma (DAM)**.

El objetivo de esta aplicación es servir como **guía y referencia** para construir aplicaciones utilizando **Hibernate** y una base de datos relacional, en este caso, **H2**. El proyecto demuestra conceptos clave como ORM (Mapeo Objeto-Relacional), relaciones entre entidades y operaciones CRUD, todo esto utilizando **Gradle** como herramienta de construcción. Adicionalmente, sirve como válvula de escape temporal para mi obsesión con ASOIAF.

### Estado del Proyecto
La aplicación se encuentra actualmente **en construcción**. El funcionamiento y estructura básica de Hibernate están implementados, pero ahora mismo es poco más que un entorno de muestra y testeo.

### Hoja de Ruta
- **GUI**: Se añadirá una interfaz gráfica de usuario para mejorar la interacción y proporcionar una forma más intuitiva de gestionar los personajes, casas y duelos.
- **Ampliación del Sistema de Duelos**: Ahora mismo el sistema es estúpidamente simple porque la intención era meramente mostrar el funcionamiento de Hibernate, pero la intención es desarrollarlo en algo más interesante.

### Características Clave
- **Navegación basada en consola**: La implementación actual cuenta con un sistema de menú en consola que permite al usuario navegar entre los servicios de **Casa**, **Personaje** y **Duelos**.
- **Gestión de Entidades**: Administra entidades de `House`, `Character`, y `Bout` con operaciones CRUD completas (Crear, Leer, Actualizar, Eliminar) utilizando Hibernate.
- **Base de Datos H2 almacenada en disco**: La aplicación utiliza **H2** como base de datos almacenada en ~/data/joustAsEasyDb para facilitar el desarrollo y la simplicidad en las pruebas.

### Documentación
Puedes encontrar comentarios detallados en formato Javadoc en el código fuente para guiarte a través de las clases, métodos y su propósito:
Para más detalles sobre el funcionamiento del sistema e instrucciones para extender el código, consulta la documentación en las respectivas clases.
