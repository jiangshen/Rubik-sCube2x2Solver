public class Driver {
    public static void main(String[] args) {
        Cube oCube = new Cube(new char[][] {
            new char[] {' ', ' ', 'b', 'b', ' ', ' '},
            new char[] {' ', ' ', 'b', 'b', ' ', ' '},
            new char[] {' ', ' ', 'y', 'y', ' ', ' '},
            new char[] {' ', ' ', 'y', 'y', ' ', ' '},
            new char[] {'r', 'r', '1', '2', 'o', 'o'},
            new char[] {'r', 'r', '4', '3', 'o', 'o'},
            new char[] {' ', ' ', 'w', 'w', ' ', ' '},
            new char[] {' ', ' ', 'w', 'w', ' ', ' '}});


        oCube.turnFPrime();

        System.out.println(oCube);
    }
}