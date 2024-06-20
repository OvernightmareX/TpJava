package org.example.autres;

public class Thermometre {
    private static final double ABSOLUTE_ZERO = 273.15;
    private static final int FAHRENHEIT_ADD_TEMP = 32;
    private static final float FAHRENHEIT_TO_KELVIN_COEFF = 5/9f;
    private static final float KELVIN_TO_FAHRENHEIT_COEFF = 9/5f;

    private double temperatureKelvin;

    public Thermometre() {
    }

    public Thermometre(double temperature, UniteTemperature unite) {
        switch (unite){
            case KEVLIN -> setTemperatureKelvin(temperature);
            case CELCIUS -> setTemperatureCelcius(temperature);
            case FAHRENHEIT -> setTemperatureFahrenheit(temperature);
        }
    }

    public void setTemperatureFahrenheit(double temperature){
        this.temperatureKelvin = (temperature - FAHRENHEIT_ADD_TEMP) * FAHRENHEIT_TO_KELVIN_COEFF + ABSOLUTE_ZERO;
    }

    public void setTemperatureCelcius(double temperature){
        this.temperatureKelvin = temperature + ABSOLUTE_ZERO;
    }

    public void setTemperatureKelvin(double temperature){
        this.temperatureKelvin = temperature;
    }

    public double getTemperatureKelvin() {
        return temperatureKelvin;
    }

    public double getTemperatureCelcius() {
        return temperatureKelvin - ABSOLUTE_ZERO;
    }

    public double getTemperatureFahrenheit() {
        return (temperatureKelvin - ABSOLUTE_ZERO) * KELVIN_TO_FAHRENHEIT_COEFF + FAHRENHEIT_ADD_TEMP;
    }
}
