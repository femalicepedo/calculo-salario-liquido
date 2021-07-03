package salarioliquido.imposto;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal descontar(BigDecimal salarioBruto);
}
