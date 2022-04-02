package medeil;

public class reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer n[]= {1,2,3,4,5};
        int j=n.length;
        for(int i=0;i<=2;i++) {
        	for(int k=1;k<=2;i++) {
        	if(n[i]<n[k]) {
        	   n[i]=n[k]+n[i]-(n[k]=n[i]);
        	}
        }
	}System.out.println(n);

}}
