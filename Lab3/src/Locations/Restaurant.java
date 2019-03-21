package Locations;

import interfaces.Classifiable;

public class Restaurant extends Node implements Classifiable {

    String rank = new String();

    public Restaurant(String name){
        super.setName(name);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setRank(String rank){
        this.rank=rank;
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
    public String getRank(){
        return this.rank;
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public boolean isVisited (Node n) {return super.isVisited(n);}
}
