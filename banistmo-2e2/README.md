# Proyecto de Automatización E2E - Banistmo

Proyecto de automatización de pruebas end-to-end para la aplicación web de Banistmo utilizando Serenity BDD, Cucumber y Selenium WebDriver.

## Tecnologías Utilizadas

- **Java 17**
- **Gradle** - Gestión de dependencias y construcción
- **Serenity BDD 3.3.0** - Framework de automatización
- **Cucumber** - BDD (Behavior Driven Development)
- **Selenium WebDriver** - Automatización de navegadores
- **JUnit 4** - Framework de pruebas
- **Chrome** - Navegador para ejecución de pruebas

## Estructura del Proyecto

```
src/
├── main/java/
│   ├── task/           # Clases de pasos de automatización
│   │   └── BanistmoSteps.java
│   └── ui/             # Page Objects y localizadores
│       ├── BanistmoHomePage.java
│       ├── AprenderEsFacilPage.java
│       └── FatcaPage.java
└── test/
    ├── java/
    │   ├── runners/    # Runners de Cucumber
    │   │   └── RunnerBanistmo.java
    │   ├── stepdefinitions/ # Definiciones de pasos
    │   │   └── BanistmoStepsDef.java
    │   └── hooks/      # Hooks de configuración
    └── resources/
        ├── features/   # Archivos .feature de Cucumber
        │   └── fatca-certificado.feature
        ├── serenity.conf    # Configuración de Serenity
        └── serenity.properties # Propiedades adicionales
```

## Configuración

### Prerrequisitos
- Java 17 o superior
- Chrome instalado
- Gradle (incluido wrapper)

### Instalación
1. Descargar e instalar Java SE Development Kit 17.0.9
[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2. Descargar el binario de Gradle 
[Gradle 7.5](https://gradle.org/next-steps/?version=7.5&format=bin)
3. Descomprimir y crear una carpeta llamada Gradle en 'Archivos de programa'
4. Setear la variable de entorno JAVA_HOME = 'C:\Program Files\Java\jdk-17'
5. Setear la variable de entorno de sistema GRADLE_HOME = 'C:\Program Files\Gradle\gradle-7.5\gradle-7.5'
6. Editar la variable del sistema 'PATH' y agregar %GRADLE_HOME%\bin y %JAVA_HOME%\bin
7. Para poder navegar por la solución de manera cómoda se recomienda usar IntelliJ IDEA
8. Instalar los plugins para IntelliJ: Cucumber for JAVA, Gherkin, Lombok y SonarQube for IDE.
9. Clonar el repositorio o descomprimir el .zip
10. Ejecutar: `./gradlew build`

## Ejecución de Pruebas

### Ejecutar todas las pruebas
```bash
./gradlew test
```

### Ejecutar pruebas específicas
```bash
./gradlew test --tests "RunnerBanistmo"
```

### Generar reportes
```bash
./gradlew test aggregate
```

Los reportes se generan en: `target/site/serenity/index.html`

## Escenarios de Prueba

### Feature: Generación de Certificado FATCA
- **Escenario**: Navegar por las opciones de Banistmo para descargar certificado
- **Pasos**:
  1. Acceder a la página principal de Banistmo
  2. Navegar a "Aprender es fácil"
  3. Seleccionar "Descubre más" del apartado "Legales"
  4. Seleccionar "Descubre más" del apartado "Autocertificación fiscal FATCA & CRS"
  5. Descargar el PDF "PJ-Autocertificación unificado - Fatca y CRS.pdf"
- **Validaciones**: Verificar que el PDF se abre correctamente en el navegador

## Configuración del Navegador

El proyecto está configurado para usar Chrome con las siguientes opciones:
- Modo no headless (ventana visible)
- Descarga automática del driver
- Configuraciones de seguridad optimizadas
- Remote allow origins habilitado

## Estructura de Clases

### Page Objects
- `BanistmoHomePage` - Elementos de la página principal de Banistmo
- `AprenderEsFacilPage` - Elementos de la página Aprender es Fácil
- `FatcaPage` - Elementos de la página FATCA & CRS

### Steps
- `BanistmoSteps` - Métodos de automatización para navegación y acciones en Banistmo

### Step Definitions
- `BanistmoStepsDef` - Definiciones de pasos Gherkin para los escenarios de Banistmo

## Reportes

Serenity BDD genera reportes detallados que incluyen:
- Screenshots automáticos
- Logs de ejecución
- Métricas de cobertura
- Resultados por escenario
