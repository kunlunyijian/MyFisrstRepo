package chapter12.tree.expressiontree.postfix;

import java.io.IOException;

/**
 * Çý¶¯³ÌÐò
 * @author Arnold
 *
 */
public class Postfix2 {
	public static void main(String[] args) {
		 PostfixEvaluator2 temp = new PostfixEvaluator2();
		 try {
			temp.solve();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
