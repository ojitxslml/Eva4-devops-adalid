package com.eva4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsuarioTestRegresion {

    @Test
    public void testActualizarPeso() {
        Usuario usuario = new Usuario("Test", 70.0);
        usuario.actualizarPeso(75.0);
        assertEquals(75.0, usuario.getPeso(), 0.001, "El peso debe actualizarse correctamente");
    }

    @Test
    public void testNombreGuardado() {
        Usuario usuario = new Usuario("Carlos", 65.0);
        assertEquals("Carlos", usuario.getNombre());
    }
}
