import events.LaunchControlEvent;
import interactable.UserControl;

public class HandleEventsTest implements LaunchControlEvent {
    @Override
    public void physicalStateChanged(UserControl button, int value) {
        System.out.println("KEY ID: " + button + " VALUE: " + value);

        if (button == UserControl.MUTE) {
            System.out.println("Pressed mute");
        }
    }
}
