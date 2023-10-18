import interactable.UserControl;

import javax.sound.midi.*;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaunchControlXLDevice {
    private final String deviceName;
    private MidiDevice outDevice;
    private MidiDevice inDevice;

    private Receiver launchPadReciver; //Send messages to here

    static Logger logger = Logger.getLogger(LaunchControlXLDevice.class.getName());

    public LaunchControlXLDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public void connect() {
        //Make connection
        connectToMidiDevice();

        //Reset device
        sendFactoryCommand(0, FactoryCommand.RESET);

    }

    private void connectToMidiDevice() {
        for (MidiDevice.Info info : MidiSystem.getMidiDeviceInfo()) {
            System.out.println(info.getName());
            if (Objects.equals(info.getName(), deviceName)) {
                try {
                    MidiDevice device = MidiSystem.getMidiDevice(info);

                    //To send messages
                    if (device.getMaxReceivers() != 0) {
                        //MIDI IN
                        System.out.print(info.getName()+"+++++++++++++++++++++++++++++++++IN +++++++++++++");
                        inDevice = device;

                        inDevice.open();
                        launchPadReciver = inDevice.getReceiver();

                        logger.log(Level.INFO, inDevice.getDeviceInfo()+" ##MIDI IN## was opened");
                    }

                    //To receive messages
                    if (device.getMaxTransmitters() != 0) {
                        //MIDI OUT
                        System.out.print(info.getName()+"+++++++++++++++++++++++++++++++++OUT+++++++++++ ");
                        outDevice = device;

                        //Find all transmitters
                        List<Transmitter> transmitters = outDevice.getTransmitters();

                        for (Transmitter transmitter : transmitters) {
                            transmitter.setReceiver(new LaunchControlMidiInputReceiver(outDevice.getDeviceInfo().toString(), outDevice));
                        }

                        Transmitter trans = outDevice.getTransmitter();


                        Receiver receiver = new LaunchControlMidiInputReceiver(outDevice.getDeviceInfo().toString(), outDevice);
                        trans.setReceiver(receiver);

                        //open device
                        outDevice.open();
                        //if code gets this far without throwing an exception
                        //print a success message
                        logger.log(Level.INFO, outDevice.getDeviceInfo()+ "##MIDI OUT## was opened");
                    }
                } catch (MidiUnavailableException e) {
                    logger.log(Level.WARNING, "Device '" + deviceName + "' is not available. Error: " + e.getLocalizedMessage());
                }
            }
        }
    }


    /**
     *
     * @param layer 0-7 User and 8-15 for Factory templates
     * @param command command to send
     */
    public void sendFactoryCommand(int layer, FactoryCommand command) {
        try {
            ShortMessage myMsg = new ShortMessage();
            myMsg.setMessage(ShortMessage.CONTROL_CHANGE, layer, 0, command.value);
            long timeStamp = -1;
            launchPadReciver.send(myMsg, timeStamp);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
    }

    public void turnLedOn(int layer, UserControl button, LedCommand color) {
        try {
            ShortMessage myMsg = new ShortMessage();
            myMsg.setMessage(ShortMessage.NOTE_ON, layer, button.value, color.value);
            long timeStamp = -1;
            launchPadReciver.send(myMsg, timeStamp);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
    }

    public void turnLedOff(int layer, UserControl button) {
        try {
            ShortMessage myMsg = new ShortMessage();
            myMsg.setMessage(ShortMessage.NOTE_OFF, layer, button.value, 0);
            long timeStamp = -1;
            launchPadReciver.send(myMsg, timeStamp);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
    }

}
