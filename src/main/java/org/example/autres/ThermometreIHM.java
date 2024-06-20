package org.example.autres;

public class ThermometreIHM {

    public static void displayTemperatureKelvin(Thermometre t){
        System.out.println("Le thermomètre affiche " + t.getTemperatureKelvin() + " K°");
    }

    public static void displayTemperatureCelsius(Thermometre t){
        System.out.println("Le thermomètre affiche " + t.getTemperatureCelcius() + " C°");
    }

    public static void displayTemperatureFahrenheit(Thermometre t){
        System.out.println("Le thermomètre affiche " + t.getTemperatureFahrenheit() + " F°");
    }

    public static void displayAllTemperature(Thermometre t){
        System.out.println("Le thermomètre affiche : " +
                t.getTemperatureKelvin() + " K° soit " +
                t.getTemperatureCelcius() + " C° soit " +
                t.getTemperatureFahrenheit() + " F°");
    }
}
