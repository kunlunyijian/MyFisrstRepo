package chapter12.tree;

import java.util.Iterator;

public interface BinaryTreeADT<T> {
	
	
	public void removeLeftSubTree();
	
	
	public void removeRightSubTree();
	
	
	public void removeAllElements();
	
	
	public boolean isEmpty();
	
	
	public int size();
	
	
	public boolean contains(T targetElement);
	
	
	public T  find(T targetELement) throws ElementNotFoundException;
	
	
	public String toString();
	
	
	public Iterator<T> iteratorInOrder();
	
	
	public Iterator<T> iteratorPreOrder();
	
	
	public Iterator<T> iteratorPostOrder();
	
	
	public Iterator<T> iteratorLevelOrder();
	
	
}
