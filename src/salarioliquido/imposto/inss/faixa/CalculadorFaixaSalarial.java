package salarioliquido.imposto.inss.faixa;

import java.math.BigDecimal;

public class CalculadorFaixaSalarial implements FaixaSalarial {

    public CalculadorFaixaSalarial() {
    }

    @Override
    public BigDecimal calcular(BigDecimal salarioBruto) {
        FaixaEnum faixaEnum = FaixaEnum.getFaixa(salarioBruto);

        if (faixaEnum.equals(FaixaEnum.TETO)) {
            return BigDecimal.valueOf(faixaEnum.getAliquota());
        }

        return salarioBruto
                .multiply(BigDecimal.valueOf(faixaEnum.getAliquota()))
                .subtract(BigDecimal.valueOf(faixaEnum.getDeducao()));
    }
}
