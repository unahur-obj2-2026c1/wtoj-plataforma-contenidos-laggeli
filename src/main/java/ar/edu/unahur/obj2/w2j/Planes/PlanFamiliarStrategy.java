package ar.edu.unahur.obj2.w2j.Planes;

public class PlanFamiliarStrategy extends PlanLimitadoStrategy {
    private Double descuento = 0.15;

    public PlanFamiliarStrategy(Integer limite) { super(limite); }

    @Override
    protected Double aplicarAjuste(Double total) { return super.aplicarAjuste(total) * (1 - this.descuento); }
}