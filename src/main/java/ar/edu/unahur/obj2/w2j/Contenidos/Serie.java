package ar.edu.unahur.obj2.w2j.Contenidos;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Contenido {
    private List<Temporada> teporadas = new ArrayList<>();

    public Serie(String titulo, Double costoBase) { super(titulo, costoBase); }

    public Serie(String titulo, Double costoBase, List<Temporada> teporadas) {
        super(titulo, costoBase);
        this.teporadas = teporadas;
    }

    public void agregarTemporada(Temporada temporada) { teporadas.add(temporada); }

    @Override
    public Double doCosto() {
        return teporadas.stream().mapToDouble(t -> t.costo()).average().orElse(0.0);
    }
}