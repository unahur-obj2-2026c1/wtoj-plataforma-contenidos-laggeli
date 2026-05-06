package ar.edu.unahur.obj2.w2j;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.w2j.Planes.PlanLimitadoStrategy;

public class Plataforma {
    private static final Plataforma instance = new Plataforma();
    private List<Usuario> usuarios = new ArrayList<>();
    private Plataforma() {};

    public static Plataforma getInstance() { return instance; }

    public Double facturacionMensual() { return usuarios.stream().mapToDouble(u -> u.costoMensual()).sum(); }

    public void limpiarContenidos() { usuarios.stream().forEach(Usuario::limpiarContenidos); }

    public void agregarUsuario(Usuario usuario) { usuarios.add(usuario); }

    public void actualizarCosto(PlanLimitadoStrategy plan, Double valor) { plan.actualizarCosto(valor); }
}