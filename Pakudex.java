import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

//class for pakudex
public class Pakudex {
    private int critters;
    private int pakudex;
    private int capacity;
    private int size = 0;
    private Pakuri[] pakuri;

    //get pakuri method
    public Pakuri[] getPakuri() {
        return pakuri;
    }
    //pakudex method
    public Pakudex() {
        capacity = 20;
        pakuri = new Pakuri[capacity];
    }
    //pakudex int method
    public Pakudex(int capacity) {
        this.capacity = capacity;
        pakuri = new Pakuri[capacity];
    }
    //get size method
    public int getSize() {
        return size;
    }
    //get capacity method
    public int getCapacity() {
        return capacity;
    }

    //get species array method
    public String[] getSpeciesArray() {
        String[] data = new String[size];
        for (int i = 0; i < size; i++) {
            data[i] = pakuri[i].getSpecies();
        }
        if (data.length == 0) {
            return null;
        }
        return data;
    }

    public int[] getStats(String species) {
        int[] data = new int[3];
        for (int i = 0; i < size; i++) {
            if (pakuri[i].getSpecies().equals(species)) {
                data[0] = pakuri[i].getAttack();
                data[1] = pakuri[i].getDefense();
                data[2] = pakuri[i].getSpeed();
                return data;
            }

        }
        return null;
    }

    public void sortPakuri() {
        ArrayList<String> listofspecies = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            listofspecies.add(pakuri[i].getSpecies());
        }
        Collections.sort(listofspecies);
        for (int i = 0; i < size; i++) {
           pakuri[i].setSpecies(listofspecies.get(i));
        }
    }




    public boolean addPakuri(String species) {
        for (int i = 0; i < size; i++) {
            if (pakuri[i].getSpecies().equals(species)) {
                return false;
            }
            if (size == capacity) {
                return false;
            }
        }
        Pakuri a = new Pakuri(species);
        pakuri[size] = a;
        size += 1;
        return true;
    }

    public boolean evolveSpecies(String species) {
        for (int i = 0; i < size; i++) {
            if (pakuri[i].getSpecies().equals(species)) {
                pakuri[i].evolve();
                return true;
            }


        }
        return false;
    }
}
