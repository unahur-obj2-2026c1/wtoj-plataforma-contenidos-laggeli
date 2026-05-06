package ar.edu.unahur.obj2.w2j.Contenidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ContenidoTest {
    @Test
    void dadoUnaSerie_cuandoNoTieneEpisodiosAun_entoncesSeCalculaElCostoBase() {
        Serie serie = new Serie("You", 10.0);
        
        assertEquals(10.0, serie.costo());
    }

    @Test
    void dadoUnaSerie_cuandoFinalizaLaPrimerTemporada_entoncesSeCalculaElCostoTotal() {
        Episodio ep1 = new Episodio("Piloto", 1, 6.0);
        Episodio ep2 = new Episodio("El último buen tipo de Nueva York", 2, 12.0);
        Episodio ep3 = new Episodio("Quizás", 3, 15.0);
        ep3.setCosto(18.0);
        Temporada temp1 = new Temporada(1);
        Serie serie = new Serie("You", 10.0);

        temp1.agregarEpisodio(ep1);
        temp1.agregarEpisodio(ep2);
        temp1.agregarEpisodio(ep3);
        serie.agregarTemporada(temp1);

        assertEquals(22.0, serie.costo());
    }

    @Test
    void dadoUnDocumental_cuandoElIDRAAumentaElValor_entoncesSeActualizaElCosto() {
        Documental documental = new Documental("Las cintas de Ted Bundy", 3.0);
        IDRA idra = IDRA.getInstance();

        idra.setValor(idra.getValor() + 1.5);

        assertEquals(2.0, documental.doCosto());
    }

    @Test
    void dadoUnaPelicula_cuandoSeGrabaNoGeneraGastosExtras_entoncesSeCalculaElCosto() {
        Pelicula pelicula = new Pelicula("El diablo viste a la moda", 5.0, "David Frankel");

        assertEquals(0.0, pelicula.doCosto());
    }

    @Test
    void dadoUnContenido_cuandoApenasIniciaSeteaUnCosto_entoncesSeCalculaElCostoBase() {
        Contenido serie = new Serie("You", 10.0);
        serie.setCostoBase(50.5);

        assertEquals(50.5, serie.getCostoBase());
    }
}