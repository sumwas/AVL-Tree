package AVL;
public class TestAVL2 {

	public static void main(String[] args) {
		StringAVLTreeXtra t = new StringAVLTreeXtra();
		String str;
		int ct, ran = 87, ransave=0, line = 1, ansct=0, num;
		boolean delete = false;
		char action;
		String s = "oimaoinaoioaoipaoiqaoilaoikaoikdikgikfikeoinaikgikaiqaioaoI15oI99onI50os50";
		String ans[] = {
/*  1 */	"0 0 0 0",
/*  2 */	"(ma)(0)1 1 1 1",
/*  3 */	"(ma(na))(1(0))1 2 1 2",
/*  4 */	"((ma)na(oa))((0)0(0))2 2 3 2",
/*  5 */	"((ma)na(oa(pa)))((0)1(1(0)))2 3 2 2",
/*  6 */	"((ma)na((oa)pa(qa)))((0)1((0)0(0)))3 3 4 2",
/*  7 */	"(((la)ma)na((oa)pa(qa)))(((0)-1)0((0)0(0)))3 3 5 3",
/*  8 */	"(((ka)la(ma))na((oa)pa(qa)))(((0)0(0))0((0)0(0)))4 3 7 3",
/*  9 */	"(((ka)kd((ke)kf))kg((la(ma))na((oa)pa(qa))))(((0)1((0)-1))0((1(0))0((0)0(0))))5 4 8 3",
/* 10 */	"(((ka)kd((ke)kf))kg((la(ma))na((oa)pa(qa))))(((0)1((0)-1))0((1(0))0((0)0(0))))5 4 8 3",
/* 11 */	"((((((aqu)cdf(ejc))ka(kae))kd((ke)kf))kg((la(lhx))ma(mlh(mrg))))na((((naj)oa(orq))pa(pln))qa((qiq(tvb))uwp(yfo(zif)))))((((((0)0(0))-1(0))-1((0)-1))-1((1(0))0(1(0))))-1((((0)0(0))-1(0))0((1(0))0(1(0)))))11 6 16 4",
/* 12 */	"(((((((aka(apa))aqs(aqu(axb)))cdf(((cff)chj)clw((cug)cxs(ddg))))dkr((dpx)dsx((dvd)dyp(edc))))ejc((((epa)esn((fgq)fwu))gbg((giz(gly))gma(gws)))hdo((((hqv)iry(ive))ixt(ixy))jgz((joh)jyc))))ka((((kae(kao))kd((ke)kf))kg(((kpc)la(lds))lev(lhx(lne))))loj(((lsc)lzc)ma(((mfc)mlh)mrg(mrj)))))na((((((naj)net(nmn))nnq((nps)nvq))oa(((ocx)ogx((onb)orq(otq)))pa((pln)pph(pqr(pzv)))))qa((((qei)qiq)qpx((qrs)qsm((qyc)rfn)))rku(((rmq)rpr((rxu)seh))sgb((shl(shv))tdl(tje(tqf))))))tvb((((ucx)uel((uem)uio(uje)))uwp((((vco)vik(vlx))vod((vzc)wdk(wkp)))wmh((wua)xic)))xjt((((xmp)xvh(xvz))yan(ybh))yfo(((yil)ynt(ysk))zfc(zif(zqc)))))))(((((((1(0))0(1(0)))0(((0)-1)0((0)0(0))))-1((0)1((0)0(0))))0((((0)1((0)-1))0((1(0))-1(0)))0((((0)0(0))-1(0))-1((0)-1))))-1((((1(0))0((0)-1))0(((0)0(0))0(1(0))))0(((0)-1)1(((0)-1)-1(0)))))0((((((0)0(0))0((0)-1))1(((0)1((0)0(0)))0((0)1(1(0)))))0((((0)-1)1((0)1((0)-1)))0(((0)1((0)-1))0((1(0))0(1(0))))))0((((0)1((0)0(0)))1((((0)0(0))0((0)0(0)))-1((0)-1)))-1((((0)0(0))-1(0))0(((0)0(0))0(1(0)))))))53 8 85 6",
/* 13 */	"((((((all)bkx(blp))bpj((bxa)cer(cfw)))cst((((drg)etj)fcl((ftz)gkn(gnw)))gxc(hcr(hfk))))hkx(((icj)iei((iod)jtq(khx)))kjj((lov)mld)))mwq(((((mxx)ncj(nfn))njv(nrm(okg)))our(((pih)pmt(pyk))qez((qjo)sjv(sjw))))ssz(((vkg)wcs(xeh(xja)))yif((yzm)znv(zue)))))((((((0)0(0))0((0)0(0)))1((((0)-1)0((0)0(0)))-1(1(0))))-1(((0)1((0)0(0)))-1((0)-1)))-1(((((0)0(0))0(1(0)))0(((0)0(0))0((0)0(0))))0(((0)1(1(0)))-1((0)0(0)))))23 7 37 5",
/* sc */	"icj vkg mxx lov qjo hcr mwq xja zue bpj drg kjj nrm mld iod ftz sjw cfw bxa yzm xeh pih NULL pyk ssz okg njv iei znv cer jtq wcs hfk pmt cst our nfn gkn khx bkx blp fcl qez hkx ncj etj yif gnw gxc sjv NULL NULL NULL NULL NULL "};

		do {
			action = s.charAt(0);
			if (action == 'i') {   // insert
				str = s.substring(1,3);
				s = s.substring(3, s.length());
				t.insert(str);
			} else if (action == 'j') {   // insert
				str = s.substring(1,4);
				s = s.substring(4, s.length());
				t.insert(str);
			} else if (action == 'n') {  // new tree -- wipe out the tree and start over
				s = s.substring(1, s.length());
				t = new StringAVLTreeXtra();
			} else if (action == 'I') {
				ransave = ran;
	            num = (s.charAt(1) - '0') * 10 + s.charAt(2) - '0';
	            s = s.substring(3, s.length());
	            for (ct = 1; ct <= num; ct++) {
	               ran = (ran * 101 + 103) % 1000003;
	               str= String.valueOf((char) (ran%26+'a'));
	               ran = (ran * 101 + 103) % 1000003;
	               str+= String.valueOf((char) (ran%26+'a'));
	               ran = (ran * 101 + 103) % 1000003;
	               str+= String.valueOf((char) (ran%26+'a'));
	               t.insert(str);
	            }
			} else if (action == 's') {
				String res = new String(), succ;
				ran = ransave;
	            num = (s.charAt(1) - '0') * 10 + s.charAt(2) - '0';
	            s = s.substring(3, s.length());
	            for (ct = 1; ct <= num; ct++) {
	               ran = (ran * 101 + 103) % 1000003;
	               str= String.valueOf((char) (ran%26+'a'));
	               ran = (ran * 101 + 103) % 1000003;
	               str+= String.valueOf((char) (ran%26+'a'));
	               ran = (ran * 101 + 103) % 1000003;
	               str+= String.valueOf((char) (ran%26+'a'));
	               succ = t.successor(str);
	               if (succ != null)
	            	   res += succ + " ";
	               else
	            	   res += "NULL ";
	            }
			   succ = t.successor("aaa");
			   if (succ != null)
				   res += succ + " ";
			   else
				   res += "NULL ";
			   succ = t.successor("ccc");
			   if (succ != null)
				   res += succ + " ";
			   else
				   res += "NULL ";
			   succ = t.successor("nnn");
			   if (succ != null)
				   res += succ + " ";
			   else
				   res += "NULL ";
			   succ = t.successor("vvv");
			   if (succ != null)
				   res += succ + " ";
			   else
				   res += "NULL ";
			   succ = t.successor("zzz");
			   if (succ != null)
				   res += succ + " ";
			   else
				   res += "NULL ";
				if (res.compareTo(ans[ansct]) == 0)
					System.out.println("     Answers match in successor.   ");
				else {
					System.out.println("   *** NO MATCH IN SUCCESSOR ***   ");
					System.out.println(res);
				}
				//t.display(); System.out.println();
				ansct++;
	        } else {  // no other choice, then compare
				s = s.substring(1, s.length());
				System.out.print(line++ + ". ");
				if (t.toString2().compareTo(ans[ansct]) == 0) {
					System.out.print(" Answers match.   ");
					if ( line % 4 == 1)
						System.out.println();
				}
				else {
					System.out.println("   *** NO MATCH ***   ");
					System.out.println(t.toString2());
				}
//				System.out.println(); t.display(); System.out.println();
//				System.out.println();
//				System.out.println(t.toString2());
				
				ansct++;
			}
		} while (s.length() != 0);
		System.out.println("Programmed by: " + StringAVLTree.myName());
	}
}

