package ar.edu.unahur.obj2.w2j;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.w2j.Contenidos.Contenido;
import ar.edu.unahur.obj2.w2j.Planes.PlanStrategy;

public class Usuario {
    private PlanStrategy plan;
    private List<Contenido> contenidos = new ArrayList<>();

    public Usuario(PlanStrategy plan) { this.plan = plan; }

    public Double costoMensual() { return plan.costoPlan(this); }

    public PlanStrategy getPlan() { return plan; }

    public void setPlan(PlanStrategy plan) { this.plan = plan; }

    public void verContenido(Contenido contenido) { contenidos.add(contenido); }

    public List<Contenido> getContenidos() { return this.contenidos; }

    public void limpiarContenidos() { contenidos.clear(); }
}