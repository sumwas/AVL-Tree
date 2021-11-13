package AVL;
/* Summayah Waseem; 
 * (ii) Comp 282 MW 3:30pm; 
 * AVL Programming Assignment; 
 * 10/19/21;
 * AVL Tree insert methods, height depth leafcount and successor methods */
class StringAVLNode {
	private String item;
	private int balance;
	private StringAVLNode lf, rt;
	// Just one constructor, please
	public StringAVLNode(String str) {
		this.item = str;
		lf = null;
		rt = null;
		balance = 0;
	}
	public int getBalance() {
		return balance; }
	public void setBalance(int bal) {
		this.balance = bal;
	}
	public String getItem() {
		return item; }
	// No setItem
	public StringAVLNode getLeft() {
		return lf; }
	public void setLeft(StringAVLNode pt) { 
		this.lf = pt;
	}
	public StringAVLNode getRight() {
		return rt; }
	public void setRight(StringAVLNode pt) {
		this.rt = pt;
	}
	} // StringAVLNode
	
	
	
class StringAVLTree {
	// Should be private but I need access for my test programs
	StringAVLNode root;
	// Just one constructor
			
	public StringAVLTree() {
		root = null;
	}
			
	public void insert(String d) { 
		root = insert(d,root);
	}
			
	private StringAVLNode insert(String d, StringAVLNode t) {
		int OldBalance, NewBalance;
		if (t == null)
			t = new StringAVLNode(d);
		// insert left if d smaller
		else if (d.compareToIgnoreCase(t.getItem()) < 0) {
			if (t.getLeft() == null)   // d gets inserted into the tree here
				OldBalance = 282;      // kludgey, but simple
			else
				OldBalance = t.getLeft().getBalance();
			t.setLeft(insert(d, t.getLeft()));
			NewBalance = t.getLeft().getBalance();
			// has the height of the left subtree increased?
			if ((OldBalance == 0 && NewBalance != 0) || OldBalance == 282) {
				if (t.getBalance() == 1) // fix balances
					t.setBalance(0);
				else if (t.getBalance() == 0) {
					t.setBalance(-1);
				} else {// must rotate
				if (t.getLeft().getBalance() == -1) { // LL insert, so single rotation
					t = rotateRight(t);
					t.setBalance(0);
					t.getRight().setBalance(0);
				} else { // LR insert, so double rotation
					t.setLeft(rotateLeft(t.getLeft()));
					t = rotateRight(t);//LR RL rotation fix
					// update balances
					if (t.getBalance() == 0) {
						t.getRight().setBalance(0);
						t.getLeft().setBalance(0);
					} else if (t.getBalance() == -1) {
						t.getLeft().setBalance(0);
						t.getRight().setBalance(1);
					} else {
						t.getLeft().setBalance(-1);
						t.getRight().setBalance(0);
					}
					t.setBalance(0);
				}}}
		// else insert right	
		} else if (d.compareToIgnoreCase(t.getItem()) > 0) { 
			if (t.getRight() == null) {
				OldBalance = 282;
			}
			else {
				OldBalance = t.getRight().getBalance();
			}
			t.setRight(insert(d,t.getRight()));
			NewBalance = t.getRight().getBalance();
			if ((OldBalance == 0 && NewBalance != 0) || OldBalance == 282) {
				if (t.getBalance() == -1) // fix balances
					t.setBalance(0);
				else if (t.getBalance() == 0 ) {
					t.setBalance(1);
				} else { //rotate
					if(t.getRight().getBalance() == 1) { //RR
						t = rotateLeft(t);
						t.setBalance(0);
						t.getLeft().setBalance(0);
					}
					else { //RL
						t.setRight(rotateRight(t.getRight()));
						t = rotateLeft(t);
						//update bal
						if (t.getBalance() == 0) {
							t.getRight().setBalance(0);
							t.getLeft().setBalance(0);
						} else if (t.getBalance()== 1) {
							t.getLeft().setBalance(-1);
							t.getRight().setBalance(0);
						} else {
							t.getLeft().setBalance(0);
							t.getRight().setBalance(1);
						}
						t.setBalance(0);					}
				}
			
			}	
		} // else d is already in the tree
		else {
			
		}
		return t; }
			
	// Rotate the node to the right
	private static StringAVLNode rotateRight(StringAVLNode t) {
		StringAVLNode rotNode = t.getLeft(); //make left node the parent and return parent
		t.setLeft(rotNode.getRight());
		rotNode.setRight(t);
		return rotNode; }
			
