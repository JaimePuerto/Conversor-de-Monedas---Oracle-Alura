# Conversor-de-Monedas---Oracle-Alura
Challenge de Alura Latam Backend - Conversor de Monedas

# Conversor de Monedas

Este es un proyecto de conversión de monedas desarrollado en **Java** utilizando el IDE **IntelliJ IDEA**. El programa consume la API pública [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio actualizadas y permite realizar conversiones entre las monedas más importantes.

---

## Características

- **Menú interactivo**: El usuario puede seleccionar entre diferentes opciones de conversión de moneda.
- **Soporte para 8 tipos de cambio principales**:
  - USD a EUR y EUR a USD
  - USD a COP y COP a USD
  - USD a CAD y CAD a USD
  - EUR a COP y COP a EUR
- **Conversiones inversas** incluidas.
- Opción para realizar múltiples conversiones o salir del programa.
- Consumo de la API de ExchangeRate-API para tasas de cambio en tiempo real.

---

## Requisitos Previos

1. **Java JDK 11 o superior** (se utilizó JDK 23 en este desarrollo).
2. **IntelliJ IDEA** (u otro IDE compatible con Java).
3. **Maven** configurado para gestionar las dependencias.
4. **Clave de la API** de [ExchangeRate-API](https://www.exchangerate-api.com/) (gratuita con registro).

---

## Configuración del Proyecto

### Paso 1: Crear el Proyecto en IntelliJ IDEA

1. Abre IntelliJ IDEA y selecciona **File > New > Project**.
2. Selecciona **Maven** como tipo de proyecto.
3. Configura el JDK (versión 11 o superior).
4. Asigna un nombre al proyecto (por ejemplo, `ConversorDeMonedas`).
5. Finaliza la configuración inicial.

### Paso 2: Configurar el archivo `pom.xml`

Agrega la dependencia para la biblioteca Gson en el archivo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>
```

Luego, actualiza Maven para descargar las dependencias.

### Paso 3: Reemplazar la Clave de la API

En el archivo principal, reemplaza el texto `TU_API_KEY` con tu clave de [ExchangeRate-API](https://www.exchangerate-api.com/).

```java
private static final String API_URL = "https://v6.exchangerate-api.com/v6/TU_API_KEY/latest/";
```

---

## Ejecución del Proyecto

1. Ejecuta la clase principal `ConversorDeMonedas` desde IntelliJ IDEA.
2. Sigue las instrucciones del menú interactivo para realizar conversiones.
3. Elige entre realizar una nueva conversión o salir del programa después de cada operación.

---

## Ejemplo de Uso

### Menú Principal

```
=== MENÚ PRINCIPAL ===
Selecciona una opción de conversión:
1. USD a EUR
2. EUR a USD
3. USD a COP
4. COP a USD
5. USD a CAD
6. CAD a USD
7. EUR a COP
8. COP a EUR
9. Salir
Elige una opción (1-9):
```

### Ejemplo de Conversión

Si seleccionas la opción 1 (USD a EUR):

```
Ingresa la cantidad a convertir: 100
Tasa de cambio: 1 USD = 0.85 EUR
Resultado: 100 USD = 85.00 EUR
¿Deseas realizar otra conversión? (s/n):
```

---

## Archivos Principales

1. **`ConversorDeMonedas.java`**: Contiene toda la lógica del programa, incluyendo:
   - Menú interactivo.
   - Consumo de la API de ExchangeRate-API.
   - Cálculos de conversión.
2. **`pom.xml`**: Archivo de configuración de Maven con la dependencia de Gson.

---

## Tecnologías Utilizadas

- **Java 23**: Lenguaje de programación principal.
- **Maven**: Gestión de dependencias.
- **Gson**: Biblioteca para procesar JSON.
- **ExchangeRate-API**: Fuente de tasas de cambio en tiempo real.

---

## Próximas Mejoras

- Agregar más monedas a las opciones de conversión.
- Implementar una interfaz gráfica (GUI) para hacer el programa más amigable.
- Guardar el historial de conversiones en un archivo local o en una base de datos.

---

## Contribución

Si deseas contribuir a este proyecto:
1. Realiza un fork del repositorio.
2. Crea una nueva rama para tus cambios.
3. Envía un pull request con una descripción detallada de tus contribuciones.

---



