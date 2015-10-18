public class Driver {
    public static void main(String[] args) {
        Cube oCube = new Cube(new char[][] {
            new char[] {' ', ' ', 'b', 'b', ' ', ' '},
            new char[] {' ', ' ', 'b', 'b', ' ', ' '},
            new char[] {' ', ' ', 'y', 'y', ' ', ' '},
            new char[] {' ', ' ', 'y', 'y', ' ', ' '},
            new char[] {'1', '2', 'g', 'g', '1', '2'},
            new char[] {'4', '3', 'g', 'g', '4', '3'},
            new char[] {' ', ' ', 'w', 'w', ' ', ' '},
            new char[] {' ', ' ', 'w', 'w', ' ', ' '}});


        oCube.turnR();

        System.out.println(oCube);
    }
}