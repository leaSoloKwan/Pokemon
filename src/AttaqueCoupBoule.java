public class AttaqueCoupBoule extends AttaquePhysique{
    public AttaqueCoupBoule() {
        super("coup de tete", 70, 100, 15);
    }
    @Override
    public AttaqueCoupBoule genAttaque() {
        AttaqueCoupBoule a;
        a=this;
        return a;
    }
}
