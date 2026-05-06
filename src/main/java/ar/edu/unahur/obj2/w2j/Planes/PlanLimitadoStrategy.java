package ar.edu.unahur.obj2.w2j.Planes;

import java.util.List;

import ar.edu.unahur.obj2.w2j.Contenidos.Contenido;
import ar.edu.unahur.obj2.w2j.Usuario;

public abstract class PlanLimitadoStrategy implements PlanStrategy {
    protected Integer limite;
    protected static Double costoBase = 5.0;
    
    public PlanLimitadoStrategy(Integer limite) { this.limite = limite; }

    public static Double getCostoBase() { return costoBase; }

    public static void setCostoBase(Double costoBase) { PlanLimitadoStrategy.costoBase = costoBase; }

    @Override
    public Double costoPlan(Usuario usuario) {
        List<Contenido> contenidos = usuario.getContenidos();
        Double excedentes = contenidos.stream().skip(limite).mapToDouble(Contenido::costo).sum();
        Double total = costoBase + excedentes;
        return aplicarAjuste(total);
    }

    protected Double aplicarAjuste(Double total) { return total; }

    @Override
    public void actualizarCosto(double valor) { costoBase = valor; }
}