package ar.edu.unahur.obj2.w2j;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private static final Plataforma instance = new Plataforma();
    private List<Usuario> usuarios = new ArrayList<>();
    private Plataforma() {};

    public static Plataforma getIntance() { return instance; }

    public Double facturacionMensual() { return usuarios.stream().mapToDouble(u -> u.costoMensual()).sum(); }

    public void limpiarContenidos() { usuarios.stream().forEach(u -> u.limpiarContenidos()); }

    public void agregarUsuario(Usuario usuario) { usuarios.add(usuario); }
}