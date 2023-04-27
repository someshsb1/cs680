package edu.umb.cs680.distance;

import java.util.List;

public class Cosine implements DistanceMetric {

    public double distance(List<Double> p1, List<Double> p2) {
        double dp = 0.0;
        double Mp1 = 0.0;
        double Mp2 = 0.0;

        for(int i=0; i < p1.size(); i++) {
            dp += p1.get(i) * p2.get(i);
            Mp1 += Math.pow(p1.get(i), 2); 
            Mp2 += Math.pow(p2.get(i), 2); 
        }
        Mp1 = Math.sqrt(Mp1);
        Mp2 = Math.sqrt(Mp2);

        return 1.0 - (dp / (Mp1 * Mp2));
    }

    public static void main(String args[]) {
        Cosine cosine = new Cosine();

        List<Double> p1 = List.of(40.0, 55.0, 75.0);
        List<Double> p2 = List.of(20.0, 25.0, 30.0);

        double d = cosine.distance(p1, p2);

        System.out.println("Cosine distance b/w p1 and p2 is: " + d);

    }
}
