public class AttaqueFeinte extends AttaquePhysique{
    public AttaqueFeinte() {
        super("feinte", 30, 100, 10);
    }
    @Override
    public AttaqueFeinte genAttaque() {
        AttaqueFeinte a;
        a=this;
        return a;
    }
}
