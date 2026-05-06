package ar.edu.unahur.obj2.w2j.Planes;

import ar.edu.unahur.obj2.w2j.Usuario;

public interface PlanStrategy { 
    Double costoPlan(Usuario usuario); 
    void actualizarCosto(double valor);
}