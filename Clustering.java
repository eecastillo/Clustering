public class Clustering{
    public static void main(String[] args){
        
        int elementos []={1,4,2,5,15,8,19,6,20,6,1,4,8,3,7,1,2,4};
        cluster arrcluster[]=new cluster[elementos.length];
        int max=0;
        int clusters = elementos.length;
        for(int i=0;i<elementos.length;i++){
            if(elementos[i]>max){
                max=elementos[i];
            }
        }
        for(int i=0;i<arrcluster.length;i++){
            arrcluster[i]=new cluster(i);
            arrcluster[i].setNumber(elementos[i]);
            arrcluster[i].setDistance(elementos[i]/(max+0.0f));
        }
        do{
            int x=0;
            int y=1;
            for(int i=0;i<arrcluster.length;i++){
                for(int j=1;j<arrcluster.length;j++){
                    if(arrcluster[i] !=null && arrcluster[j] !=null && i!=j){
                        if(Math.abs(arrcluster[i].getDistance()-arrcluster[j].getDistance()) < Math.abs(arrcluster[x].getDistance()-arrcluster[y].getDistance())){
                            x=i;
                            y=j;
                            //System.out.printf("%d %d\n",arrcluster[i].getNumber(),arrcluster[j].getNumber());
                        }
                    }
                }
            }
            cluster current=arrcluster[x];
            
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=arrcluster[y];
            arrcluster[y]=null;
            //arrcluster[x].setProm();
           // current=arrcluster[x];

            /*while(current!=null){
                System.out.print(current);
                current=current.next;
            }*/

            System.out.printf("%d %d\n",x,y);
            clusters--;
        }while(clusters != 2);
        for(int i=0;i<arrcluster.length;i++){
            if(arrcluster[i]!=null){
                cluster current=arrcluster[i];
                while(current!=null){
                    System.out.print(current);
                    current=current.next;
                }
                System.out.println();

            }
        }
    }
}
//clase para almacenar las propiedades de un cluster en 1 dimension
class cluster{
    private int index=0;
    private int number=0;
    private float distance=0;
    cluster next = null;
    public cluster(int index){
        this.index=index;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public void setDistance(float distance){
        this.distance=distance;
    }
    public int getNumber(){
        return this.number;
    }
    public float getDistance(){
        return this.distance;
    }
    public void setProm(){
        cluster este=this;
        float prom=0;
        int i;
        for(i=1;este!=null;i++,este=este.next)
            prom+=este.getDistance();
        this.distance=prom/i;
    }

    @Override
    public String toString(){
        return String.format("%d: %d %f, ",this.index,this.number,this.distance);
    }
}