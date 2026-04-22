package ar.edu.unahur.obj2.w2j.Contenidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ContenidoTest {
    @Test
    void dadoUnDocumentalSeCalculaElCosto() {
        Contenido documental1 = new Documental("La vida salvaje", 10.0);
        assertEquals(10.5, documental1.costo());
    }
}