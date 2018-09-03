package _005SecurityDoor.models;

import _005SecurityDoor.contracts.SecurityUI;

public class KeyCardCheck extends BaseSecurityCheck {

    public KeyCardCheck(SecurityUI securityUI) {
        super(securityUI);
    }

    @Override
    public boolean validateUser() {
        String code = super.getSecurityUI().requestKeyCard();

        return isValid(code);
    }

    private boolean isValid(String code) {
        return true;
    }
}
