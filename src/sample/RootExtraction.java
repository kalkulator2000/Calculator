package sample;

import java.math.BigDecimal;

public class RootExtraction extends SingleOperator {

    @Override
    public BigDecimal eval(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0))).setScale(8, BigDecimal.ROUND_HALF_UP);
    }

}
