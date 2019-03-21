package Locations;

import interfaces.Classifiable;
import interfaces.Visitable;

public class Church extends Node implements Visitable, Classifiable {

    private String openingHour = new String();
    private String closingHour = new String();
    private String rank = new String();
    private boolean visited = false;

    public Church(String name){
        super.setName(name);
        Visitable.super.defaultSchedule();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setOpeningHour(String hour){
        this.openingHour = hour;
    }

    @Override
    public void setClosingHour(String closingHour) {
        this.closingHour = closingHour;
    }

    @Override
    public void setRank(String rank){
        this.rank = rank;
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getOpeningHour(){
        return openingHour;
    }

    public String getClosingHour() {
        return closingHour;
    }

    @Override
    public String getRank(){
        return rank;
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public boolean isVisited (Node n) {return super.isVisited(n);}
}
