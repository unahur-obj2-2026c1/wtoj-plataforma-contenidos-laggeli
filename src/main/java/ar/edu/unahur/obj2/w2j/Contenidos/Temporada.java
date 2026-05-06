package ar.edu.unahur.obj2.w2j.Contenidos;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private final Integer numero;
    private List<Episodio> episodios = new ArrayList<>();

    public Temporada(Integer numero) { this.numero = numero; }

    public void agregarEpisodio(Episodio episodio) { episodios.add(episodio); }

    public Double costo() { return episodios.stream().mapToDouble(e -> e.getCosto()).average().orElse(0.0); }
}