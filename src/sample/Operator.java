package sample;

import java.math.BigDecimal;

public abstract class Operator {
    public abstract BigDecimal eval(BigDecimal lh, BigDecimal rh);
}
