import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zafer baris
 * @since  07.06.2021
 */
public class Midterm_20180808011 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> instructorSet = new ArrayList<>();
        File input = new File(args[0]);
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()){ // we read input file
                instructorSet.add(scanner.nextLine());
        }

        CU CU = new CU(instructorSet);//Creating control unit with instruction set.
        ALU ALU= new ALU();//Creating arithmetic logic unit.
        Memory M = new Memory();//We create 16x16 memory , each cell has 8 bit.
        CPU CPU = new CPU(CU,ALU,M);//we used composition and creating cpu with components.
        CPU.Run();//We will start application.
        CPU.print();// printing all the memory.





    }



}
