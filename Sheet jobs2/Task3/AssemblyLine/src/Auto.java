
public class Auto implements IProduct{
	IProductPart bp;
	IProductPart cp;
	IProductPart ep;
	public Auto(IProductPart bp, IProductPart cp, IProductPart ep){
		this.bp = bp;
		this.cp = cp;
		this.ep = ep;
		System.out.println("Collect a car");
	}
	@Override
	public void installFirstPart(IProductPart bp) {
		this.bp = bp;
		System.out.println(bp.getClass().getSimpleName()+" is mounted!");
	}

	@Override
	public void installSecondPart(IProductPart cp) {
		this.cp = cp;
		System.out.println(cp.getClass().getSimpleName()+" is mounted!");
		
	}

	@Override
	public void installThirdPart(IProductPart ep) {
		this.ep  = ep;
		System.out.println(ep.getClass().getSimpleName()+" is mounted!");
		
	}

}
