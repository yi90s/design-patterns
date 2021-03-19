/**
 * Builder design pattern
 * -> used for construction of a complex object step by step by chaining up a series of method calls that defines
 * -> the characteristics of the object.
 */


public class Builder {

    public static void main(String[] args) {

        Computer pc = new Computer.Builder()
        .pickCpu(Cpu.INTEL)
        .pickGpu(Gpu.AMD)
        .pickRam(Ram.GSKILL)
        .pickMb(MotherBoard.MSI)
        .pickPsu(Psu.ASUS)
        .pickStorage(Storage.SAMSUNG)
        .build();

        System.out.println(pc.toString());    
    }
    
}


class Computer{

    private Cpu cpu;
    private Gpu gpu;
    private Ram ram;
    private MotherBoard mb;
    private Psu psu;
    private Storage storage;

    public Computer(Builder builder){
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.ram = builder.ram;
        this.mb = builder.mb;
        this.psu = builder.psu;
        this.storage = builder.storage;
    }

    public String toString(){
        return "My PC specification:\n"
            +this.cpu.toString() + "\n"
            +this.gpu.toString() + "\n"
            +this.ram.toString() + "\n"
            +this.mb.toString() + "\n"
            +this.psu.toString() + "\n"
            +this.storage.toString() + "\n"
            +"------------------------";
    }

    public static class Builder{
        private Cpu cpu;
        private Gpu gpu;
        private Ram ram;
        private MotherBoard mb;
        private Psu psu;
        private Storage storage;

        public Builder(){
            
        }

        public Builder pickCpu(Cpu cpu){
           this.cpu = cpu;
           return this; 
        }

        public Builder pickGpu(Gpu gpu){
            this.gpu = gpu;
            return this;
        }

        public Builder pickRam(Ram ram){
            this.ram = ram;
            return this;
        }

        public Builder pickMb(MotherBoard mb){
            this.mb = mb;
            return this;
        }

        public Builder pickPsu(Psu psu){
            this.psu = psu;
            return this; 
        }

        public Builder pickStorage(Storage s){
            this.storage = s;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}



enum Cpu{

    INTEL,
    AMD;

    public String toString(){
        return name().toLowerCase();
    }
}

enum Gpu{
    NVIDIA,
    AMD;

    public String toString(){
        return name().toLowerCase();
    }
}

enum Ram{
    HYPERX,
    GSKILL;

    public String toString(){
        return name().toLowerCase();
    }
}

enum MotherBoard{
    MSI,
    ASUS;

    public String toString(){
        return name().toLowerCase();
    }
}

enum Psu{
    ASUS;

    public String toString(){
        return name().toLowerCase();
    }
}

enum Storage{
    SAMSUNG,
    SEGATE;

    public String toString(){
        return name().toLowerCase();
    }
}