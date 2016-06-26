package chapter12.tree;

import java.util.ArrayList;
import java.util.Iterator;


public class LinkedBinaryTree <T> implements BinaryTreeADT<T>{
		protected int count;
		protected BinaryTreeNode<T> root;
		/**
		 * Creates an empty binary tree.
		 */
		public LinkedBinaryTree() {
			count = 0;
			root = null;
		}
		
		public LinkedBinaryTree(T element){
			count = 1;
			root = new BinaryTreeNode<T>(element);
		}
		
		public LinkedBinaryTree(T element, LinkedBinaryTree<T> leftSubtree, LinkedBinaryTree<T> rigthTree){
			root = new BinaryTreeNode<T>(element);
			count = 1;
			if(leftSubtree != null){
				count = count + leftSubtree.size();
				root.left = leftSubtree.root;
			}else{
				root.left = null;
			}
			if(rigthTree != null){
				count = count + rigthTree.size();
				root.right = rigthTree.root;
			}else{
				root.right = null;
			}
		}

		
		
		public void removeLeftSubTree(){
			if(root.left != null){
				count = count - root.left.numChildren() - 1;
			}
			root.left = null;
		}
		
		public T find(T targetElement) throws ElementNotFoundException{
			BinaryTreeNode<T> current = findAgain(targetElement, root);
			if(current == null){
				throw new ElementNotFoundException("binarytree");
			}
			return (current.element);
		}
		
		/**
		 * Returns a reference to the specified target element if it is found in the binary tree.
		 * @param targetElement
		 * @param next
		 * @return
		 */
		private BinaryTreeNode<T> findAgain(T targetElement,BinaryTreeNode<T> next){
			if(next == null){
				return null;
			}
			if(next.element.equals(targetElement)){//当前根节点所存储的元素
				return next;
			}
			BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
			if(temp == null){//左子树中没有找到目标对象时，则查找右子树
				temp = findAgain(targetElement, next.right);
			}
			return temp;
		}
		@SuppressWarnings("unchecked")
		public Iterator<T> iteratorInOrder(){
			ArrayList<T> tempList = new ArrayList<T>();
			inorder(root, tempList);
			return (Iterator<T>) tempList.iterator();
		}
		
		/**
		 * 中序遍历
		 * @param node
		 * @param tempList
		 */
		protected void inorder(BinaryTreeNode<T> node, ArrayList<T> tempList){
			if(node != null){
				inorder(node.left, tempList);
				tempList.add(node.element);
				inorder(node.right, tempList);
			}
		}
		
		public int size() {
			// TODO Auto-generated method stub
			return this.count;
		}
		
		public  boolean isEmpty(){
			return count == 0;
		}

		@Override
		public void removeRightSubTree() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeAllElements() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(T targetElement) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<T> iteratorPreOrder() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterator<T> iteratorPostOrder() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterator<T> iteratorLevelOrder() {
			// TODO Auto-generated method stub
			return null;
		}
}