class StringAVLTreeXtra extends StringAVLTree {

	public StringAVLTreeXtra() {
		super();
	}
	
	public StringAVLNode getRoot() {
	return root;
	}

	public void display() {
		paren_out(getRoot());
		System.out.println();
		bal_out(getRoot());
	}

	public void paren_out(StringAVLNode t) {
		if (t == null) {
		} else {
			System.out.print("(");
			paren_out(t.getLeft());
			if (t.getItem().length() <= 1)
				System.out.print(" ");
			System.out.print(t.getItem());
			paren_out(t.getRight());
			System.out.print(")");
		}
	}

	public void bal_out(StringAVLNode t) {
		if (t == null) {
		} else {
			System.out.print("(");
			bal_out(t.getLeft());
			if (t.getItem().length() == 3)
				System.out.print(" ");
			if (t.getBalance() == -1)
				System.out.print(t.getBalance());
			else
				System.out.print(" " + t.getBalance());
			bal_out(t.getRight());
			System.out.print(")");
		}
	}
	
	public String paren_out1(StringAVLNode t) {
		String s;
		if (t == null) {
			s = new String();
		} else {
			s="(" + paren_out1(t.getLeft())+t.getItem()+paren_out1(t.getRight())+")";
		}
		return s;
	}

	public String bal_out1(StringAVLNode t) {
		String s;
		if (t == null) {
			s = new String();
		} else {
			s="("+bal_out1(t.getLeft())+t.getBalance()+bal_out1(t.getRight())+")";
		}
		return s;
	}
	
	public String toString2() {
			String s = new String();
			s = paren_out1(getRoot())+bal_out1(getRoot())+String.valueOf(this.leafCt())+" "+
			    String.valueOf(this.height())+" "+String.valueOf(this.balanced())+" "+String.valueOf(this.nadir());
			return s;
	}
}