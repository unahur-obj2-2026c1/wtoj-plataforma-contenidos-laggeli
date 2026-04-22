package ar.edu.unahur.obj2.w2j.Planes;

import ar.edu.unahur.obj2.w2j.Usuario;

public class PlanFamiliar extends PlanBasico {
    public PlanFamiliar(Integer limite) { super(limite); }

    @Override
    public Double costoPlan(Usuario usuario) {
        Double costoBasico = super.costoPlan(usuario);
        return costoBasico * 0.85;
    }
}