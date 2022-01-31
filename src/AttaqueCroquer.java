public class AttaqueCroquer extends AttaqueSpeciale{
    public AttaqueCroquer() {
        super("croquer", new String[] {"EAU"}, 40, 100, 30);
    }
    @Override
    public AttaqueCroquer genAttaque() {
        AttaqueCroquer a;
        a=this;
        return a;
    }
}
