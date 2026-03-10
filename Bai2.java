package chapter02;

public class Bai2 {

    private String HDD;
    private String RAM;
    private boolean isBluetoothEnabled;

    private Bai2(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public static class ComputerBuilder {

        private String HDD;
        private String RAM;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Bai2 build() {
            return new Bai2(this);
        }
    }
}