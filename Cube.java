public class Cube() {
    char[][] m_aCube;

    public Cube(char[][] aCube) {
        m_aCube = aCube;
    }

    public void turnU() {
        //Takes the top layer and goes changes piece by piece.
        //Takes the next four layers other than D and then takes the left pair, moves it, then the right pair, then moves it.

    	char[] aFour = new char[4]; //the top layer in this case
    	aFour[0] = getCube()[2][2];
    	aFour[1] = getCube()[2][3];
    	aFour[2] = getCube()[3][3];
    	aFour[3] = getCube()[3][2];
    	
    	shiftRight(aFour);
    	
    	//reverse assign
    	getCube()[2][2] = aFour[0];
        getCube()[2][3] = aFour[1];
        getCube()[3][3] = aFour[2];
        getCube()[3][2] = aFour[3];

    	
    	
    	char[] aEight = new char[8]; //this is the other four layers
    	aEight[0] = getCube()[1][2];
    	aEight[1] = getCube()[1][3];
    	aEight[2] = getCube()[4][5];
    	aEight[3] = getCube()[4][4];
    	aEight[4] = getCube()[4][3];
    	aEight[5] = getCube()[4][2];
    	aEight[6] = getCube()[4][1];
    	aEight[7] = getCube()[4][0];
    	
    	for(int i = 0; i < 2; i++) {
    		shiftLeft(aEight);
    	}

        aEight[0] = getCube()[1][2];
        aEight[1] = getCube()[1][3];
        aEight[2] = getCube()[4][5];
        aEight[3] = getCube()[4][4];
        aEight[4] = getCube()[4][3];
        aEight[5] = getCube()[4][2];
        aEight[6] = getCube()[4][1];
        aEight[7] = getCube()[4][0];
    }

    public void turnUPrime() {

    }

    public void turnD() {

    }

    public void turnDPrime() {

    }
    
    public void shiftLeft(char[] aChar) {
    	char cHold = aChar[0];
    	for (int i = 0; i < aChar.length - 1; i++) {
    		aChar[i] = aChar[i + 1];
    	}
    	aChar[aChar.length - 1] = cHold;
    }
    
    public void shiftRight(char[] aChar) {
    	char cHold = aChar[aChar.length - 1];
    	for (int i = 0; i < aChar.length - 1; i++) {
    		aChar[i + 1] = aChar[i];
    	}
    	aChar[0] = cHold;
    }

    public char[][] getCube() {
        return m_aCube;
    }
}