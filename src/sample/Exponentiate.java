package sample;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exponentiate extends SingleOperator {
    @Override
    public BigDecimal eval(BigDecimal lh) {
        return lh.pow(2);
    }
}
