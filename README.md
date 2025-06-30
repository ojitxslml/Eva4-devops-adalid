# Sistema de Usuario - SparkJava

Este programa es una aplicación web desarrollada en Java usando SparkJava. Permite registrar un usuario, guardar su peso y actualizarlo, mostrando la información en una interfaz web sencilla.

## ¿Qué hace el programa?
- Permite registrar un usuario con nombre y peso.
- Muestra el perfil del usuario y su peso actual.
- Permite actualizar el peso del usuario desde la web.

## ¿Cómo ejecutarlo?

1. **Compilar el proyecto:**
   
   Desde la raíz del repositorio ejecuta:
   ```sh
   mvn -f eva4/pom.xml clean compile
   ```

2. **Ejecutar la aplicación web:**
   
   ```sh
   mvn -f eva4/pom.xml exec:java
   ```
   Luego abre tu navegador en [http://localhost:8080](http://localhost:8080)

3. **Ejecutar las pruebas:**
   
   ```sh
   mvn -f eva4/pom.xml test
   ```

## Pruebas de rendimiento
Puedes usar el archivo `jmeter_prueba_basica.jmx` con Apache JMeter para evaluar el tiempo de respuesta bajo carga.

---

**Autor:** Desarrollo evaluación DevOps Sence por Juan Pablo Urra

