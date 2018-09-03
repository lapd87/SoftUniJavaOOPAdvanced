package _005SecurityDoor.models;

import _005SecurityDoor.contracts.SecurityUI;

public class PinCodeCheck extends BaseSecurityCheck {

    public PinCodeCheck(SecurityUI securityUI) {
        super(securityUI);
    }

    @Override
    public boolean validateUser() {
        int pin = super.getSecurityUI().requestPinCode();

        return isValid(pin);
    }

    private boolean isValid(int pin) {
        return true;
    }
}
