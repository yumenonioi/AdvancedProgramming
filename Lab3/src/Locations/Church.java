package Locations;

import interfaces.Classifiable;
import interfaces.Visitable;

public class Church extends Node implements Visitable, Classifiable {

    public Church(String name){
        super.setName(name);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

//    @Override
//    public void setOpeningHour(String hour){
//        this.openingHour = hour;
//    }

    //    @Override
//    public void setRank(String rank){
//        this.rank = rank;
//    }

    @Override
    public void setAdress(String adress) {
        super.setAdress(adress);
    }

    @Override
    public String getName() {
        return super.getName();
    }

//    @Override
//    public String getOpeningHour(){
//        return openingHour;
//    }

    //    @Override
//    public String getRank(){
//        return super.getRank();
//    }

    @Override
    public String getAdress() {
        return super.getAdress();
    }
}
