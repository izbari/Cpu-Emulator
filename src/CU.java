import java.util.ArrayList;
import java.util.Objects;

public class CU {
   ArrayList<String> instructorSet;
   ArrayList<Instruction> decodedInstructions= new ArrayList<>();
        Instruction MBR;
      // String MBR,PSR;
        int PC=0;
        int[] MAR;
       String IR;


       public CU(ArrayList<String> instructorSet) {
           this.instructorSet = instructorSet;
       }

       public ArrayList<Instruction> decoingInstruction(){// interpreting and distrubing instructions

           for (int i = 0; i <instructorSet.size() ; i++) {

               String[] splited  = instructorSet.get(i).split(" ");
               if (splited.length == 2) {// start,halt...
                   instructorSet.set(i, splited[1]);
               } else instructorSet.set(i, splited[1] + " " + splited[2]);
               if (splited.length == 2) decodedInstructions.add(new Instruction(splited[1]));
               else decodedInstructions.add(new Instruction(splited[1], splited[2]));
           }

            return  decodedInstructions;
    }
        public void MBR(ArrayList<Instruction> decodedInstructions){//run part
                if(PC<decodedInstructions.size()) {
                    MBR = decodedInstructions.get(PC);
                    IR_execute(MBR);
                    MAR_execute(MBR);
                    PC++;
                }

        }
       public void IR_execute(Instruction MBR){
           IR = MBR.instruction;

       }
       public void MAR_execute(Instruction MBR){
           if(!Objects.isNull(MBR.value))MAR = MBR.getValue();
       }



       public void setPC(int PC) {
           this.PC = PC;
       }
   }
