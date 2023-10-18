public enum FactoryCommand {
    RESET(0),
    LOW_BRIGHTNESS(125),
    MED_BRIGHTNESS(126),
    FULL_BRIGHTNESS(127);

    public final int value;

    private FactoryCommand(int value) {
        this.value = value;
    }
}
