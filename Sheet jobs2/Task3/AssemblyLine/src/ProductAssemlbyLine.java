
public class ProductAssemlbyLine implements IAssemblyLine {
	BodyStep bs;
	ChassisStep cs;
	EngineStep es;
	
	public ProductAssemlbyLine(BodyStep bs, ChassisStep cs, EngineStep es) {
		this.bs = bs;
		this.cs = cs;
		this.es = es;
		System.out.println("AssemlbyLine");
	}
	
	@Override
	public void assemblyProduct(Auto auto) {
		System.out.println(" ");
		auto.installFirstPart(bs.buildProductPart());
		auto.installSecondPart(cs.buildProductPart());
		auto.installThirdPart(es.buildProductPart());
	}
	
	
}
