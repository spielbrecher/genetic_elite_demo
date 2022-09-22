
import java.util.ArrayList;
import java.util.Comparator;

public class NewMain {
    
    java.util.List<Chromosome> chromosomes;
    
    NewMain(){
        init();
        for(int i=0; i<50; i++){
            mark();
            selection();
            recombination();
        }
        mark();
        selection();
        Chromosome best = chromosomes.get(0);
        System.out.println(best.x+" "+best.y+" "+best.health);
    }
    
    void init(){
        chromosomes = new java.util.ArrayList<>();
        java.util.Random r = new java.util.Random();
        for(int i=0; i<1000; i++){
            Chromosome chromosome = new Chromosome();
            chromosome.x = r.nextDouble(500)-500;
            chromosome.y = r.nextDouble(500)-500;
            chromosomes.add(chromosome);
        }
        
//        for(Chromosome chromosome:chromosomes){
//            System.out.println(chromosome.x+" "+chromosome.y+" "+chromosome.health);
//        }
    }
    
    void mark(){
        for(Chromosome chromosome:chromosomes){
            chromosome.countHealth();
        }
    }
    
    void selection(){
        chromosomes.sort(new Comparator(){
            @Override
            public int compare(Object obj1, Object obj2){
                int res = 0;
                double health1 = ((Chromosome)obj1).health;
                double health2 = ((Chromosome)obj2).health;
                if (health2>health1) res=1; else
                    if(health2<health1) res = -1; else res=0;
                return res;
            }
        });
//        System.out.println("------------------");
//        for(Chromosome chromosome:chromosomes){
//            System.out.println(chromosome.x+" "+chromosome.y+" "+chromosome.health);
//        }
        
        chromosomes = chromosomes.subList(0, chromosomes.size()/2);
        //System.out.println(chromosomes.size());
    }
    
    void recombination(){
        java.util.Random r = new java.util.Random();
        java.util.ArrayList<Chromosome> chromosomes2 =
                new java.util.ArrayList<>();
        for(int i=0; i<1000; i++){
            Chromosome c1 = chromosomes.get(r.nextInt(chromosomes.size()));
            Chromosome c2 = chromosomes.get(r.nextInt(chromosomes.size()));
            
            Chromosome c1new = new Chromosome();
            c1new.x = c1.x + Math.random()*0.2-0.1;
            c1new.y = c2.y + Math.random()*0.2-0.1;

            Chromosome c2new = new Chromosome();
            c2new.x = c2.x;
            c2new.y = c1.y;
            
            chromosomes2.add(c1new);
            chromosomes2.add(c2new);
        }
        chromosomes = chromosomes2;
    }

    public static void main(String[] args) {
        new NewMain();
    }
    
}
