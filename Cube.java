public class Cube {
    char[][] m_aCube;
    boolean m_bBack;
    boolean m_bFront;
    boolean m_bRight;
    boolean m_bLeft;
    String m_szSolve;

    public Cube(char[][] aCube) {
        m_aCube = aCube;
        updateBotBoolean();
    }


    public void updateBotBoolean() {
        //bBack
        //check back row for white piece, if there is, then false
        if (getCube()[7][2] == 'w' || getCube()[7][3] == 'w') {
            m_bBack = false;
        } else {
            m_bBack = true;
        }

        //front
        if (getCube()[6][2] == 'w' || getCube()[6][3] == 'w') {
            m_bFront = false;
        } else {
            m_bFront = true;
        }

        //right
        if (getCube()[6][3] == 'w' || getCube()[7][3] == 'w') {
            m_bRight = false;
        } else {
            m_bRight = true;
        }

        //left
        if (getCube()[6][2] == 'w' || getCube()[7][2] == 'w') {
            m_bLeft = false;
        } else {
            m_bLeft = true;
        }
    }

    public void updateTopBoolean() {
        
        //check back row for white piece, if there is, then false
        if (getCube()[2][2] == 'y' || getCube()[2][3] == 'y') {
            m_bBack = true;
        } else {
            m_bBack = false;
        }

        //front
        if (getCube()[3][2] == 'y' || getCube()[3][3] == 'y') {
            m_bFront = true;
        } else {
            m_bFront = false;
        }

        //right
        if (getCube()[2][3] == 'y' || getCube()[3][3] == 'y') {
            m_bRight = true;
        } else {
            m_bRight = false;
        }

        //left
        if (getCube()[2][2] == 'y' || getCube()[3][2] == 'y') {
            m_bLeft = true;
        } else {
            m_bLeft = false;
        }
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
        m_szSolve =+ "U ";
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
        m_szSolve =+ "UPrime ";
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
        m_szSolve =+ "D ";
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
        m_szSolve =+ "DPrime ";
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
        m_szSolve =+ "L ";
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
        m_szSolve =+ "LPrime ";
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
        m_szSolve =+ "R ";
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
        m_szSolve =+ "RPrime ";
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
        m_aCube[5][1] = frontHand[6];
        m_aCube[4][1] = frontHand[7];
        m_szSolve =+ "F ";
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
        m_aCube[5][1] = frontHand[6];
        m_aCube[4][1] = frontHand[7];
        m_szSolve =+ "FPrime ";
    }

    public void turnB() {
        char[] backBack = new char[4];
        backBack[0] = m_aCube[1][3];
        backBack[1] = m_aCube[1][2];
        backBack[2] = m_aCube[0][2];
        backBack[3] = m_aCube[0][3];

        char[] backHand = new char[8];
        backHand[0] = m_aCube[2][2];
        backHand[1] = m_aCube[2][3];
        backHand[2] = m_aCube[4][5];
        backHand[3] = m_aCube[5][5];
        backHand[4] = m_aCube[7][3];
        backHand[5] = m_aCube[7][2];
        backHand[6] = m_aCube[5][0];
        backHand[7] = m_aCube[4][0];

        shiftLeft(backHand);
        shiftLeft(backHand);
        shiftRight(backBack);

        m_aCube[1][3] = backBack[0];
        m_aCube[1][2] = backBack[1];
        m_aCube[0][2] = backBack[2];
        m_aCube[0][3] = backBack[3];

        m_aCube[2][2] = backHand[0];
        m_aCube[2][3] = backHand[1];
        m_aCube[4][5] = backHand[2];
        m_aCube[5][5] = backHand[3];
        m_aCube[7][3] = backHand[4];
        m_aCube[7][2] = backHand[5];
        m_aCube[5][0] = backHand[6];
        m_aCube[4][0] = backHand[7];
        m_szSolve =+ "B ";
    }

    public void turnBPrime() {
        char[] backBack = new char[4];
        backBack[0] = m_aCube[1][3];
        backBack[1] = m_aCube[1][2];
        backBack[2] = m_aCube[0][2];
        backBack[3] = m_aCube[0][3];

        char[] backHand = new char[8];
        backHand[0] = m_aCube[2][2];
        backHand[1] = m_aCube[2][3];
        backHand[2] = m_aCube[4][5];
        backHand[3] = m_aCube[5][5];
        backHand[4] = m_aCube[7][3];
        backHand[5] = m_aCube[7][2];
        backHand[6] = m_aCube[5][0];
        backHand[7] = m_aCube[4][0];

        shiftRight(backHand);
        shiftRight(backHand);
        shiftLeft(backBack);

        m_aCube[1][3] = backBack[0];
        m_aCube[1][2] = backBack[1];
        m_aCube[0][2] = backBack[2];
        m_aCube[0][3] = backBack[3];

        m_aCube[2][2] = backHand[0];
        m_aCube[2][3] = backHand[1];
        m_aCube[4][5] = backHand[2];
        m_aCube[5][5] = backHand[3];
        m_aCube[7][3] = backHand[4];
        m_aCube[7][2] = backHand[5];
        m_aCube[5][0] = backHand[6];
        m_aCube[4][0] = backHand[7];
        m_szSolve =+ "B' ";
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

    public void solveFirstLayer() {
        // as long as the first layer isn't solved

        char[] aBotFace = new char[4];
        aBotFace[0] = getCube()[6][2];
        aBotFace[1] = getCube()[6][3];
        aBotFace[2] = getCube()[7][2];
        aBotFace[3] = getCube()[7][3];
        updateBoolean();

        while (aBotFace[0] != 'w' || aBotFace[1] != 'w' ||  aBotFace[2] != 'w' ||  aBotFace[3] != 'w')
        {
           
            freeTurn();
            // if this, then we can't free turn anymore.

            //move the bottom layer so the empty slot is in the front right
            //move the top layer so the target piece is on the front right.
            //call the right alg.
            aBotFace[0] = getCube()[6][2];
            aBotFace[1] = getCube()[6][3];
            aBotFace[2] = getCube()[7][2];
            aBotFace[3] = getCube()[7][3];  
            System.out.println(this);
            System.out.println(aBotFace[2]);
            if (aBotFace[0] != 'w') {
                turnD();
            } else if (aBotFace[2] != 'w') {
                turnD();
                turnD();
            } else if (aBotFace[3] != 'w') {
                turnDPrime();
            }

            System.out.println("Done");

            if (getCube()[4][0] == 'w' || getCube()[2][2] == 'w' || getCube()[1][2] == 'w') {
                turnU();
                turnU();
            } else if (getCube()[4][2] == 'w' || getCube()[4][1] == 'w' || getCube()[3][2] == 'w') {
                turnUPrime();
            } else if (getCube()[2][3] == 'w' || getCube()[1][3] == 'w' || getCube()[4][5] == 'w') {
                turnU();
            }
            //call alg here
            findFLAlg();
        }
        //solved right here
    }

    public void freeTurn() {
        updateBoolean();
        //check if we can free turn

        //check right
        if (m_bRight) {
            //check 2 by 2
            if (getCube()[4][3] == 'w' || getCube()[5][3] == 'w') {
                turnRPrime();
                freeTurn();
            } else if (getCube()[0][3] == 'w' || getCube()[1][3] == 'w') {
                turnR();
                freeTurn();
            } else if (getCube()[2][3] == 'w' || getCube()[3][3] == 'w') {
                turnR();
                turnR();
                freeTurn();
            }
            
        } else if (m_bFront) {
            if (getCube()[4][1] == 'w' || getCube()[5][1] == 'w') {
                turnRPrime();
                freeTurn();
            } else if (getCube()[4][4] == 'w' || getCube()[5][4] == 'w') {
                turnF();
                freeTurn();
            } else if (getCube()[3][2] == 'w' || getCube()[3][3] == 'w') {
                turnF();
                turnF();
                freeTurn();
            }
        } else if (m_bLeft) {
            if (getCube()[0][2] == 'w' || getCube()[1][2] == 'w') {
                turnLPrime();
                freeTurn();
            } else if (getCube()[4][2] == 'w' || getCube()[5][2] == 'w') {
                turnL();
                freeTurn();
            } else if (getCube()[2][2] == 'w' || getCube()[3][2] == 'w') {
                turnL();
                turnL();
                freeTurn();
            }
        } else if (m_bBack) {
            if (getCube()[4][4] == 'w' || getCube()[5][5] == 'w') {
                turnBPrime();
            } else if (getCube()[4][0] == 'w' || getCube()[5][0] == 'w') {
                turnB();
                freeTurn();
            } else if (getCube()[2][2] == 'w' || getCube()[2][3] == 'w') {
                turnB();
                turnB();
                freeTurn();
            }
        }
    }

    public void findFLAlg() {
        if (getCube()[4][3] == 'w') {
            turnU();
            turnR();
            turnUPrime();
            turnRPrime();
        } else if (getCube()[3][3] == 'w') {
            turnU();
            turnR();
            turnR();
            turnUPrime();
            turnR();
            turnR();
        } else if (getCube()[4][5] == 'w') {
            turnR();
            turnU();
            turnRPrime();
        } else if (getCube()[5][3] == 'w') {
            turnR();
            turnUPrime();
            turnRPrime();
            turnU();
            turnR();
            turnUPrime();
            turnRPrime();
        } else if (getCube()[5][4] == 'w') {
            turnR();
            turnU();
            turnRPrime();
            turnUPrime();
            turnR();
            turnU();
            turnRPrime();
        }
    }

    public void orientateOLL() {
        updateTopBoolean();
        if (m_bBack) {
            turnU();
        } else if (m_bLeft) {
            turnU();
            turnU();
        } else if (m_bFront) {
            turnUPrime();
        } 
        updateTopBoolean();
        if (m_bFront) {
            if (m_aCube[4][2] == 'y') {
                oll_T();
            } else {
                oll_U();
            }
        }
        if (m_aCube[3][2] == 'y' && m_aCube[2][3] == 'y') {
            turnU();
        }
        if (m_aCube[2][2] == 'y' && m_aCube[3][3] == 'y') {
            if (m_aCube[4][2] == 'y') {
                oll_L();
            } else {
                turnU();
                turnU();
                oll_L();
            }
        }
        if (checkSune()) {
            if (m_aCube[2][2] == 'y') {
                turnUPrime();
            } else if (m_aCube[2][3] == 'y') {
                turnU();
                turnU();
            } else if (m_aCube[3][3] == 'y') {
                turnU();
            }
            if (m_aCube[4][3] == 'y') {
                oll_S();
            } else {
                turnU();
                turnU();
                oll_As();
            }
        }
        if (m_aCube[2][2] != 'y' && m_aCube[2][3] != 'y' && m_aCube[3][2] != 'y' && m_aCube[3][3] != 'y') {
            if (m_aCube[4][2] != 'y' && m_aCube[4][3] != 'y') {
                if (m_aCube[4][4] == 'y' && m_aCube[4][5] == 'y') {
                    turnU();
                    oll_H();
                } else {
                    turnUPrime();
                    oll_Pi();
                }
            }
            if (m_aCube[4][2] == 'y' && m_aCube[4][3] == 'y') {
                if (m_aCube[4][5] == 'y') {
                    turnU();
                    oll_Pi();
                } else {
                    oll_H();
                }
            }
            if (m_aCube[4][2] != 'y' && m_aCube[4][3] == 'y') {
                oll_Pi();
            } else if (m_aCube[4][2] == 'y' && m_aCube[4][3] != 'y') {
                turnUPrime();
                turnUPrime();
                oll_Pi();
            }
        }
    }
    public boolean checkSune() {
        return (m_aCube[2][2] == 'y' && m_aCube[2][3] != 'y' && m_aCube[3][2] != 'y' && m_aCube[3][3] != 'y') ||
                (m_aCube[2][2] != 'y' && m_aCube[2][3] == 'y' && m_aCube[3][2] != 'y' && m_aCube[3][3] != 'y') ||
                (m_aCube[2][2] != 'y' && m_aCube[2][3] != 'y' && m_aCube[3][2] == 'y' && m_aCube[3][3] != 'y') ||
                (m_aCube[2][2] != 'y' && m_aCube[2][3] != 'y' && m_aCube[3][2] != 'y' && m_aCube[3][3] == 'y');
    }
    public void oll_U() {
        turnF();
        turnR();
        turnU();
        turnRPrime();
        turnUPrime();
        turnFPrime();
    }

    public void oll_T() {
        turnR();
        turnU();
        turnRPrime();
        turnUPrime();
        turnRPrime();
        turnF();
        turnR();
        turnFPrime();
    }

    public void oll_L() {
        turnF();
        turnR();
        turnUPrime();
        turnRPrime();
        turnUPrime();
        turnR();
        turnU();
        turnRPrime();
        turnFPrime();
    }

    public void oll_S() {
        turnR();
        turnU();
        turnRPrime();
        turnUPrime();
        turnR();
        turnU();
        turnU();
        turnRPrime();
    }

    public void oll_As() {
        turnR();
        turnU();
        turnU();
        turnRPrime();
        turnUPrime();
        turnR();
        turnUPrime();
        turnRPrime();
    }

    public void oll_Pi() {
        turnF();
        turnR();
        turnU();
        turnRPrime();
        turnUPrime();
        turnR();
        turnU();
        turnRPrime();
        turnUPrime();
        turnFPrime();
    }

    public void oll_H() {
        turnR();
        turnR();
        turnU();
        turnU();
        turnR();
        turnU();
        turnU();
        turnR();
        turnR();
    }

    public void pbl_TTop() {
        turnR();
        turnU();
        turnRPrime();
        turnUPrime();
        turnRPrime();
        turnF();
        turnR();
        turnR();
        turnUPrime();
        turnRPrime();
        turnUPrime();
        turnR();
        turnU();
        turnRPrime();
        turnFPrime();
    }
    public void pbl_TBot() {
        turnX();
        turnX();
        turnR();
        turnU();
        turnRPrime();
        turnUPrime();
        turnRPrime();
        turnF();
        turnR();
        turnR();
        turnUPrime();
        turnRPrime();
        turnUPrime();
        turnR();
        turnU();
        turnRPrime();
        turnFPrime();
    }

    public void pbl_YTop() {
        turnF();
        turnR();
        turnUPrime();
        turnRPrime();
        turnUPrime();
        turnR();
        turnU();
        turnRPrime();
        turnFPrime();
        turnR();
        turnU();
        turnRPrime();
        turnUPrime();
        turnRPrime();
        turnF();
        turnR();
        turnFPrime();
    }

    public void pbl_YBot() {
        turnZ();
        turnZ();
        turnY();
        turnF();
        turnR();
        turnUPrime();
        turnRPrime();
        turnUPrime();
        turnR();
        turnU();
        turnRPrime();
        turnFPrime();
        turnR();
        turnU();
        turnRPrime();
        turnUPrime();
        turnRPrime();
        turnF();
        turnR();
        turnFPrime();
    }

    public void pbl_UFDF() {
        turnR();
        turnR();
        turnUPrime();
        turnR();
        turnR();
        turnU();
        turnU();
        turnY();
        turnR();
        turnR();
        turnUPrime();
        turnR();
        turnR();
    }
    public void pbl_Uadj() {
        turnR();
        turnUPrime();
        turnR();
        turnF();
        turnF();
        turnRPrime();
        turnU();
        turnRPrime();
    }
    public void pbl_Udiag() {
        turnL();
        turnDPrime();
        turnL();
        turnF();
        turnF();
        turnLPrime();
        turnD();
        turnLPrime();
    }
    public void pbl_UD() {
        turnR();
        turnR();
        turnF();
        turnF();
        turnR();
        turnR();
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