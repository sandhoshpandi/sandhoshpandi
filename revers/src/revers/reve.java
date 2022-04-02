package revers;



public class reve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Integer n[]= {1,2,0,4,5,6};
int start=2,end=4;
Integer o[]=new Integer[n.length-start+end];
for(int i=start;i<end;i++) {
	o[i]=n[i];
}
for(int i=0;i<o.length;i++) {
	if(o[i]!=null) {
		o[i]=o[i];
		System.out.print(o[i]+" ");
	}
	
}
}
}