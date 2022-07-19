public class Pakuri{

    private String species;
    private int attack;
    private int defense;
    private int speed;

    //string species method
    public Pakuri(String  species){
        this.species = species;
        attack = (species.length()*7)+9;
        defense = (species.length()*5)+17;
        speed = (species.length()*6)+13;

    }
    //set species method
    public void setSpecies(String s){
        species = s;

    }
    //get species method
    public String getSpecies(){
        return species;
    }
    //get attack method
    public int getAttack(){
        return attack;
    }
    //get defense method
    public int getDefense(){
        return defense;
    }
    //get speed method
    public int getSpeed(){
        return speed;
    }
    //set attack method
    public void setAttack(int newAttack){
        attack = newAttack;

    }
    //evolve method
    public void evolve(){
        attack *= 2;
        defense *= 4;
        speed *= 3;
    }
    //compare to method
    public int compareTo(Object x){
        Pakuri target = (Pakuri)x;
        return this.species.compareTo(target.species);
    }
}
