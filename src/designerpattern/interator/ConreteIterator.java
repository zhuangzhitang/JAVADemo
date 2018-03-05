package designerpattern.interator;

public class ConreteIterator implements Iterator {
	
	private ConcreteAggregate aggregate;
	private int current = 0;
	
    public ConreteIterator(ConcreteAggregate aggregate) {
		this.aggregate = aggregate;
	}
	@Override
	public Object first() {
		return aggregate;
	}

	@Override
	public Object next() {
		return null;
	}

	@Override
	public boolean isDone() {
		return false;
	}

	@Override
	public Object currentItem() {
		return null;
	}

}
