public enum LedCommand {
    OFF(12),
    RED_LOW(13),
    RED_FULL(15),
    AMBER_LOW(29),
    AMBER_FULL(63),
    YELLOW_FULL(62),
    GREEN_LOW(28),
    GREEN_FULL(60),
    BLINK_RED(11),
    BLINK_AMBER(59),
    BLINK_YELLOW(58),
    BLINK_GREEN(56);

    public final int value;

    private LedCommand(int value) {
        this.value = value;
    }
}
