class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    String shape;
    String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {
        try {
            if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo for Rectangular bogie!");
            }
            this.cargo = cargo;
            System.out.println("Cargo assigned successfully");
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Assignment attempt completed.");
        }
    }

    public String getCargo() {
        return cargo;
    }
}