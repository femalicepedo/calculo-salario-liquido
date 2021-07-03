package salarioliquido.imposto.irrf.basecalculo;

import java.math.BigDecimal;
import java.util.Arrays;

public enum BaseCalculoEnum {
    PRIMEIRA(0, 1903.98, 0, 0),
    SEGUNDA(1903.99, 2826.65, 0.075, 142.80),
    TERCEIRA(2826.66, 3751.05, 0.15, 354.80),
    QUARTA(3751.06, 4664.68, 0.225, 636.13),
    TETO(4664.68, Double.MAX_VALUE, 0.275, 869.36);

    BaseCalculoEnum(double min, double max, double aliquota, double deducao) {
        this.min = min;
        this.max = max;
        this.aliquota = aliquota;
        this.deducao = deducao;
    }

    private final double min;
    private final double max;
    private final double aliquota;
    private final double deducao;

    public double getAliquota() {
        return aliquota;
    }

    public double getDeducao() {
        return deducao;
    }

    private boolean between(double salarioBruto) {
        return salarioBruto <= this.max &&
                salarioBruto >= this.min;
    }

    public static BaseCalculoEnum getBaseCalculo(BigDecimal salarioBruto) {
        return Arrays.stream(values())
                .filter(baseCalculo -> baseCalculo.between(salarioBruto.doubleValue()))
                .findFirst()
                .orElseThrow();
    }
}
