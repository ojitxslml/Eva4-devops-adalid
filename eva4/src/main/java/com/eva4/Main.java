package com.eva4;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Juan", 70.5);
        usuario.mostrarInformacion();

        usuario.actualizarPeso(72.0); // Esto no funcionará como se espera (tiene un error a propósito)
        usuario.mostrarInformacion();
    }
}
