package salarioliquido.imposto.irrf.basecalculo;

import java.math.BigDecimal;

public interface BaseCalculo {
    BigDecimal calcular(BigDecimal salarioBruto);
}
