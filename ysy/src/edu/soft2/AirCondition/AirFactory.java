package edu.soft2.AirCondition;

/**
 * 产品接口
 */
public abstract class AirFactory {

  static Air getInstance(String airName){
     Air air = null;
     if (airName.equals("Gree")) {
        air = new GreeAir();
     }else if(airName.equals("Haier")){
        air = new HaierAir();
     }else if(airName.equals("Midea")){
        air = new MideaAir();
     }
     return air;
  }

   public abstract Air ProductAir();
}
