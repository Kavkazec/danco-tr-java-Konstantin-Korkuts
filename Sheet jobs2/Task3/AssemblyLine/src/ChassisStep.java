
public class ChassisStep implements ILineStep{
	public ChassisStep() {
		System.out.println("ChassisLineStep");
	}
	@Override
	public IProductPart buildProductPart() {
		return new ChassisPart();
	}

}
