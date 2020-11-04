package diningphilosophers;

public class ChopStick {
    // Le nombre total de baguettes
    private static int stickCount = 0;
    // Le numéro de chaque baguette
    private final int myNumber;
    // Est-ce que ma baguette est libre ?
    private boolean iAmFree = true;

    public ChopStick() {
        // Chaque baguette est numérotée 
        myNumber = ++stickCount;
    }

    synchronized public void take() throws InterruptedException {
        while (!iAmFree) {
            wait();
        }
        iAmFree = false;
        System.out.println("Le stick " + myNumber + " a été pris");
    }

    synchronized public void release() {
        System.out.println("Le stick " + myNumber + " a été posé");
        iAmFree = true;
        notifyAll(); 
    }
    
    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
