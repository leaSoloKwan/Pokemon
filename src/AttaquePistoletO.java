public class AttaquePistoletO extends AttaqueSpeciale{
    public AttaquePistoletO() {
        super("pistoletO", new String[] {"EAU"}, 40, 100, 25);
    }
    @Override
    public AttaquePistoletO genAttaque() {
        AttaquePistoletO a;
        a=this;
        return a;
    }
}
