package _01BoatRacingSimulator.models.engines;

public class JetEngine extends BaseEngine {

    public JetEngine(String model, int horsepower,
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
