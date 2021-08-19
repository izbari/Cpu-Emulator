
public class CPU {

    CU cu;
    ALU alu;
    Memory M;
    boolean check=true;
    public CPU(CU cu, ALU alu,Memory M) {
        this.alu=alu;
        this.cu=cu;
        this.M=M;
        cu.decoingInstruction();//interpreting and distrubing instruction
    }


    public void Run(){// when cpu.run this method will start to get instruction.
        while (check){
            cu.MBR(cu.decodedInstructions);
            String result = alu.IR_signals(cu, M);
               otherInstructions(result);// if MBR.instruction == start,disp,halt

            }

        if(cu.PC<cu.decodedInstructions.size()){// if program halted.And next instruction start.
            for (int i = cu.PC; i <cu.decodedInstructions.size() ; i++) {
                cu.MBR(cu.decodedInstructions);
                if(cu.MBR.instruction.equals("START")){
                    start();
                }
            }
        }


        }
        // --------------------------- printing memory methods--------------------------
        public String innerPrint(int i , int j)
        {
            String st ="";
            for (int k = 0; k <M.getM()[i][j].getCell().length; k++) {
                st+=M.getM()[i][j].getCell()[k];
            }
            return st;
        }
        public String topPrint(){String st="";
            for (int i = 0; i <16 ; i++) {
                st+=i+"\t\t   ";
            }
            return st;
        }
    public void print(){
        int count =0;
        System.out.println("\t   "+topPrint());
        for (int i = 0; i <M.getM().length ; i++) { System.out.print(count+"\t");count++;
            for (int j = 0; j <M.getM()[0].length ; j++) {
                System.out.print(innerPrint(i,j)+"\t");

            }
            System.out.println();
        }
    }
//       ------------------------------- printing memory methods --------------------------------
    private void otherInstructions(String instruction) {//basic instruction center
        switch (instruction){
            case "START":
                start(); break;
            case "HALT":
                halt(); break;
            case "DISP":
                disp(); break;
        }
    }

    private void disp() {//disp ac value with decimal format
        String result="";
        for (int i = 0; i <alu.AC.length ; i++) {
            result+=alu.AC[i];
        }
        System.out.println(result+"("+M.toDecimal(alu.AC)+")");
    }

    private void halt() {
        check=false;
    }// if instruction is halt, we will check is false;

    private void start() {// if instruction is start, we will check is true ;
        System.out.println("Cpu simulator is starting...");
        check=true;
        Run();
    }


}
