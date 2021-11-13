package AVL;

public class mytest {
	public static void main(String[] args) {
		StringAVLTree t = new StringAVLTree();
		t.insert("e");
		t.insert("b");
		t.insert("j");
		t.insert("f");
		t.insert("c");
		t.insert("a");
		t.insert("d");
		System.out.println(t.height());
		System.out.println(t.nadir());
		System.out.println(t.leafCt());
		System.out.println(t.balanced());
		System.out.println(t.successor("a"));
	}

}
