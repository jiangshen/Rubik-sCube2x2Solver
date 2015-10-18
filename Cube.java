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
        m_szSolve = "";
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
        m_szSolve += "U ";
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
        m_szSolve += "UPrime ";
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
        m_szSolve += "D ";
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
        m_szSolve += "DPrime ";
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
        m_szSolve += "L ";
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
        m_szSolve += "LPrime ";
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
        m_szSolve += "R ";
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
        m_szSolve += "RPrime ";
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
        m_szSolve += "F ";
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
        m_szSolve += "FPrime ";
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
        m_szSolve += "B ";
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
        m_szSolve += "B' ";
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
        turnF();
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
        updateBotBoolean();

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
            if (aBotFace[0] != 'w') {
                turnD();
            } else if (aBotFace[3] != 'w') {
                turnDPrime();
            } else if (aBotFace[2] != 'w') {
                turnD();
                turnD();
            } 

            if (getCube()[2][3] == 'w' || getCube()[1][3] == 'w' || getCube()[4][5] == 'w') {
                turnU();
            } else if (getCube()[4][2] == 'w' || getCube()[4][1] == 'w' || getCube()[3][2] == 'w') {
                turnUPrime();
            } else if (getCube()[4][0] == 'w' || getCube()[2][2] == 'w' || getCube()[1][2] == 'w') {
                turnU();
                turnU();
            }
            //call alg here
            findFLAlg();
        }
        //solved right here
    }

    public void freeTurn() {
        updateBotBoolean();
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
                turnFPrime();
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
        System.out.println("Here");
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
        } else if (getCube()[4][4] == 'w') {
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

    public void orientLL() {
        char[] aTopFace = new char[4];
        aTopFace[0] = getCube()[2][2];
        aTopFace[1] = getCube()[2][3];
        aTopFace[2] = getCube()[3][3];
        aTopFace[3] = getCube()[3][2];
        int nSolved = 0;

        for(char c : aTopFace) {
            if (c == 'y')
                nSolved++;
        }
        System.out.println(nSolved);
        if (nSolved == 0) {
            //check number of doubles
            int nDouble = 0;
            int nLocation = -1;
            if (getCube()[4][0] == 'y' && getCube()[4][1] == 'y') {
                nDouble++;
                nLocation = 0;
            }
            if (getCube()[4][2] == 'y' && getCube()[4][3] == 'y') {
                nDouble++;
                nLocation = 1;
            }
            if (getCube()[4][4] == 'y' && getCube()[4][5] == 'y') {
                nDouble++; 
                nLocation = 2;
            } 
            if(getCube()[1][2] == 'y' && getCube()[1][3] == 'y') {
                nDouble++;
                nLocation = 3;
            }

            if (nDouble == 1) {
                if (nLocation == 1)
                    turnU();
                else if (nLocation == 2) {
                    turnU();
                    turnU();
                } else if (nLocation == 3)
                    turnUPrime();

                oll_Pi();
            } else if (nDouble == 2) {
                if (nLocation == 0 || nLocation == 2) {
                    turnU();
                }
                oll_H();
            }
        } else if (nSolved == 1) {
            //AUF
            if (aTopFace[0] == 'y') {
                turnUPrime();
            } else if (aTopFace[1] == 'y') {
                turnU();
                turnU();
            } else if (aTopFace[2] == 'y') {
                turnU();
            }

            if (getCube()[4][3] == 'y') {
                oll_S();
            } else {
                oll_As();
            }
        } else if (nSolved == 2) {
            boolean bPass = true;
            if (aTopFace[0] == 'y' && aTopFace[1] == 'y') {
                turnU();
            } else if (aTopFace[1] == 'y' && aTopFace[2] == 'y') {
                //oriented correctly
            } else if (aTopFace[2] == 'y' && aTopFace[3] == 'y') {
                turnUPrime();
            } else if (aTopFace[3] == 'y' && aTopFace[0] == 'y') {
                turnU();
                turnU();
            } else {
                bPass = false;
            }

            if (bPass) {
                if (getCube()[4][0] == 'y' && getCube()[4][1] == 'y') {
                    oll_U();
                } else {
                    oll_T();
                }
            } else {
                if (aTopFace[0] == 'y') {
                    if (getCube()[4][2] == 'y') {
                        //we're good!
                    }
                } else if (aTopFace[1] == 'y') {
                    if (getCube()[4][0] == 'y') {
                        turnUPrime();
                    }
                } else if (aTopFace[2] == 'y') {
                    if (getCube()[1][3] == 'y') {
                        turnU();
                        turnU();
                    }
                } else if (aTopFace[3] == 'y') {
                    if (getCube()[4][4] == 'y') {
                        turnU();
                    }
                }
                oll_L();
            }
        }
    }

    public void permuteBL() {
        boolean bTopSolved = false;
        boolean bBotSolved = false;
        char[] aTop = new char[8];
        aTop[0] = getCube()[1][2];
        aTop[1] = getCube()[1][3];
        for (int i = 2; i < 8; i++) {
            aTop[i] = getCube()[4][7 - i];
        }

        char[] aBot = new char[8];
        aBot[0] = getCube()[0][2];
        aBot[1] = getCube()[0][3];
        for (int i = 2; i < 8; i++) {
            aBot[i] = getCube()[5][7 - i];
        }

        int nTopPairs = 0;
        int nTopLocation = -1;
        if (aTop[0] == aTop[1]) {
            nTopPairs++;
            nTopLocation = 1;
        }
        if (aTop[2] == aTop[3]) {
            nTopPairs++;
            nTopLocation = 2;
        }
        if (aTop[4] == aTop[5]) {
            nTopPairs++;
            nTopLocation = 3;
        }
        if (aTop[6] == aTop[7]) {
            nTopPairs++;
            nTopLocation = 0;
        }

        if (nTopPairs == 4) {
            bTopSolved = true;
        }

        int nBotPairs = 0;
        int nBotLocation = -1;
        if (aBot[0] == aBot[1]) {
            nBotPairs++;
            nBotLocation = 3;
        }
        if (aBot[2] == aBot[3]) {
            nBotPairs++;
            nBotLocation = 2;
        }
        if (aBot[4] == aBot[5]) {
            nBotPairs++;
            nBotLocation = 1;
        }
        if (aBot[6] == aBot[7]) {
            nBotPairs++;
            nBotLocation = 0;
        }

        if (nBotPairs == 4) {
            bBotSolved = true;
        }
        System.out.println(nBotPairs);
        if (!bBotSolved && bTopSolved) {
            turnX();
            turnX();
            bBotSolved = true;
            bTopSolved = false;
            nTopLocation = nBotLocation;
        }
        if (!bTopSolved && bBotSolved) {
            //Here are the 4 on top, only need to include 2.
            System.out.println(nTopLocation);
            System.out.println(nTopPairs);
            if (nTopLocation > -1) {
                //AUF
                if (nTopLocation == 1) {
                    turnUPrime();
                } else if (nTopLocation == 2) {
                    turnU();
                    turnU();
                } else if (nTopLocation == 3) {
                    turnU();
                }
                pbl_TTop();
            } else {
                pbl_YTop();
            }
        } else if (!bTopSolved && !bBotSolved) {
            if (nTopLocation > -1 && nBotLocation > -1) {
                if (nTopLocation == 0) {
                    turnU();
                } else if (nTopLocation == 2) {
                    turnUPrime();
                } else if (nTopLocation == 3) {
                    turnU();
                    turnU();
                }
                if (nBotLocation == 0) {
                    turnDPrime();
                } else if (nBotLocation == 2) {
                    turnD();
                } else if (nBotLocation == 1) {
                    turnD();
                    turnD();
                }
                pbl_UFDF();
            } else if (nTopLocation > -1) {
                //top double, bot not
                if (nTopLocation == 0) {
                    turnUPrime();
                } else if (nTopLocation == 1) {
                    turnU();
                    turnU();
                } else if (nTopLocation == 2) {
                    turnU();
                }
                //todo ADJUST bot. Maybe not?
                pbl_Uadj();
            } else if (nBotLocation > -1) {
                //bot double, top not
                turnX();
                turnX();
                permuteBL();
            } else {
                pbl_UD();
            }
        }

        //adjust top face
        if (getCube()[4][4] == getCube()[5][2]) {
            turnU();
        } else if (getCube()[4][0] == getCube()[5][2]) {
            turnUPrime();
        } else if (getCube()[1][3] == getCube()[5][2]) {
            turnU();
            turnU();
        }
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
        turnU();
        turnR();
        turnU();
        turnU();
        turnRPrime();
    }

    public void oll_As() {
        turnL();
        turnU();
        turnU();
        turnLPrime();
        turnUPrime();
        turnL();
        turnUPrime();
        turnLPrime();
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

    public void cleanOutput() {
        //TODO Things like UUU or U U' or etc.
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