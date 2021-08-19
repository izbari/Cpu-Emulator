public class ALU  {

    Instruction MBR;
    int[] AC;
    int Flag =0;
    Memory M;
    CU cu;


    public ALU() {

    }

    public String IR_signals(CU cu,Memory memory){
        MBR=cu.MBR;
        this.cu=cu;
        M=memory;
        switch (cu.IR){
            case"ADD":
                ADD(); break;
            case"ADDM":
                ADDM(); break;
            case"SUB":
                SUB(); break;
            case"SUBM":
                SUBM(); break;
            case"MUL":
                MUL(); break;
            case"MULM":
                MULM(); break;
            case"LOADM":
                LOADM(); break;
            case"LOAD":
                LOAD(); break;
            case"STORE":
                STORE(); break;
            case"CMPM":
                CMPM(); break;
            case"CJMP":
                CJMP(); break;
            case"JMP":
                JMP(); break;
            default:
                return cu.MBR.instruction;
        }
        return cu.MBR.instruction;

    }

    public void ADD(){
        AC=addBinary(AC,MBR.value);
    }
    public void ADDM(){
        M.locate(MBR.value,false);
        AC=addBinary(AC,M.getCell().getCell());
    }
    public void SUB(){
        AC=subBinary(AC,MBR.value);
    }
    public void SUBM(){
        M.locate(MBR.value,false);
        AC=subBinary(AC,M.getCell().getCell());
    }
    public void MUL(){
        AC=mulBinary(AC,MBR.value);
    }
    public void MULM()
    {
        M.locate(MBR.value,false);
        AC=mulBinary(AC,M.getCell().getCell());
    }
    public void LOAD(){
        AC=MBR.value;
    }
    public void LOADM(){

        M.locate(MBR.value,false);
        AC=M.getCell().cell;
    }
    public void STORE(){
        M.locate(AC,MBR.value,true);
    }
    public void CJMP(){
    if(Flag==1) cu.setPC(M.toDecimal(MBR.value));
    }
    public void JMP(){
    cu.setPC(M.toDecimal(MBR.value));
    }
    public void CMPM(){
        M.locate(MBR.value,false);
        if(M.toDecimal(AC)>M.toDecimal(M.getCell().getCell())) Flag=1;
        else if(M.toDecimal(AC)<M.toDecimal(M.getCell().getCell())) Flag = -1;
        else if(M.toDecimal(AC)==M.toDecimal(M.getCell().getCell())) Flag=0;
    }

    public void AC(){

    }


    public  int[] addBinary(int[] ac,int[] value){
        String input="";
        String input2="";
        // The two input Strings, containing the binary representation of the two values:
        for (int i = 0; i <ac.length ; i++) {
            input+=ac[i];
            input2+=value[i];

        }
        // Use as radix 2 because it's binary
        int number0 = Integer.parseInt(input, 2);
        int number1 = Integer.parseInt(input2, 2);

        int sum = number0 + number1;


        String result= Integer.toBinaryString(sum); //returns the answer as a binary value; but sometimes method gives 1,2... code not only 8 bit
        if(result.length()>8){
            System.out.println("Our program is only  represented  till 255 with decimal format");
            System.exit(1000);
        }
        for (int i = result.length(); i<8 ; i++) {// we complete 8bit with add 0 on the start point
            result = "0"+result;
        }

        int[] resultBinary = new int[8];
        for (int i = 0; i <result.length() ; i++) {
            resultBinary[i]=Integer.parseInt(String.valueOf(result.charAt(i)));
        }
        return resultBinary;
    }
    public  int[] subBinary(int[] ac,int[] value){
        String input="";
        String input2="";
        // The two input Strings, containing the binary representation of the two values:
        for (int i = 0; i <ac.length ; i++) {
            input+=ac[i];
            input2+=value[i];

        }
        // Use as radix 2 because it's binary
        int number0 = Integer.parseInt(input, 2);
        int number1 = Integer.parseInt(input2, 2);

        int sum = number0 - number1;


        String result= Integer.toBinaryString(sum); //returns the answer as a binary value;
        if(result.length()>8) {
            System.out.println("Our program is only  represented  till 255 with decimal format");
            System.exit(1000);
        }

        for (int i = result.length(); i <8 ; i++) {
            result = "0"+result;
        }

        int[] resultBinary = new int[ac.length];
        for (int i = 0; i <ac.length ; i++) {
            resultBinary[i]=Integer.parseInt(String.valueOf(result.charAt(i)));
        }
        return resultBinary;
    }
    public  int[] mulBinary(int[] ac,int[] value){
        String input="";
        String input2="";
        // The two input Strings, containing the binary representation of the two values:
        for (int i = 0; i <ac.length ; i++) {
            input+=ac[i];
            input2+=value[i];
        }
        // Use as radix 2 because it's binary
        int number0 = Integer.parseInt(input, 2);
        int number1 = Integer.parseInt(input2, 2);
        int sum = number0 * number1;

        String result= Integer.toBinaryString(sum); //returns the answer as a binary value;
        if(result.length()>8) {
            System.out.println("Our program is only  represented  till 255 with decimal format");
            System.exit(1000);
        }
        for (int i = result.length(); i <8 ; i++) {
            result="0"+result;
        }

        int[] resultBinary = new int[8];
        for (int i = 0; i <resultBinary.length; i++) {
            resultBinary[i]=Integer.parseInt(String.valueOf(result.charAt(i)));
        }
        return resultBinary;
    }
}
