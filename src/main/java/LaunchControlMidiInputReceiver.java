import events.LaunchControlEv;
import events.LaunchControlEvent;
import interactable.UserControl;

import javax.sound.midi.*;

public class LaunchControlMidiInputReceiver implements Receiver {
    public String rcvrName;
    MidiDevice midiDevice;

    public LaunchControlMidiInputReceiver(String rcvrName, MidiDevice device) throws MidiUnavailableException {
        System.out.println("Receiver: " + rcvrName);
        this.rcvrName = rcvrName;
        this.midiDevice = device;
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        System.out.println(message.getMessage()[2]);


        // Trigger event on change
        LaunchControlEv ev = new LaunchControlEv();
        ev.setValue(UserControl.getValue(message.getMessage()[1]), message.getMessage()[2]);
    }

    @Override
    public void close() {
        midiDevice.close();
    }


}
