import java.util.LinkedList;
import java.util.Queue;

public class lab2 {

    public static class Node{
        public int state;
        public Node prawy = null;
        public Node lewy = null;

        public Node(int stan){
            this.state = stan;
        }

        public void link(Node lewy, Node prawy){
            this.lewy = lewy;
            this.prawy = prawy;
        }
    }

    public static class Agent{
        public Node position;
        public Node currold = null;
        Queue<Node> kolejka = new LinkedList<Node>();
        Queue<Node> posprzatane = new LinkedList<Node>();

        public Agent(Node position){
            this.position = position;
            this.kolejka.add(this.position);
        }

        public void Action(){
            while(kolejka.size() > 0) {
                Node current = kolejka.poll();
                if(current.prawy != null && currold == current.prawy){
                    System.out.println("jadę w lewo");
                }
                else if (current.lewy != null &&currold == current.lewy){
                    System.out.println("jade w prawo");
                }

                if (!posprzatane.contains(current.lewy) && current.lewy != null) {
                    kolejka.add(current.lewy);
                }
                if (!posprzatane.contains(current.prawy) && current.prawy != null) {
                    kolejka.add(current.prawy);
                }
                posprzatane.add(current);
                System.out.println("sprzątam");
                current.state = 0;
                currold = current;
            }
            System.out.println("wszystko posprzątane");
        }
    }





    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        node1.link(null, node2);
        node2.link(node1, null);
        System.out.println("[*],[ ]");

        Agent agent = new Agent(node1);
        agent.Action();

        System.out.println();

        node1 = new Node(1);
        node2 = new Node(1);
        node1.link(node2, null);
        node2.link(null, node1);
        System.out.println("[ ],[*]");

        agent = new Agent(node1);
        agent.Action();
    }
}
