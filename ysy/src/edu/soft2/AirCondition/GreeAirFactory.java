package edu.soft2.AirCondition;

public class GreeAirFactory extends AirFactory{
    @Override
    public Air ProductAir() {
        System.out.println("格力工厂开工制造");
        return new GreeAir();
    }
}
