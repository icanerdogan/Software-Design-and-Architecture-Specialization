public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

    OldCofffeeMachine theMachine;

    public CoffeeTouchscreenAdapter(OldCoffeeMachine newMachine) {
        theMachine = newMachine;
    }

    public void chooseFirstSelection() {
        theMachine.selectA();
    }

    public void chooseSecondSelection() {
        theMachine.selectB();
    }
}