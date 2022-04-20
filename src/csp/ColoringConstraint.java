package csp;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ColoringConstraint extends Constraint<String, String>{
    private String place1, place2;

    public ColoringConstraint(String place1, String place2){
        super(List.of(place1,place2));
        this.place1 = place1;
        this.place2 = place2;
    }

    @Override
    public boolean satisfied(Map<String,String> assignment){
        if (!assignment.containsKey(place1) ||
                !assignment.containsKey(place2)) {
            return true;
        }
        return !assignment.get(place1).equals(assignment.get(place2));
    }


    public static void main(String[] args) {
        List<String> variables = List.of("X1", "X2", "X3");
        Map<String, List<String>> domains = new HashMap<>();
        for (String variable : variables){
            domains.put(variable, List.of("R", "G", "B"));
        }
        Csp<String, String> csp = new Csp<>(variables,domains);
        csp.addConstraint(new ColoringConstraint("X1", "X2"));
        csp.addConstraint(new ColoringConstraint("X2", "X3"));
        csp.addConstraint(new ColoringConstraint("X3", "X1"));
        Map<String,String> solution = csp.backtrackingSearch();
        if(solution == null){
            System.out.println("No solution found!");
        } else {
            System.out.println(solution);
        }

    }



}
