package com.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class JPConversorMoneda {

    // URL base de la API, se reemplaza con la API Key obtenida de la página de Exchange Rate
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/f4f11044139bf4c806cc7213/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("Debes seleccionar una opción de conversión:");
            System.out.println("1. Convertir USD a EUR");
            System.out.println("2. Convertir EUR a USD");
            System.out.println("3. Convertir USD a COP");
            System.out.println("4. Convertir COP a USD");
            System.out.println("5. Convertir USD a CAD");
            System.out.println("6. Convertir CAD a USD");
            System.out.println("7. Convertir EUR a COP");
            System.out.println("8. Convertir COP a EUR");
            System.out.println("9. Salir");
            System.out.print("Debes elegir una opción del 1 al 9): ");

            int opcion = scanner.nextInt();

            if (opcion == 9) {
                System.out.println("Gracias por usar el conversor de monedas de Alura Latam. ¡Hasta pronto!");
                break;
            }

            String monedaBase;
            String monedaDestino;

            switch (opcion) {
                case 1 -> {
                    monedaBase = "USD";
                    monedaDestino = "EUR";
                }
                case 2 -> {
                    monedaBase = "EUR";
                    monedaDestino = "USD";
                }
                case 3 -> {
                    monedaBase = "USD";
                    monedaDestino = "COP";
                }
                case 4 -> {
                    monedaBase = "COP";
                    monedaDestino = "USD";
                }
                case 5 -> {
                    monedaBase = "USD";
                    monedaDestino = "CAD";
                }
                case 6 -> {
                    monedaBase = "CAD";
                    monedaDestino = "USD";
                }
                case 7 -> {
                    monedaBase = "EUR";
                    monedaDestino = "COP";
                }
                case 8 -> {
                    monedaBase = "COP";
                    monedaDestino = "EUR";
                }
                default -> {
                    System.out.println("La opción que ingresaste no es válida. Por favor, intenta de nuevo.");
                    continue;
                }
            }

            System.out.print("Ingresa el monto de dinero a convertir: ");
            double cantidad = scanner.nextDouble();

            try {
                convertirMoneda(monedaBase, monedaDestino, cantidad);
            } catch (IOException | InterruptedException e) {
                System.err.println("Error al intentar realizar la conversión: " + e.getMessage());
            }

            System.out.println("¿Deseas realizar otra conversión? (s/n): ");
            String respuesta = scanner.next();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
                System.out.println("Gracias por usar el conversor de monedas de Alura Latam. ¡Hasta pronto!");
            }
        }
    }



    public static void convertirMoneda(String monedaBase, String monedaDestino, double cantidad)
            throws IOException, InterruptedException {

        // Construir la URL de la API con la moneda base
        String url = API_URL.replace("TU_API_KEY", "TU_API_KEY_AQUI") + monedaBase;

        // Crear cliente HTTP y solicitud
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Realizar solicitud HTTP
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        if (respuesta.statusCode() == 200) {
            // Parsear respuesta JSON
            JsonObject json = JsonParser.parseString(respuesta.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            if (rates.has(monedaDestino)) {
                double tasa = rates.get(monedaDestino).getAsDouble();
                double resultado = cantidad * tasa;

                System.out.printf("Tasa de cambio: 1 %s = %.2f %s%n", monedaBase, tasa, monedaDestino);
                System.out.printf("Los %.2f %s equivalen a %.2f %s.%n", cantidad, monedaBase, resultado, monedaDestino);
            } else {
                System.out.println("La moneda de destino no es válida.");
            }
        } else {
            System.out.println("Error al conectar con la API. Código de estado: " + respuesta.statusCode());
        }
    }
}

