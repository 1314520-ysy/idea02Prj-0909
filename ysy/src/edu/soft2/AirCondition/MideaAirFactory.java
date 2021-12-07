package edu.soft2.AirCondition;

public class MideaAirFactory extends AirFactory{

    public Air ProductAir() {
        System.out.println("美的工厂开工制造");
        return new MideaAir();
    }
}
