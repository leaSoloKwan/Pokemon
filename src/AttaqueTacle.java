public class AttaqueTacle extends AttaquePhysique{
    public AttaqueTacle() {
        super("tacle", 40, 100, 35);
    }
    @Override
    public AttaqueTacle genAttaque() {
        AttaqueTacle a;
        a=this;
        return a;
    }
}
