package revers;

public class vr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[]= {1,2,3,4,5,6};
          int k=1;
          for(int i=0;i<k;i++) {
        	  int temp=a[i];
        	  a[i]=a[i+1];
        	  a[i+1]=temp;
          }
          for(int i=0;i<a.length;i++) {
        	  System.out.print(a[i]+" ");  
          }
          
	}

}
