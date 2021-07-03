package salarioliquido.imposto.irrf.basecalculo;

import java.math.BigDecimal;

public class CalculadorBaseCalculo implements BaseCalculo {
    @Override
    public BigDecimal calcular(BigDecimal salarioBruto) {
        BaseCalculoEnum baseCalculo = BaseCalculoEnum.getBaseCalculo(salarioBruto);

        if (baseCalculo.equals(BaseCalculoEnum.PRIMEIRA)) {
            return BigDecimal.valueOf(baseCalculo.getAliquota());
        }

        return salarioBruto
                .multiply(BigDecimal.valueOf(baseCalculo.getAliquota()))
                .subtract(BigDecimal.valueOf(baseCalculo.getDeducao()));
    }
}
