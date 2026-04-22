package ar.edu.unahur.obj2.w2j;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.w2j.Contenidos.Contenido;
import ar.edu.unahur.obj2.w2j.Planes.IPlan;
import ar.edu.unahur.obj2.w2j.Planes.PlanBasico;

public class Usuario {
    private IPlan plan = new PlanBasico(10);
    private List<Contenido> contenidos = new ArrayList<>();

    public Double costoMensual() { return plan.costoPlan(this); }

    public IPlan getPlan() { return plan; }

    public void setPlan(IPlan plan) { this.plan = plan; }

    public void verContenido(Contenido contenido) { contenidos.add(contenido); }

    public List<Contenido> getContendios() { return new ArrayList<>(contenidos); }

    public void limpiarContenidos() { contenidos.clear(); }
}