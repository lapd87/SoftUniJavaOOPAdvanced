package _01BoatRacingSimulator.enumeration;

public enum EngineType {
    JET(5), STERNDRIVE(7);

    private int horsepowerMultiplier;

    EngineType(int horsepowerMultiplier) {
        this.horsepowerMultiplier = horsepowerMultiplier;
    }

    public int getHorsepowerMultiplier() {
        return horsepowerMultiplier;
    }
}
