package ar.edu.unahur.obj2.w2j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.w2j.Planes.PlanFamiliar;

public class UsuarioTest {
    @Test
    void calculoDeCostoDeUsuarioConPlanBasico() {
        Usuario user = new Usuario();
        assertEquals(5.0, user.costoMensual());
    }

    @Test
    void calculoDeCostoDeUsuarioConPlanFamiliar() {
        Usuario user2 = new Usuario();
        user2.setPlan(new PlanFamiliar(15));
        assertEquals(4.25, user2.costoMensual());
    }
}
