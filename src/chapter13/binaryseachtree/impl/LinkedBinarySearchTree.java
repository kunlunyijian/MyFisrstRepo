package chapter13.binaryseachtree.impl;

import chapter12.tree.BinaryTreeNode;
import chapter12.tree.ElementNotFoundException;
import chapter12.tree.LinkedBinaryTree;
import chapter13.binaryseachtree.BinarySearchTreeADT;
/**
 * �������������ʵ��
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
		boolean added = false;//�˱�־λ���������Ƿ���Ҫ������������
		
		if(!(element instanceof Comparable<?>)){
			throw new ClassCastException();
		}
		
		@SuppressWarnings("unchecked")
		Comparable<T> comparableElement = (Comparable<T>)element;
		if(isEmpty()){
			root = temp; 
		}else{
			BinaryTreeNode<T> current = root;//����������¿�����Ҫ���µ�ǰ�Ľڵ�  current �Ǵ�����������еĶ�̬�ڵ�
			while(!added){//���������Ƿ���Ҫ�������ĺ���
				if(comparableElement.compareTo(current.getElement()) < 0){//��Ԫ����ӵ����ڵ�����
					if(current.getLeft() == null){
						current.setLeft(temp);
						added = true;//Ԫ���Ѿ����
					}else{
					//���µ�ǰ�ڵ�
						current = current.getLeft();
					}
				}else{//��Ԫ����ӵ����ڵ���ұ�
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
				//���½ڵ���Ŀ
				count--;
			}else{
				BinaryTreeNode<T> current ;
				BinaryTreeNode<T> parent = root;
				boolean found = false;
				if(((Comparable<T>) targetElement).compareTo(root.getElement()) < 0){
					//���µ�ǰ�ڵ�  ���½������ʹ�õ�ǰ�ڵ�Ϊ�գ�����Ҫ���д���
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
						//����parent
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
	 * ���������ѡ����һ���ڵ������汻ɾ���Ľڵ㡣 �÷��������ص����û�ָ�򽫴����Ǹ�ָ��ɾ���ڵ�Ľڵ㡣
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
