public class AttaqueMorsure extends AttaquePhysique {
    public AttaqueMorsure() {
        super("morsure", 60, 100, 25);
    }
    @Override
    public AttaqueMorsure genAttaque() {
        AttaqueMorsure a;
        a=this;
        return a;
    }
}
