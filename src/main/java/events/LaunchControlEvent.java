package events;

import interactable.UserControl;

public interface LaunchControlEvent {
    void physicalStateChanged(UserControl btn, int value);
}
