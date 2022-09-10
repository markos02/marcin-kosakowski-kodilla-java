package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {

        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {

        double sum = 0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }

        double result = sum / temperatures.getTemperatures().size();

        return result;
    }

    public double calculateMedianTemperature() {

        List<Double> temperatureList = new ArrayList<>(temperatures.getTemperatures().values());

        Collections.sort(temperatureList);
        double result;

        if (temperatureList.size() % 2 == 0) {
            double upper = temperatureList.get(temperatureList.size() / 2);
            double lower = temperatureList.get(temperatureList.size() / 2 - 1);
            result = (upper + lower) / 2.0;
        } else {
            result = temperatureList.get(temperatureList.size() / 2);
        }

        return result;

    }
}
