import java.util.*;

public class MyArrayList implements MyList {
	//instance variables
	private int currentCapacity = 8;
	private int size = 0;
	private Object[] storage = new Object[8];
	
	//append()
	@Override
	public void append(Object o) {
		if (size == currentCapacity)
			makeCapacity(2*currentCapacity);
		storage[size] = o;
		size++;
	}
	
	//insertAt()
	@Override
	public void insertAt(int index, Object o) {
		if(index < 0 || index > this.size)
		   throw new NoSuchElementException();
		if(size == currentCapacity)
		   makeCapacity(2*currentCapacity);
		size++;
		for (int i = size - 1; i > index; i--) {
		   storage[i] = storage[i-1];
		}
		storage[index] = o;
		
	}
	
	//removeAt()
	@Override
	public void removeAt(int index) {
		if(index<0||index >= this.size)
			throw new NoSuchElementException();
		for(int i = index + 1; i < this.size; i++) {
		   storage[i-1] = storage[i];
		}
		size--;
	}
	
	//getAt()
	@Override
	public Object getAt(int index) {
		if(index <0 || index >= this.size)
			throw new NoSuchElementException();
		else
			return storage[index];
	}
	
	//getSize()
	@Override
	public int getSize() {
		return this.size;
	}
	
	//makeCapacity()
	public void makeCapacity(int minCapacity) {
		if (minCapacity > this.size || minCapacity != this.currentCapacity) {
			if (minCapacity > 8) {
				this.currentCapacity = minCapacity;
				Object[] newstorage = Arrays.copyOf(this.storage, this.currentCapacity);
				this.storage = newstorage;
				
			}
			else if (minCapacity < 8) {
				this.currentCapacity = 8;
				Object[] newstorage = Arrays.copyOf(this.storage, this.currentCapacity);
				this.storage = newstorage;
			}
		}
	}
	
	//trimExcess()
	public void trimExcess() {
		makeCapacity(this.size);	
	}
	
	//getIterator()
	@Override
    public MyListIterator getIterator() {
        return new MyArrayListIterator();
    }
    
	//myArrayListIterator class
    private class MyArrayListIterator implements MyListIterator {
        int currentIndex = -1;

        @Override
        public Object next() {
            ++currentIndex;
            return storage[currentIndex];
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size - 1;
        }
    }   
}
