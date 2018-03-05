package struct.link;

public class SeqList_test {
	
	 public static void main(String args[]) {
        //空表
        SeqList<String> lista = new SeqList<String>(4);
        System.out.println("lista is empty: "+lista.toString());
        //扩容
        for (int i = 5; i >= 0; i--) {
            lista.insert(i, new String((char)('A' + i) + ""));
        }
        System.out.println("lista insert finished: "+lista.toString());
        lista.set(3, new String((char)(lista.get(3).charAt(0) + 32) + ""));
        System.out.println("lista set 3 : "+lista.toString());
        lista.remove(0);
        System.out.println("lista remove 0 position: "+lista.toString());
        lista.remove(3);
        System.out.println("lista remove 3 position: "+lista.toString());
        System.out.println(lista.search("B"));
        ;
	 }

}
