package salarioliquido.imposto.inss;

import salarioliquido.imposto.Imposto;
import salarioliquido.imposto.inss.faixa.CalculadorFaixaSalarial;
import salarioliquido.imposto.inss.faixa.FaixaSalarial;

import java.math.BigDecimal;

public class INSS implements Imposto {

    private final FaixaSalarial faixaSalarial;

    public INSS() {
        this.faixaSalarial = new CalculadorFaixaSalarial();
    }

    @Override
    public BigDecimal descontar(BigDecimal salarioBruto) {
        return faixaSalarial.calcular(salarioBruto);
    }
}
