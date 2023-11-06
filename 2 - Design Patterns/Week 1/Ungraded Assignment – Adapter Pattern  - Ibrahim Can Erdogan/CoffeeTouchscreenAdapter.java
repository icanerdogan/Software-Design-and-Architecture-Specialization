public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

    OldCoffeeMachine oldCoffeeMachine;

    public CoffeeTouchscreenAdapter(OldCoffeeMachine oldCoffeeMachine) {
        this.oldCoffeeMachine = oldCoffeeMachine;
    }

    public void chooseOldCoffeeMachine() {
        this.oldCoffeeMachine.selectLatte();
    }

    public void chooseNewCoffeeMachine() {
        this.oldCoffeeMachine.selectTurkishCoffee();
    }
}