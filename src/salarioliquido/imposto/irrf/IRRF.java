package salarioliquido.imposto.irrf;

import salarioliquido.imposto.Imposto;
import salarioliquido.imposto.irrf.basecalculo.BaseCalculo;
import salarioliquido.imposto.irrf.basecalculo.CalculadorBaseCalculo;

import java.math.BigDecimal;

public class IRRF implements Imposto {

    private final BaseCalculo baseCalculo;

    public IRRF() {
        this.baseCalculo = new CalculadorBaseCalculo();
    }

    @Override
    public BigDecimal descontar(BigDecimal salarioBruto) {
        return baseCalculo.calcular(salarioBruto);
    }
}
