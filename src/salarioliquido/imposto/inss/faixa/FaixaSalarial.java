package salarioliquido.imposto.inss.faixa;

import java.math.BigDecimal;

public interface FaixaSalarial {
    BigDecimal calcular(BigDecimal salarioBruto);
}
