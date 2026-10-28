# Automatización del carrito de compras — SauceDemo
Pruebas web automatizadas con Java, Serenity BDD, Cucumber y el patrón Screenplay.
## Escenarios implementados
Se ejecutan dos escenarios etiquetados con `@reto`:
1. Compra exitosa: iniciar sesión, agregar un producto, validar el carrito, completar los datos, comprobar el subtotal y confirmar la compra.
2. Eliminar un producto: agregarlo al carrito, eliminarlo y verificar que el carrito quede vacío.
   Aplicación: https://www.saucedemo.com/
## Tecnologías
- Java 21.
- Gradle Wrapper 8.5.
- Serenity BDD 4.2.22.
- Cucumber 7.20.1.
- Selenium 4.27.0.
- Jenkins.
## Requisitos
- JDK 21 configurado en JAVA_HOME.
- Google Chrome instalado.
- Conexión a internet para descargar dependencias y acceder a SauceDemo.
## Ejecución local
Desde PowerShell, en la carpeta principal del proyecto:
```powershell
.\gradlew.bat clean test aggregate
```
Para ejecutar sin abrir la ventana del navegador:
```powershell
.\gradlew.bat clean test aggregate --no-daemon -Dheadless.mode=true
```
El runner `SerenityLoginRunner` selecciona los escenarios de compra y eliminación.
## Estructura
- `src/main/java`: tareas, interacciones, preguntas y elementos de interfaz.
- `src/test/java`: runner y definiciones de pasos.
- `src/test/resources/features`: escenarios Gherkin.
- `src/test/resources/serenity.conf`: configuración del navegador.
- `Jenkinsfile`: pipeline de integración continua.
- `evidencias`: capturas de ejecución y resultados.
## Reportes
Después de ejecutar las pruebas, abrir:
`target/site/serenity/index.html`
Los resultados JUnit se generan en:
`build/test-results/test/`
## Integración continua con Jenkins
El pipeline está preparado para un agente Windows con Chrome instalado y una herramienta JDK llamada `Java21`.
Etapas:
1. Verificar Java y Gradle.
2. Ejecutar las pruebas web.
3. Publicar resultados JUnit y archivar los reportes de Serenity.
   Jenkins consulta el repositorio aproximadamente cada cinco minutos y ejecuta el pipeline cuando detecta cambios. Jenkins y el equipo deben permanecer encendidos.
   Para consultar el reporte archivado, descargar los artefactos como ZIP, extraerlos y abrir `target/site/serenity/index.html`.
## Evidencias
Las capturas de Jenkins, resultados y reportes están en la carpeta `evidencias`.
Jenkins se ejecuta localmente; su dirección localhost no es accesible desde otros equipos.