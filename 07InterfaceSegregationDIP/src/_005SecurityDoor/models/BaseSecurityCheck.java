package _005SecurityDoor.models;

import _005SecurityDoor.contracts.SecurityCheck;
import _005SecurityDoor.contracts.SecurityUI;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 14:14 ч.
 */
public abstract class BaseSecurityCheck implements SecurityCheck {

    private SecurityUI securityUI;

    protected BaseSecurityCheck(SecurityUI securityUI) {
        this.securityUI = securityUI;
    }

    public SecurityUI getSecurityUI() {
        return securityUI;
    }
}