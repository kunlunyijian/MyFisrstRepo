package chapter13.binaryseachtree;

import chapter12.tree.BinaryTreeADT;
import chapter12.tree.ElementNotFoundException;

public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T>{

	public void addElement(T element);
	
	
	public T removeElement(T targetElement) throws ElementNotFoundException;
	
	
	public void removeAllOccurrences(T targetElement) throws ElementNotFoundException;
	
	
	public T removeMin();
	
	
	public T removeMax();
	
	
	public T findMin();
	
	
	public T findMax();
}
