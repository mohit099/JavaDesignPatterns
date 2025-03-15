package b_structure;

// Existing Interface
interface OldCharger {
    void chargeViaMicroUsb();
}

// New Interface which require adapter class
interface NewCharger {
    void chargeViaTypeC();
}

//Old Charger Implementation
class MicroUsbCharger implements OldCharger {

    @Override
    public void chargeViaMicroUsb() {
        System.out.println("Charging Start...");
    }
}

//Adapter class to make New class compatible with New device.
class ChargerAdapter implements NewCharger {

    private final OldCharger oldCharger;

    ChargerAdapter(OldCharger oldCharger) {
        this.oldCharger = oldCharger;
    }

    @Override
    public void chargeViaTypeC() {
        oldCharger.chargeViaMicroUsb();
    }
}


public class Adapter {
    public static void main(String[] args) {
        OldCharger oldCharger = new MicroUsbCharger();
        NewCharger newCharger = new ChargerAdapter(oldCharger);
        newCharger.chargeViaTypeC();
    }
}
