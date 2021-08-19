public class MemoryCell {// Memory cell part

    int[] cell;

    public MemoryCell() {
        cell= new int[8];//8 bit
    }

    public int[] getCell() {
        return cell;
    }

    public void setCell(int[] cell) {
        this.cell = cell;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
