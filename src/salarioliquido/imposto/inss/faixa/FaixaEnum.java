package salarioliquido.imposto.inss.faixa;

import java.math.BigDecimal;
import java.util.Arrays;

public enum FaixaEnum {
    PRIMEIRA(0, 1100.00, 0.075, 0),
    SEGUNDA(1100.01, 2203.48, 0.09, 16.50),
    TERCEIRA(2203.49, 3305.22, 0.12, 82.60),
    QUARTA(3305.23, 6433.57, 0.14, 148.71),
    TETO(6433.58, Double.MAX_VALUE, 751.99, 0);

    FaixaEnum(double min, double max, double aliquota, double deduzir) {
        this.min = min;
        this.max = max;
        this.aliquota = aliquota;
        this.deduzir = deduzir;
    }

    private final double min;
    private final double max;
    private final double aliquota;
    private final double deduzir;

    public double getDeduzir() {
        return deduzir;
    }

    public double getAliquota() {
        return aliquota;
    }

    private boolean between(double salarioBruto) {
        return salarioBruto <= this.max &&
                salarioBruto >= this.min;
    }

    public static FaixaEnum getFaixa(BigDecimal salarioBruto) {
        return Arrays.stream(values())
                .filter(faixa -> faixa.between(salarioBruto.doubleValue()))
                .findFirst()
                .orElseThrow();
    }
}
