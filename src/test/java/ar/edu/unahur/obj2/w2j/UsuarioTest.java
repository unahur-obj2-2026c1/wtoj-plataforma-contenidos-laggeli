package ar.edu.unahur.obj2.w2j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.w2j.Contenidos.Documental;
import ar.edu.unahur.obj2.w2j.Contenidos.Pelicula;
import ar.edu.unahur.obj2.w2j.Contenidos.Serie;
import ar.edu.unahur.obj2.w2j.Planes.PlanBasicoStrategy;
import ar.edu.unahur.obj2.w2j.Planes.PlanLimitadoStrategy;
import ar.edu.unahur.obj2.w2j.Planes.PlanPremiumStrategy;

public class UsuarioTest {
    @Test
    void dadoUnUsuarioConPlanBasico_cuandoNoExcedeElLimite_entoncesPagaSoloCostoFijo() {
        Usuario user = new Usuario(new PlanBasicoStrategy(5));

        user.verContenido(new Pelicula("Esperando la carroza", 8.0, "Alejandro Doria"));
        user.verContenido(new Serie("Stranger Things", 15.5));

        assertEquals(5.0, user.costoMensual());
    }

    @Test
    void dadoUnUsuarioConPlanBasico_cuandoExcedeElLimite_entoncesPagaCostoFijoYExtra() {
        Usuario user = new Usuario(new PlanBasicoStrategy(5));

        user.verContenido(new Pelicula("Esperando la carroza", 8.0, "Alejandro Doria"));
        user.verContenido(new Serie("Stranger Things", 15.5));
        user.verContenido(new Documental("Las cintas de Ted Bundy", 3.0));
        user.verContenido(new Pelicula("El diablo viste a la moda", 10.0, "David Frankel"));
        user.verContenido(new Documental("Las cintas de Ted Bundy", 3.0));
        user.verContenido(new Serie("You", 25.0));
        
        assertEquals(30.0, user.costoMensual());
    }

    @Test
    void dadoUnUsuario_cuandoSeUneAPlataformaLeDanPlanBasico_entoncesSeCambiaDePlan() {
        PlanLimitadoStrategy planAsignado = new PlanPremiumStrategy(10);
        Usuario user = new Usuario(new PlanBasicoStrategy(5));
        user.setPlan(planAsignado);
        
        assertEquals(planAsignado, user.getPlan());
    }
}