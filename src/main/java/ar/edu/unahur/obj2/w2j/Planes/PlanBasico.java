package ar.edu.unahur.obj2.w2j.Planes;

import java.util.List;

import ar.edu.unahur.obj2.w2j.Contenidos.Contenido;
import ar.edu.unahur.obj2.w2j.Usuario;

public class PlanBasico implements IPlan {
    private Integer limite;

    public PlanBasico(Integer limite) { this.limite = limite; }

    @Override
    public Double costoPlan(Usuario usuario) {
        Double costoBase = 5.0;
        List<Contenido> contenidos = usuario.getContendios();
        if (limite >= contenidos.size()) { return costoBase; } 
        else {
            List<Contenido> excedentes = contenidos.subList(limite, contenidos.size());
            return costoBase + excedentes.stream().mapToDouble(c -> c.costo()).sum();
        }
    }
}