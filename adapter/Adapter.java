/**
 * When to the Adapter pattern
 * 1. to create an middle layer.
 * 2. to decouple as integrating with 3rd party libraries.
 */

public class Adapter{

    public static void main(String[] argv){
        MacbookAir2020 mac = new MacbookAir2020();
        Usb usb = new Usb();
        mac.read(new UsbTypecAdapter(usb));
    
    }

}


class MacbookAir2020{

    public MacbookAir2020(){

    }

    //requires a type-c interface to read from external source.
    public void read(Typec serial){
        System.out.println(serial.roundConnector());
        System.out.println("reading from round connector...");
    }
}

interface Typec{

    String roundConnector();
    
}

class Usb{

    public Usb(){

    }

    public String sqaureConnector(){
        return "writing to square connector...";
    }
}

class UsbTypecAdapter implements Typec{ 

    private Usb usb;

    public UsbTypecAdapter(Usb usb){
        this.usb = usb;
    }

    public String roundConnector(){
        return usb.sqaureConnector();
    }
}