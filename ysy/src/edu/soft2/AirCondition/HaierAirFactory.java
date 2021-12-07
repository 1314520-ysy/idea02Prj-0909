package edu.soft2.AirCondition;

public class HaierAirFactory extends AirFactory{

    public Air ProductAir() {
        System.out.println("海尔工厂开工制造");
        return new HaierAir();
    }
}
