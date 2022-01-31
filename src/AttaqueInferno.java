public class AttaqueInferno extends AttaqueSpeciale{
    public AttaqueInferno() {
        super("inferno", new String[] {"FEU"}, 100, 50, 5);
    }
    @Override
    public AttaqueInferno genAttaque() {
        AttaqueInferno a;
        a=this;
        return a;
    }
}
