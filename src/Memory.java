
public class Memory {
    MemoryCell[][] M;//DRAM Ram
    boolean RAS, CAS, WE, OE;
    int columnAddressBuffer = -1;
    int rowAddressBuffer = -1;
    int dataBuffer = -1;
    MemoryCell cell;


    public Memory() {// we start our memory blank cell and [00000000]
        mapMemory();
    }

    public void mapMemory(){
        M = new MemoryCell[16][16];
        for (int i = 0; i <16 ; i++) {
            for (int j = 0; j <16 ; j++) {
                M[i][j]= new MemoryCell();
            }
        }
    }

    public void locate(int[] data, int[] locateAddress, boolean readOrWrite) {//read false, write true(used in store etc..)
        this.RAS = true;
        this.CAS = true;
        this.WE = true;
        cell=new MemoryCell();
        cell.setCell(data);
        rowAddressDecoder(locateAddress, readOrWrite);

    }

         public  int toDecimal(int[] location)// This method get int[8] arr and convert decimal
        {
            String binary="";
            for (int i = 0; i <location.length; i++) {
                binary+=location[i];
            }

            int num = Integer.parseInt(binary);
            int decimalNumber = 0, i = 0;
            long remainder;

            while (num != 0) {
                remainder = num % 10;
                num /= 10;
                decimalNumber += remainder * Math.pow(2, i);
                ++i;
            }

            return decimalNumber;
        }


    public void locate(int[] locateAddress,boolean readOrWrite){ // this method updating current cell in class and we used in read memory.
        this.RAS = true;
        this.CAS = true;
        this.WE = true;
        rowAddressDecoder(locateAddress,readOrWrite);
    }

    private void columnAddressDecoder(int[] locateAddress,boolean readOrWrite) {// find column of specific location
        columnAddressBuffer= toDecimal(locateAddress)%M[0].length;
        if(readOrWrite){//write part
            M[rowAddressBuffer][columnAddressBuffer]=cell;//write
            WE=false;
            dataBuffer=-1;//reset
        }
        else{
            cell=M[rowAddressBuffer][columnAddressBuffer];//read part
        }

        CAS=false;
    }

    private void rowAddressDecoder(int[] locateAddress,boolean readOrWrite) {//find row
        rowAddressBuffer= toDecimal(locateAddress)/M.length;
        RAS = false;
        columnAddressDecoder(locateAddress,readOrWrite);

    }


    public MemoryCell[][] getM() {
        return M;
    }


    public MemoryCell getCell() {
        return cell;
    }

}
