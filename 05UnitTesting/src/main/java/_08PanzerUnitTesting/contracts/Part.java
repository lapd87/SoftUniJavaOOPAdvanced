package _08PanzerUnitTesting.contracts;

import java.math.BigDecimal;

public interface Part extends Modelable {
    double getWeight();

    BigDecimal getPrice();
}