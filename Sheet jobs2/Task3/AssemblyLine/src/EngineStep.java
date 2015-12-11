
public class EngineStep implements ILineStep {
	public EngineStep() {
		System.out.println("EngineLineStep");
	}
	@Override
	public IProductPart buildProductPart() {		
		return new EnginePart();
	}
}
