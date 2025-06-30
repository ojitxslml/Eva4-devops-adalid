package com.eva4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testActualizarPeso() {
        Usuario usuario = new Usuario("Ana", 60.0);
        usuario.actualizarPeso(62.5);
        assertEquals(62.5, usuario.getPeso(), 0.001);
    }

    @Test
    public void testActualizarPesoConValorNegativo() {
        Usuario usuario = new Usuario("Pedro", 70.0);
        usuario.actualizarPeso(-5.0);
        assertEquals(-5.0, usuario.getPeso(), 0.001); // Verifica que el método acepta cualquier número
    }

    @Test
    public void testActualizarPesoConMismoValor() {
        Usuario usuario = new Usuario("Laura", 55.0);
        usuario.actualizarPeso(55.0);
        assertEquals(55.0, usuario.getPeso(), 0.001);
    }
}
