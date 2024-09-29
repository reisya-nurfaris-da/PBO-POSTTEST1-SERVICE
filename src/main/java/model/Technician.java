package model;

public class Technician {
    private static int nextId = 1;
    private final int id;
    private String name;

    public Technician(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + name ;
    }
}