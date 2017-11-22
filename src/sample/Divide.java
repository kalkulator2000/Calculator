package sample;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Divide extends Operator{

    @Override
    public BigDecimal eval(BigDecimal lh, BigDecimal rh) {
        if( rh.equals(new BigDecimal (0)) )throw new ArithmeticException();
        return lh.divide(rh,8, RoundingMode.HALF_UP);
    }
}