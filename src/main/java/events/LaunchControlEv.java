package events;

import interactable.UserControl;

import java.util.ArrayList;
import java.util.List;

public class LaunchControlEv {

    private static List<LaunchControlEvent> eventListeners = new ArrayList<LaunchControlEvent>();

    public void addEventListener(LaunchControlEvent eventListener) {
        eventListeners.add(eventListener);
    }

    public void setValue(UserControl keyId, int value) {
        //Notify everyone listening
        for (LaunchControlEvent event : eventListeners) {
            event.physicalStateChanged(keyId, value);
        }
    }


}
