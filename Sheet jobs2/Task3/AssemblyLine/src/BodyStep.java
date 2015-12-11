
public class BodyStep implements ILineStep  {
	public BodyStep() {
		System.out.println("BodyLineStep");
	}
	@Override
	public IProductPart buildProductPart() {
		return new BodyPart();
	}
}
