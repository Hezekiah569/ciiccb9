public class Task16 {
    public static void main(String[] args) {
        boolean feedTheGorilla = true;
        Gorilla gorillaTester = new Gorilla();
        gorillaTester.groom();
        gorillaTester.pet();
        System.out.println("Is it time to feed the gorilla? " + gorillaTester.feed(feedTheGorilla));
    }
}

interface Animal {
    boolean feed(boolean timeToEat);
    void groom();
    void pet();
}

class Gorilla implements Animal {
    public boolean feed(boolean timeToEat) {
            return timeToEat;
    }
    public void groom() {
        System.out.println("Lather, rinse, repeat.");
    }
    public void pet() {
        System.out.println("Pet at your own risk.");
    }
}
