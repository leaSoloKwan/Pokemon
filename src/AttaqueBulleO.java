public class AttaqueBulleO extends AttaqueSpeciale{
    public AttaqueBulleO() {
        super("bulle", new String[] {"EAU"}, 40, 100, 30);
    }
    @Override
    public AttaqueBulleO genAttaque() {
        AttaqueBulleO a;
        a=this;
        return a;
    }
}
