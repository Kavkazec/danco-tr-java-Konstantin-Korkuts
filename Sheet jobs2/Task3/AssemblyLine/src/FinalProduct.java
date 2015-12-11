

public class FinalProduct {

	public static void main(String[] args) {
		System.out.println("-------------------");
		BodyStep bStep = new BodyStep();
		bStep.buildProductPart();
		ChassisStep cStep = new ChassisStep();
		cStep.buildProductPart();
		EngineStep eStep = new EngineStep();
		eStep.buildProductPart();
		System.out.println("-------------------");
		ProductAssemlbyLine pa = new ProductAssemlbyLine(bStep, cStep, eStep);
		System.out.println("-------------------");
		Auto auto = new Auto(bStep.buildProductPart(), cStep.buildProductPart(), eStep.buildProductPart());
		pa.assemblyProduct(auto);
		

	}

}
