package interactable;

public enum UserControl {
    FADER1(77),
    FADER2(78),
    FADER3(79),
    FADER4(80),
    FADER5(81),
    FADER6(82),
    FADER7(83),
    FADER8(84),
    DEVICE(105),
    MUTE(106),
    SOLO(107),
    RECORD(108),
    BUTTON1(73),
    BUTTON2(74),
    BUTTON3(75),
    BUTTON4(76),
    BUTTON5(89),
    BUTTON6(90),
    BUTTON7(91),
    BUTTON8(92),
    BUTTON_1_1(41),
    BUTTON_1_2(42),
    BUTTON_1_3(43),
    BUTTON_1_4(44),
    BUTTON_1_5(57),
    BUTTON_1_6(58),
    BUTTON_1_7(59),
    BUTTON_1_8(60);

    public final int value;

    private UserControl(int value) {
        this.value = value;
    }

    public static UserControl getValue(int value) {
        for(UserControl e: UserControl.values()) {
            if(e.value == value) {
                return e;
            }
        }
        return null;// not found
    }
}
