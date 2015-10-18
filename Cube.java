public class Cube {
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
        for (int i = 2; i < 8; i++) {
            aEight[i] = getCube()[4][7 - i];
        }
        
        for(int i = 0; i < 2; i++) {
            shiftRight(aEight);
        }

        getCube()[1][2] = aEight[0];
        getCube()[1][3] = aEight[1];
        for (int i = 2; i < 8; i++) {
            getCube()[4][7 - i] = aEight[i];
        }
    }

    public void turnUPrime() {
        char[] aFour = new char[4]; //the top layer in this case
        aFour[0] = getCube()[2][2];
        aFour[1] = getCube()[2][3];
        aFour[2] = getCube()[3][3];
        aFour[3] = getCube()[3][2];
        
        shiftLeft(aFour);
        
        //reverse assign
        getCube()[2][2] = aFour[0];
        getCube()[2][3] = aFour[1];
        getCube()[3][3] = aFour[2];
        getCube()[3][2] = aFour[3];

        
        
        char[] aEight = new char[8]; //this is the other four layers
        aEight[0] = getCube()[1][2];
        aEight[1] = getCube()[1][3];
        for (int i = 2; i < 8; i++) {
            aEight[i] = getCube()[4][7 - i];
        }
        
        for(int i = 0; i < 2; i++) {
            shiftLeft(aEight);
        }

        getCube()[1][2] = aEight[0];
        getCube()[1][3] = aEight[1];
        for (int i = 2; i < 8; i++) {
            getCube()[4][7 - i] = aEight[i];
        }
    }

    public void turnD() {
        char[] aFour = new char[4]; //the top layer in this case
        aFour[0] = getCube()[6][2];
        aFour[1] = getCube()[6][3];
        aFour[2] = getCube()[7][3];
        aFour[3] = getCube()[7][2];
        
        shiftRight(aFour);
        
        //reverse assign
        getCube()[6][2] = aFour[0];
        getCube()[6][3] = aFour[1];
        getCube()[7][3] = aFour[2];
        getCube()[7][2] = aFour[3];

        
        
        char[] aEight = new char[8]; //this is the other four layers
        aEight[0] = getCube()[0][2];
        aEight[1] = getCube()[0][3];
        for (int i = 2; i < 8; i++) {
            aEight[i] = getCube()[5][7 - i];
        }
        
        for(int i = 0; i < 2; i++) {
            shiftLeft(aEight);
        }

        getCube()[0][2] = aEight[0];
        getCube()[0][3] = aEight[1];
        for (int i = 2; i < 8; i++) {
            getCube()[5][7 - i] = aEight[i];
        }
    }

    public void turnDPrime() {
        char[] aFour = new char[4]; //the top layer in this case
        aFour[0] = getCube()[6][2];
        aFour[1] = getCube()[6][3];
        aFour[2] = getCube()[7][3];
        aFour[3] = getCube()[7][2];
        
        shiftLeft(aFour);
        
        //reverse assign
        getCube()[6][2] = aFour[0];
        getCube()[6][3] = aFour[1];
        getCube()[7][3] = aFour[2];
        getCube()[7][2] = aFour[3];

        
        
        char[] aEight = new char[8]; //this is the other four layers
        aEight[0] = getCube()[0][2];
        aEight[1] = getCube()[0][3];
        for (int i = 2; i < 8; i++) {
            aEight[i] = getCube()[5][7 - i];
        }
        
        for(int i = 0; i < 2; i++) {
            shiftRight(aEight);
        }

        getCube()[0][2] = aEight[0];
        getCube()[0][3] = aEight[1];
        for (int i = 2; i < 8; i++) {
            getCube()[5][7 - i] = aEight[i];
        }
    }

    public void turnL() {
        char[] leftLeft = new char[4];
        char[] leftHand = new char[8];

        for (int i = 0; i < leftHand.length; i++) {
            leftHand[i] = m_aCube[i][2];
        }
        leftLeft[0] = m_aCube[4][0];
        leftLeft[1] = m_aCube[4][1];
        leftLeft[2] = m_aCube[5][1];
        leftLeft[3] = m_aCube[5][0];

        shiftRight(leftHand);
        shiftRight(leftHand);
        shiftRight(leftLeft);
        for (int i = 0; i < leftHand.length; i++) {
            m_aCube[i][2] = leftHand[i];
        }
        m_aCube[4][0] = leftLeft[0];
        m_aCube[4][1] = leftLeft[1];
        m_aCube[5][1] = leftLeft[2];
        m_aCube[5][0] = leftLeft[3];
    }

    public void turnLPrime() {
        char[] leftLeft = new char[4];
        char[] leftHand = new char[8];

        for (int i = 0; i < leftHand.length; i++) {
            leftHand[i] = m_aCube[i][2];
        }
        leftLeft[0] = m_aCube[4][0];
        leftLeft[1] = m_aCube[4][1];
        leftLeft[2] = m_aCube[5][1];
        leftLeft[3] = m_aCube[5][0];

        shiftLeft(leftHand);
        shiftLeft(leftHand);
        shiftLeft(leftLeft);

        for (int i = 0; i < leftHand.length; i++) {
            m_aCube[i][2] = leftHand[i];
        }
        m_aCube[4][0] = leftLeft[0];
        m_aCube[4][1] = leftLeft[1];
        m_aCube[5][1] = leftLeft[2];
        m_aCube[5][0] = leftLeft[3];
    }

    public void turnR() {
        char[] rightRight = new char[4];
        char[] rightHand = new char[8];

        for (int i = 0; i < rightHand.length; i++) {
            rightHand[i] = m_aCube[i][3];
        }
        rightRight[0] = m_aCube[4][4];
        rightRight[1] = m_aCube[4][5];
        rightRight[2] = m_aCube[5][5];
        rightRight[3] = m_aCube[5][4];

        shiftLeft(rightHand);
        shiftLeft(rightHand);
        shiftRight(rightRight);

        for (int i = 0; i < rightHand.length; i++) {
            m_aCube[i][3] = rightHand[i];
        }
        m_aCube[4][4] = rightRight[0];
        m_aCube[4][5] = rightRight[1];
        m_aCube[5][5] = rightRight[2];
        m_aCube[5][4] = rightRight[3];
    }

    public void turnRPrime() {
        char[] rightRight = new char[4];
        char[] rightHand = new char[8];

        for (int i = 0; i < rightHand.length; i++) {
            rightHand[i] = m_aCube[i][3];
        }
        rightRight[0] = m_aCube[4][4];
        rightRight[1] = m_aCube[4][5];
        rightRight[2] = m_aCube[5][5];
        rightRight[3] = m_aCube[5][4];

        shiftRight(rightHand);
        shiftRight(rightHand);
        shiftLeft(rightRight);

        for (int i = 0; i < rightHand.length; i++) {
            m_aCube[i][3] = rightHand[i];
        }
        m_aCube[4][4] = rightRight[0];
        m_aCube[4][5] = rightRight[1];
        m_aCube[5][5] = rightRight[2];
        m_aCube[5][4] = rightRight[3];
    }

    public void turnF() {
        char[] frontFront = new char[4];
        frontFront[0] = m_aCube[4][2];
        frontFront[1] = m_aCube[4][3];
        frontFront[2] = m_aCube[5][3];
        frontFront[3] = m_aCube[5][2];

        char[] frontHand = new char[8];

        frontHand[0] = m_aCube[3][2];
        frontHand[1] = m_aCube[3][3];
        frontHand[2] = m_aCube[4][4];
        frontHand[3] = m_aCube[5][4];
        frontHand[4] = m_aCube[6][3];
        frontHand[5] = m_aCube[6][2];
        frontHand[6] = m_aCube[5][1];
        frontHand[7] = m_aCube[4][1];

        shiftRight(frontHand);
        shiftRight(frontHand);
        shiftRight(frontFront);

        m_aCube[4][2] = frontFront[0];
        m_aCube[4][3] = frontFront[1];
        m_aCube[5][3] = frontFront[2];
        m_aCube[5][2] = frontFront[3];

        m_aCube[3][2] = frontHand[0];
        m_aCube[3][3] = frontHand[1];
        m_aCube[4][4] = frontHand[2];
        m_aCube[5][4] = frontHand[3];
        m_aCube[6][3] = frontHand[4];
        m_aCube[6][2] = frontHand[5];
        m_aCube[5][1] = frontHand[6] ;
        m_aCube[4][1] = frontHand[7];

    }
    public void turnFPrime() {
        char[] frontFront = new char[4];
        frontFront[0] = m_aCube[4][2];
        frontFront[1] = m_aCube[4][3];
        frontFront[2] = m_aCube[5][3];
        frontFront[3] = m_aCube[5][2];

        char[] frontHand = new char[8];

        frontHand[0] = m_aCube[3][2];
        frontHand[1] = m_aCube[3][3];
        frontHand[2] = m_aCube[4][4];
        frontHand[3] = m_aCube[5][4];
        frontHand[4] = m_aCube[6][3];
        frontHand[5] = m_aCube[6][2];
        frontHand[6] = m_aCube[5][1];
        frontHand[7] = m_aCube[4][1];

        shiftLeft(frontHand);
        shiftLeft(frontHand);
        shiftLeft(frontFront);

        m_aCube[4][2] = frontFront[0];
        m_aCube[4][3] = frontFront[1];
        m_aCube[5][3] = frontFront[2];
        m_aCube[5][2] = frontFront[3];

        m_aCube[3][2] = frontHand[0];
        m_aCube[3][3] = frontHand[1];
        m_aCube[4][4] = frontHand[2];
        m_aCube[5][4] = frontHand[3];
        m_aCube[6][3] = frontHand[4];
        m_aCube[6][2] = frontHand[5];
        m_aCube[5][1] = frontHand[6] ;
        m_aCube[4][1] = frontHand[7];
    }
    
    public void turnX() {
        turnR();
        turnLPrime();
    }

    public void turnXPrime() {
        turnRPrime();
        turnL();
    }

    public void turnY() {
        turnU();
        turnDPrime();
    }
    public void turnYPrime() {
        turnUPrime();
        turnD();
    }

    public void turnZ() {
        turnF()
        turnBPrime();
    }

    public void turnZPrime() {
        turnFPrime();
        turnB();
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
        for (int i = aChar.length - 1; i > 0; i--) {
            aChar[i] = aChar[i - 1];
        }
        aChar[0] = cHold;
    }

    @Override
    public String toString() {
        String szOutput = "";
        for(char[] a : getCube()) {
            for (char c : a) {
                szOutput += (c + " ");
            }
            szOutput += "\n";
        }
        return szOutput;
    }

    public char[][] getCube() {
        return m_aCube;
    }
}