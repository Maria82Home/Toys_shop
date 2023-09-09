public abstract class Toy {
    int id;
    int weight;
    String name;

    public Toy(int id, int weight, String name) {
        this.id = id;
        this.weight = weight;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  String.format("id:%d, название:%s, вес:%d",this.id, this.name,this.weight);
    }

    public String getInfo(){
        return id+". "+name;
    }

}
