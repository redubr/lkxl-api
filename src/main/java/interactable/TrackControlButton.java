package interactable;

public enum TrackControlButton {
    BUTTON1(73),
    BUTTON2(74),
    BUTTON3(75),
    BUTTON4(76),
    BUTTON5(89),
    BUTTON6(90),
    BUTTON7(91),
    BUTTON8(92);

    public final int value;

    private TrackControlButton(int value) {
        this.value = value;
    }
}
