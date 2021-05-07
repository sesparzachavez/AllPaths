import java.util.ArrayList;
import java.util.List;

public class AllPaths {

    int[][] array;

    /**
     * Visit every child
     * Check the path to see if its a viable path to the target
     * @param graph
     * @return array of vertexes that lead to target
     */
    public int[][] allPaths (int [][] graph){

        //edge case
        if(graph == null || graph.length == 0){
            return null;
        }

        int n = graph.length;

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        current.add(0);
        //check the path
        //target is n-1, last vetex in graph
        check(graph, 0, n - 1, current, result);

//converting Array List into 2-dimentional array
        array = new int[result.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[result.get(i).size()];
        }
        for(int i=0; i<result.size(); i++){
            for (int j = 0; j < result.get(i).size(); j++) {
                array[i][j] = result.get(i).get(j);
            }
        }

        //System.out.println(array.toString());
        return array;
    }

    /**
     *if the path does lead to target, add vertexes to the results list
     */

    protected void check(int[][] graph, int root, int target, List<Integer> current, List<List<Integer>> result){
        if(root == target){
            result.add(new ArrayList<>(current));
            return;
        }
// call check until we find viable path to target
        for(int child : graph[root]){
            current.add(child);
            check(graph, child, target, current, result);
            current.remove(current.size() - 1);
        }
    }
//printing 2-d array
    @Override
    public String toString() {
        String aString = "";
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                aString += " " + array[i][j];
            }
            aString += "\n";
        }
        return aString;
    }

    public static void main(String[] args){

        AllPaths result = new AllPaths();

        int[][] graph = {{1,2}, {3}, {3}, {}};
        result.allPaths(graph);
        System.out.println(result);

        int[][] graph2 = {{1}, {}};
        result.allPaths(graph2);
        System.out.println(result);

        int[][] graph3 = {{4,3,1}, {3,2,4}, {3}, {4}, {}};
        result.allPaths(graph3);
        System.out.println(result);
    }
}
