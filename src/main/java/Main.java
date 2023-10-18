import events.LaunchControlEv;
import events.LaunchControlEvent;
import interactable.UserControl;

public class Main {
    public static void main(String[] args) {
        //Create a new device
        LaunchControlXLDevice device = new LaunchControlXLDevice("Launch Control XL");

        device.connect(); //Connect to device over midi

        //Factory test commands
        device.sendFactoryCommand(0, FactoryCommand.FULL_BRIGHTNESS);
        device.sendFactoryCommand(1, FactoryCommand.MED_BRIGHTNESS);
        device.sendFactoryCommand(2, FactoryCommand.LOW_BRIGHTNESS);
        device.sendFactoryCommand(8, FactoryCommand.RESET);

        device.turnLedOn(8, UserControl.SOLO, LedCommand.AMBER_FULL);

        LaunchControlEv init = new LaunchControlEv();
        HandleEventsTest reciver = new HandleEventsTest();
        init.addEventListener(reciver);


    }

}
