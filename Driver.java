public class Driver {
    public static void main(String[] args) {
        Cube oCube = new Cube(new char[][] {
            new char[] {' ', ' ', '3', '4', ' ', ' '},
            new char[] {' ', ' ', '2', '1', ' ', ' '},
            new char[] {' ', ' ', 'y', 'y', ' ', ' '},
            new char[] {' ', ' ', 'y', 'y', ' ', ' '},
            new char[] {'r', 'r', 'g', 'g', 'o', 'o'},
            new char[] {'r', 'r', 'g', 'g', 'o', 'o'},
            new char[] {' ', ' ', 'w', 'w', ' ', ' '},
            new char[] {' ', ' ', 'w', 'w', ' ', ' '}});


        oCube.turnBPrime();

        System.out.println(oCube);
    }
}