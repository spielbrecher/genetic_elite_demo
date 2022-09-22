public class Chromosome {
    double x;
    double y;
    double health;    
    
    void countHealth(){
        health = (double) 1 / (1 + Math.pow(x,2) + Math.pow(y,2));
    }
    
}
