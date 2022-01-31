public class AttaqueMachouille extends AttaquePhysique{
    public AttaqueMachouille() {
        super("croquer", 80, 100, 15);
    }
    @Override
    public AttaqueMachouille genAttaque() {
        AttaqueMachouille a;
        a=this;
        return a;
    }
}
