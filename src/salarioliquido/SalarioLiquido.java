package salarioliquido;

import salarioliquido.imposto.Imposto;
import salarioliquido.imposto.inss.INSS;
import salarioliquido.imposto.irrf.IRRF;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class SalarioLiquido {
    private final BigDecimal salarioBruto;
    private BigDecimal salarioLiquido;
    private final List<Imposto> impostos;

    public SalarioLiquido(double salarioBruto) {
        this.salarioBruto = BigDecimal.valueOf(salarioBruto);
        this.salarioLiquido = this.salarioBruto;
        this.impostos = List.of(new INSS(), new IRRF());
    }

    public BigDecimal getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioLiquido(BigDecimal salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public BigDecimal getSalarioLiquido() {
        impostos.forEach(imposto -> {
            BigDecimal desconto = imposto.descontar(this.salarioLiquido);
            setSalarioLiquido(this.salarioLiquido.subtract(desconto));
        });

        return this.salarioLiquido.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static void main(String[] args) {
        SalarioLiquido liquido = new SalarioLiquido(1500);

        System.out.println(liquido.getSalarioLiquido());
    }
}
