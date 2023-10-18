package interactable;

public enum SideButton {
    DEVICE(105),
    MUTE(106),
    SOLO(107),
    RECORD(108);

    public final int value;

    private SideButton(int value) {
        this.value = value;
    }
}
