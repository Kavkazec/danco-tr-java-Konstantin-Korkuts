
public class Auto implements IProduct{
	public Auto(){
		System.out.println("Collect a car");
	}
	@Override
	public void installFirstPart(IProductPart pr) {
		System.out.println("is mounted");
	}

	@Override
	public void installSecondPart(IProductPart pr) {
		System.out.println("is mounted");
		
	}

	@Override
	public void installThirdPart(IProductPart pr) {
		System.out.println("is mounted");
		
	}

}
