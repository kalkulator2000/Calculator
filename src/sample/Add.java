package sample;

import java.math.BigDecimal;

public class Add extends Operator {

    @Override
    public BigDecimal eval(BigDecimal lh, BigDecimal rh) {
        return lh.add(rh);
    }


}

