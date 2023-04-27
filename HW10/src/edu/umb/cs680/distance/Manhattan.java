package edu.umb.cs680.distance;

import java.util.ArrayList;
import java.util.List;

public class Manhattan implements DistanceMetric {

    public double distance(List<Double> p1, List<Double> p2) {
		double sumOfSquared = 0.0;
		for(int i=0; i < p1.size(); i++) {
			sumOfSquared += Math.abs( p1.get(i)-p2.get(i));
		}
		return sumOfSquared;		
	}

    public static void main(String[] args) {
        
        Manhattan m = new Manhattan();

        List<Double> p1 = new ArrayList<>();
        List<Double> p2 = new ArrayList<>();

        p1.add((double) 5);
        p2.add((double) 10);
    
        double d = m.distance(p1, p2);

        System.out.println("Manhattan distance b/w p1 and p2 is: " + d);
    }
    
}
