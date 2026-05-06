package ar.edu.unahur.obj2.w2j;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.w2j.Contenidos.Pelicula;
import ar.edu.unahur.obj2.w2j.Planes.PlanBasicoStrategy;
import ar.edu.unahur.obj2.w2j.Planes.PlanFamiliarStrategy;
import ar.edu.unahur.obj2.w2j.Planes.PlanLimitadoStrategy;
import ar.edu.unahur.obj2.w2j.Planes.PlanPremiumStrategy;

public class PlataformaTest {

    @Test
    void dadoUnaPlataforma_cuandoSeUnenTresUsuarios_entoncesSeCalculaLaFacturacion() {
        Plataforma plataforma = Plataforma.getInstance();
        Usuario user1 = new Usuario(new PlanPremiumStrategy(10));
        Usuario user2 = new Usuario(new PlanPremiumStrategy(10));
        Usuario user3 = new Usuario(new PlanBasicoStrategy(5));

        plataforma.agregarUsuario(user1);
        plataforma.agregarUsuario(user2);
        plataforma.agregarUsuario(user3);

        assertEquals(15.0, plataforma.facturacionMensual());
    }

    private Double costoOriginal;

    @Test
    void dadoUnaPlataforma_cuandoComienzaElMes_entoncesSeLimpianLosContenidos() {
        Plataforma plataforma = Plataforma.getInstance();
        Usuario user1 = new Usuario(new PlanPremiumStrategy(10));

        plataforma.agregarUsuario(user1);
        user1.verContenido(new Pelicula("El diablo viste a la moda", 5.0, "David Frankel"));
        plataforma.limpiarContenidos();

        assertTrue(user1.getContenidos().isEmpty());
    }

    @BeforeEach
    void setUp() {
        costoOriginal = PlanLimitadoStrategy.getCostoBase();
    }

    @AfterEach
    void tearDown() {
        PlanLimitadoStrategy.setCostoBase(costoOriginal);
    }

    @Test
    void dadoUnPlanPremium_cuandoAumenta_entoncesSeActualizaElPrecioEnPlataforma() {
        Plataforma plataforma = Plataforma.getInstance();
        PlanLimitadoStrategy planPremium = new PlanPremiumStrategy(15);
        Usuario user = new Usuario(planPremium);

        plataforma.actualizarCosto(planPremium, 15.0);

        assertEquals(15.0, planPremium.costoPlan(user));
    }

    @Test
    void dadoUnPlanFamiliar_cuandoHayRebaja_entoncesSeActualizaElPrecioEnPlataforma() {
        Plataforma plataforma = Plataforma.getInstance();
        PlanLimitadoStrategy planFamiliar = new PlanFamiliarStrategy(10);
        Usuario user = new Usuario(planFamiliar);

        plataforma.actualizarCosto(planFamiliar, 3.0);

        assertEquals(2.55, planFamiliar.costoPlan(user));
    }
}