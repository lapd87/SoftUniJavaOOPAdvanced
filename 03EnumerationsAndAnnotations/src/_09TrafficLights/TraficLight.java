package _09TrafficLights;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 22:15 ч.
 */
public class TraficLight {

    private Enum light;

    public TraficLight(String light) {
        this.light = Enum.valueOf(Lights.class,
                light.toUpperCase());
    }

    public void changeLight() {
        int lightIndex = light.ordinal();

        lightIndex++;
        if (lightIndex >= 3) {
            lightIndex = 0;
        }

        light = Lights.values()[lightIndex];
    }

    @Override
    public String toString() {
        return light.name();
    }
}