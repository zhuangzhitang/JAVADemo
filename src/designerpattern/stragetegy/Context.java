package designerpattern.stragetegy;

public class Context {
	
    private Strategy strategy;
    public Context(String type){
    	switch (type) {
		case "A":
			strategy = new StrategyA(0.8d);
			break;

		case "B":
			strategy = new StrategyB();
			break;
		}
    }
    
    public double contextInface(double money){
    	return strategy.algorithm(money);
    }
}
