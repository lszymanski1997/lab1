import java.util.Arrays;

public class lab2zad2 {

    public static class Node{
        public int val;
        public Node up = null;
        public Node down = null;
        public Node left = null;
        public Node right = null;
        public Node next = null;

        public Node(int stan){this.val = stan;}

        public void setDir(Node up, Node down, Node left, Node right, Node next){
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.next = next;

        }
    }

    public static class Zagadka{
        public Node[] list = new Node[0];
        public Node start;
        public Node end;
        public int[] cel = {1,2,3,4,5,6,7,8,0};

        public Zagadka(int[] input){
            for(int a:input){
                list = Arrays.copyOf(list, list.length + 1);
                list[list.length - 1] = new Node(a);
            }
            this.setMap();
        }

        public void setMap(){
            list[0].setDir(null, list[3], null, list[1],list[1]);
            list[1].setDir(null, list[4], list[0], list[2],list[2]);
            list[2].setDir(null, list[5], list[1], null,list[3]);
            list[3].setDir(list[0], list[6], null, list[4],list[4]);
            list[4].setDir(list[1], list[7], list[3], list[5],list[5]);
            list[5].setDir(list[2], list[8], list[4], null,list[6]);
            list[6].setDir(list[3], null, null, list[7],list[7]);
            list[7].setDir(list[4], null, list[6], list[8],list[8]);
            list[8].setDir(list[5], null, list[7], null,null);

            start = list[0];
            end = list[8];
        }

        public boolean check(){
            boolean dobrze = true;
            Zagadka poprawne = new Zagadka(cel);
            Node currtest = poprawne.start;
            Node curr = this.start;

            while(curr != null){
                if(curr.val != currtest.val){
                    dobrze = false;
                }
                curr = curr.next;
                currtest = currtest.next;
            }
           return dobrze;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            Node curr = start;
            while(curr != null){
                result.append(" [ ").append(curr.val).append(" ] ");
                curr = curr.right;
            }
            result.append("\n");
            curr = start.down;
            while(curr != null){
                result.append(" [ ").append(curr.val).append(" ] ");
                curr = curr.right;
            }
            result.append("\n");
            curr = start.down.down;
            while(curr != null){
                result.append(" [ ").append(curr.val).append(" ] ");
                curr = curr.right;
            }
            return result.toString();
        }

        private Node Zero(){
            Node zero = null;
            for(Node a: this.list){
                if(a.val == 0){
                    zero = a;
                }
            }
            return zero;
        }

        private boolean move(Node a){
            Node zero = Zero();
            if(zero == a.up){
                System.out.println("do góry");
            }
            else if(zero == a.down){
                System.out.println("do w dół");
            }
            else if(zero == a.left){
                System.out.println("w lewo");
            }
            else if(zero == a.right){
                System.out.println("w prawo");
            }
            else{
                return false;
            }
            a.val = 0;
            assert zero != null;
            zero.val = a.val;
            return true;
        }

        public void solve(){

        }

    }

    public static void main(String[] args) {
        int[] startConfig = {0, 1, 3, 4, 2, 5, 7, 8, 6};
        Zagadka zagadka = new Zagadka(startConfig);
        System.out.println(zagadka);
    }
}
