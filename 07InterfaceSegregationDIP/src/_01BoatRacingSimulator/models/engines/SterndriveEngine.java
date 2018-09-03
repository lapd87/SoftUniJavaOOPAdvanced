package _01BoatRacingSimulator.models.engines;

public class SterndriveEngine extends BaseEngine {

    public SterndriveEngine(String model, int horsepower,
                            int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    protected String getEngineType() {
        return this.getClass().getSimpleName()
                .replaceAll("Engine$", "")
                .toUpperCase();
    }
}