	// Rotate the node to the left
	private static StringAVLNode rotateLeft(StringAVLNode t) {
		StringAVLNode rotNode = t.getRight(); //make right node the parent and return parent
		t.setRight(rotNode.getLeft());
		rotNode.setLeft(t);
		return rotNode; }
			
	public void delete(String d) { 
		root = delete(root,d);
	}
			
	private StringAVLNode delete(StringAVLNode t, String d) {
		return null; }
			
	// For all of the following methods be sure not to use any global variables
	// and no extra ìcountingî parameters in the recursive methods, e.g., the
	// recursive height method should just have one parameter, the StringAVLNode
	// Return the height of the tree ñ not to be used anywhere in insert or delete
	
	private int height(StringAVLNode t) {
		// int values for overall tree height, right subtree height, left subtree height
		int h;
		int rh;
		int lh;
		if (t == null) { //if no nodes h 0
			h = 0;
		}
		else { //return the largest height out of the two subtrees
			rh = height(t.getRight());
			lh = height(t.getLeft());
			h = Math.max(rh, lh)+1;
		}
		
		return h; }
	
	//driver 
	public int height() {
		return height(root);
	}
	
			
	// Return the depth of the closest leaf to the root
	private int nadir(StringAVLNode t) {
		int depth;
		int rd;
		int ld;
		if (t == null) {
			depth = 0; //null tree depth -1 since 1 root is depth 0
		}
		else if (t.getLeft()==null) { //if right leaf count right
			depth = 1 + nadir(t.getRight());
		}
		else if (t.getRight()==null) { //if left leaf count left
			depth = 1 + nadir(t.getLeft());
		}
		else { //else min depth from left right subtrees
			rd = nadir(t.getLeft());
			ld = nadir(t.getRight());
			depth = 1 + Math.min(rd, ld);
		}
		return depth; }
	
	//driver
	public int nadir() {
		return nadir(root);
	}
		
	
	// Return the number of leaves in the tree
	private int leafCt(StringAVLNode t) {
		int returnval;
		if (t == null) { //return 0 if node is null
			returnval = 0;
		}
		else if (t.getRight() == null && t.getLeft() == null) {  //both childs null return 1
			returnval = 1;
		}
		else { //Recursive call to count leaves in right and left subtree
			returnval = leafCt(t.getRight()) + leafCt(t.getLeft());
		}
		return returnval;
	}
	
	//driver
	public int leafCt() {
		return leafCt(root);
	}
	
			
	// Return the number of perfectly balanced AVL nodes
	private int balanced(StringAVLNode t) {
		int returnval;
		if(t == null) { //return 0 if node null
			returnval= 0;
		}
		else if (t.getBalance()==0 ) { //Recursively call to count balanced nodes
			returnval= 1 + balanced(t.getLeft()) + balanced(t.getRight());
		}
		else //go through subtrees
			returnval= balanced(t.getLeft()) + balanced(t.getRight());
		return returnval;
		}
	
	public int balanced() {
		return balanced(root);
	}
	
			
	// Return the inorder successor, i.e., the next larger value in the tree
	// or null if there is none or str is not in the tree
	public String successor(String str) {
		return successor(str,root); 
		}
	
	/*String returnval = null;
	if(t == null) { //return 0 if node null
		returnval= null;
	}
	else if(t.getItem().compareToIgnoreCase(t.getItem())==str.compareToIgnoreCase(str)) {
		StringAVLNode temp = t.getRight(); //get min of right subtree
		while(temp.getRight() != null) {
			returnval = temp.getLeft().getItem();
		}
	}
	else {
		returnval = null;
	}*/
	
	private String successor(String str, StringAVLNode t) {
		String succ = null; 
		if (t == null) { //null if tree null
			succ = null;
		}
		else if (str == t.getItem()) { //when at the item find the min of right subtree
			if (t.getRight() != null) {
				t = t.getRight();
				if (t.getLeft() == null) {
					succ = t.getItem();
				}
				else {
					while (t.getLeft() != null) 
					{
						t = t.getLeft();
					}
					succ = t.getItem();
					}
			}
			else {
				succ = t.getItem();
			}
		}
	 //store big succ
			//succ = t.getItem();
		   succ = successor(str,t.getLeft());
			succ = successor(str,t.getRight());
		return succ;
	}

			
	// who are you?
	public static String myName() {
		return "Summayah Waseem"; }
	} // StringAVLTree class
