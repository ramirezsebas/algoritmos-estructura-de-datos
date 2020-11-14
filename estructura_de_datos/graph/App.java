public class App {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.put("Luque", "Asuncion", 20);
        graph.put("San Pedro", "Luque", 11);
        graph.put("Asuncion", "San Lorenzo", 34);
        graph.put("El Solitario", "Ñemby", 4);
        graph.put("Luque", "San Lorenzo", 1);
        graph.put("Ñemby", "San Lorenzo", 10);
        graph.bfs("Luque");
        System.out.println();
        graph.dfs("Luque");
        System.out.println();
    }
}
