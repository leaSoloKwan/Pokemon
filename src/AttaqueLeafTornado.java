public class AttaqueLeafTornado extends AttaqueSpeciale{
    public AttaqueLeafTornado() {
        super("LeafTornado", new String[] {"PLANTE"}, 65, 90, 10);
    }
    @Override
    public AttaqueLeafTornado genAttaque() {
        AttaqueLeafTornado a;
        a=this;
        return a;
    }
}
