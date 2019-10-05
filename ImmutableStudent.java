import java.util.HashMap;
import java.util.Iterator;
final class ImmutableStudent{
    private final int mId;
    private final String mName;
    private final HashMap<String,String> mStdMap;

    public int getId(){
        return mId;
    }
    public String getName(){
        return mName;
    }

    public HashMap<String, String> getStdMap() {
        return (HashMap<String, String>)mStdMap.clone();
    }

    /**
            * Constructor performing Deep Copy
	 * @param id
	 * @param name
	 * @param hm
	 */
//    public ImmutableStudent(int id,String name,HashMap<String,String>hm){
//        System.out.println("Performing Deep Copy for Object initialization");
//        this.mId=id;
//        this.mName=name;
//        HashMap<String,String> tempMap=new HashMap<String,String>();
//        String key;
//        Iterator<String> it = hm.keySet().iterator();
//        while(it.hasNext()){
//            key=it.next();
//            tempMap.put(key, hm.get(key));
//        }
//        this.mStdMap=tempMap;
//    }
/**
 * Constructor performing Shallow Copy
 * @param i
 * @param n
 * @param hm
 */

     public ImmutableStudent(int i, String n, HashMap<String,String> hm){
     System.out.println("Performing Shallow Copy for Object initialization");
     this.mId=i;
     this.mName=n;
     this.mStdMap=hm;
     }

    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String,String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i=10;

        ImmutableStudent ce = new ImmutableStudent(i,s,h1);

        //Lets see whether its copy by field or reference
        System.out.println(s==ce.getName());
        System.out.println(h1 == ce.getStdMap());//returns false
        //print the ce values
        System.out.println("ce id:"+ce.getId());
        System.out.println("ce name:"+ce.getName());
        System.out.println("ce testMap:"+ce.getStdMap());
        //change the local variable values
        i=20;
        s="modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:"+ce.getId());
        System.out.println("ce name after local variable change:"+ce.getName());
        System.out.println("ce testMap after local variable change:"+ce.getStdMap());

        HashMap<String, String> hmTest = ce.getStdMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:"+ce.getStdMap());

    }
}