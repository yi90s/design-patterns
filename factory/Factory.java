/** 
 * This pattern wraps around the Builder class and abstract the complexity away from it.
 */
public class Factory {
   public static void main(String[] args) {
      ComputerFactory factory = new ComputerFactory();

      Computer gamingPc = factory.getComputer(ComputerType.HIGHEND);
      System.out.println("My Gaming PC spec:" + '\n'+ gamingPc.toString());

      Computer junkPc = factory.getComputer(ComputerType.BUDGET);
      System.out.println("My Junk PC sepc:" + "\n" + junkPc.toString());
   }

}

class ComputerFactory{

  public Computer getComputer(ComputerType type){
     Computer newPc = null;

     if(type == ComputerType.HIGHEND){
         newPc = new Computer.Builder().pickCpu(Cpu.INTEL).pickGpu(Gpu.NVIDIA)
            .pickMb(MotherBoard.ASUS).pickPsu(Psu.ASUS).pickRam(Ram.GSKILL)
            .pickStorage(Storage.SAMSUNG).build();
     }else if(type == ComputerType.BUDGET){
         newPc = new Computer.Builder().pickCpu(Cpu.AMD).pickGpu(Gpu.AMD)
         .pickMb(MotherBoard.MSI).pickPsu(Psu.ASUS).pickRam(Ram.GSKILL)
         .pickStorage(Storage.SEGATE).build();
     }
     
     return newPc;
  }
}

enum ComputerType {

   HIGHEND, BUDGET;
}