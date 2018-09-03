package _09TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 22:23 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine()
                .split("\\s+");

        List<TraficLight> traficLights = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            TraficLight traficLight = new TraficLight(input[i]);
            traficLights.add(traficLight);
        }

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (TraficLight traficLight : traficLights) {
                traficLight.changeLight();
                stringBuilder.append(traficLight)
                        .append(" ");
            }

            System.out.println(stringBuilder.toString().trim());
        }
    }
}