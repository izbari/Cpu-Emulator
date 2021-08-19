
public class Instruction {

    String instruction;
    int[] value;//for instructorSet have only instruction

    public Instruction(String instruction) {
        this.instruction = instruction;
    }

    public Instruction(String instruction, String value) {

     this.instruction = instruction;
        this.value=toBinary(value);

    }

    public int[] getValue() {
        return value;
    }


    private int[] toBinary(String data) {//  we get all instructionSet values by binary format.

        // Creating and assigning binary array size

        int[] binary = new int[8];
        int count =  binary.length-1;
        int value = Integer.parseInt(data);
        // Number should be positive
        while (value > 0 && count>-1) {
            binary[count--] = value % 2;
            value = value / 2;
        }

        return  binary;
    }

}
