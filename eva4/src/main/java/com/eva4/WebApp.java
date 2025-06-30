package com.eva4;

import static spark.Spark.*;

public class WebApp {
    private static Usuario usuario = new Usuario("", 0);

    public static void main(String[] args) {
        port(8080); // Puerto donde correrá la aplicación
        
        // Configurar rutas
        get("/", (req, res) -> {
            return "<html>" +
                   "<head><title>Sistema de Usuario</title></head>" +
                   "<body>" +
                   "<h1>Sistema de Usuario</h1>" +
                   "<form action='/registrar' method='post'>" +
                   "Nombre: <input type='text' name='nombre'><br>" +
                   "Peso: <input type='number' step='0.1' name='peso'><br>" +
                   "<button type='submit'>Registrar</button>" +
                   "</form>" +
                   "</body></html>";
        });

        post("/registrar", (req, res) -> {
            String nombre = req.queryParams("nombre");
            double peso = Double.parseDouble(req.queryParams("peso"));
            usuario = new Usuario(nombre, peso);
            res.redirect("/perfil");
            return null;
        });

        get("/perfil", (req, res) -> {
            return "<html>" +
                   "<body>" +
                   "<h1>Perfil de " + usuario.getNombre() + "</h1>" +
                   "<p>Peso actual: " + usuario.getPeso() + " kg</p>" +
                   "<form action='/actualizar' method='post'>" +
                   "Nuevo peso: <input type='number' step='0.1' name='nuevoPeso'><br>" +
                   "<button type='submit'>Actualizar</button>" +
                   "</form>" +
                   "</body></html>";
        });

        post("/actualizar", (req, res) -> {
            double nuevoPeso = Double.parseDouble(req.queryParams("nuevoPeso"));
            usuario.actualizarPeso(nuevoPeso);
            res.redirect("/perfil");
            return null;
        });
    }
}