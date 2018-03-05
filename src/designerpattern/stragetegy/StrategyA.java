package designerpattern.stragetegy;

public class StrategyA implements Strategy {
	private double moneyRebate = 1d;
    public StrategyA(double moneyRebate) {
	      this.moneyRebate = moneyRebate;
	}
    @Override
	public double algorithm(double money) {
         return moneyRebate*money;
	}

	

}
