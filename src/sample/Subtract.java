package sample;

import java.math.BigDecimal;

public class Subtract extends Operator {
    @Override
    public BigDecimal eval(BigDecimal lh, BigDecimal rh) {
        return lh.subtract(rh);
    }
}
