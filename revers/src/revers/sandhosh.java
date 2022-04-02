package revers;

public class sandhosh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 String s="sandhoshpandi";
 String s1=s.substring(0, 4);
 String s2=s.substring(4, 8);
 String s3=s.substring(8, 12);
 String s4=s.substring(12, 13);
 System.out.println(s1+" "+s2+" "+s3+" "+s4);
 for(int i=s1.length()-1;i>=0;i--) {
	 System.out.print(s1.charAt(i));
 }
 System.out.println(" ");
 for(int i=s2.length()-1;i>=0;i--) {
	 System.out.print(s2.charAt(i));
 }
 System.out.println(" ");
 for(int i=s3.length()-1;i>=0;i--) {
	 System.out.print(s3.charAt(i));
 }
	}

}
