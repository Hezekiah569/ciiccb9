

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world.");

        Plant plantOne = new Plant();
        plantOne.name = "Tanglad";

        System.out.println(plantOne.name);
        

        
    }    
}

class Plant {
    int branch;
    String name;
    int leaves;

    void setBranch(int leaves) {
        this.leaves = leaves;
    }

    int getBranch() {
        return branch;
    }
}
