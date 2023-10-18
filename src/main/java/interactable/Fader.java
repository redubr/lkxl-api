package interactable;

public enum Fader {
    FADER1(77),
    FADER2(78),
    FADER3(79),
    FADER4(80),
    FADER5(81),
    FADER6(82),
    FADER7(83),
    FADER8(84);

    public final int value;

    private Fader(int value) {
        this.value = value;
    }
}
