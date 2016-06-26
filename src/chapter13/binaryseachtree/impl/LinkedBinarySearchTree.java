package chapter13.binaryseachtree.impl;

import chapter12.tree.BinaryTreeNode;
import chapter12.tree.ElementNotFoundException;
import chapter12.tree.LinkedBinaryTree;
import chapter13.binaryseachtree.BinarySearchTreeADT;
/**
 * 二叉查找树链接实现
 * @author Administrator
 *
 * @param <T>
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements
		BinarySearchTreeADT<T> {
	
	public LinkedBinarySearchTree() {
		super();
	}

	public LinkedBinarySearchTree(T element){
		super(element);
	}
	@Override
	public void addElement(T element) {
		
		BinaryTreeNode<T> temp = new BinaryTreeNode<T>(element);
		boolean added = false;//此标志位用来决定是否需要遍历左右子树
		
		if(!(element instanceof Comparable<?>)){
			throw new ClassCastException();
		}
		
		@SuppressWarnings("unchecked")
		Comparable<T> comparableElement = (Comparable<T>)element;
		if(isEmpty()){
			root = temp; 
		}else{
			BinaryTreeNode<T> current = root;//在这种情况下可能需要更新当前的节点  current 是代表迭代过程中的动态节点
			while(!added){//用来控制是否需要游历树的孩子
				if(comparableElement.compareTo(current.getElement()) < 0){//将元素添加到根节点的左边
					if(current.getLeft() == null){
						current.setLeft(temp);
						added = true;//元素已经添加
					}else{
					//更新当前节点
						current = current.getLeft();
					}
				}else{//将元素添加到根节点的右边
					if(current.getRight() == null){
						current.setRight(temp);
						added = true;
					}else{
						current = current.getRight();
					}
				}
			}
			
		}
		count++;
	}
	/**
	 * Removes the first element that matches the specified target element from the binary search tree
	 * and returns the a reference to it. Throws an ElementNotFoundException if the specified target 
	 * element is not found in the binary search tree.
	 * @throws ElementNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T removeElement(T targetElement) throws ElementNotFoundException {
		T result = null;
		if(!isEmpty()){
			if(((Comparable<T>) targetElement).compareTo(root.getElement()) == 0){
				result = root.getElement();
				root = replacement(root);
				//更新节点数目
				count--;
			}else{
				BinaryTreeNode<T> current ;
				BinaryTreeNode<T> parent = root;
				boolean found = false;
				if(((Comparable<T>) targetElement).compareTo(root.getElement()) < 0){
					//更新当前节点  更新结果可能使得当前节点为空，后面要进行处理
					current =  root.getLeft();
				}else{
					current = root.getRight();
				}
				while(current != null && !found){
					if(targetElement.equals(current.getElement())){
						found = true;
						count--;
						result =  current.getElement();
						if(current == parent.getLeft()){
							parent.setLeft(replacement(current));
						}else{
							parent.setRight(replacement(current));
						}
					}else{
						//更新parent
						parent = current;
						if(((Comparable<T>) targetElement).compareTo(current.getElement()) < 0){
							current = current.getLeft();
						}else{
							current = current.getRight();
						}
					}//while
					if(!found){
						throw new ElementNotFoundException("binary tree");
					}
					
					
				}
			}
		}
		return result;
	}
	/**
	 * 这里必须推选出另一个节点来代替被删除的节点。 该方法所返回的引用会指向将代替那个指定删除节点的节点。
	 * Returns a reference to a node  that will replace the one specified for removal .
	 * In the case where the removed node has two children, the inorder successor is used 
	 * as its replacement.
	 * @param root
	 * @return
	 */
	private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> result = null;
		if(node.getLeft() == null && node.getRight() == null){
			result = null;
		}else if(node.getLeft() != null && node.getRight() == null){
			result = node.getLeft();
		}else if(node.getLeft() == null && node.getRight() != null){
			result = node.getRight();
		}else{
			BinaryTreeNode<T> current = node.getRight();
			BinaryTreeNode<T> parent = node;
		}
		
		return result;
	}

	@Override
	public void removeAllOccurrences(T targetElement){
		try {
			removeElement(targetElement);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(contains(targetElement)){
			try {
				removeElement(targetElement);
			} catch (ElementNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public T removeMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMax() {
		// TODO Auto-generated method stub
		return null;
	}

}
