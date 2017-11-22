package sample;

import java.math.BigDecimal;

public class Multiply extends Operator {
    @Override
    public BigDecimal eval(BigDecimal lh, BigDecimal rh) {
        return lh.multiply(rh);
    }
}
