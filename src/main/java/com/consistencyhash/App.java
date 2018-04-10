package com.consistencyhash;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cluster cluster = createCluster();
//        Entry[] entries = {
//                new Entry("afds"),new Entry("bfds"),new Entry("chg"),new Entry("dk"),new Entry("dew"),new Entry("dnbv")
//        };
        Entry[] entries = {
                new Entry("i"),
                new Entry("have"),
                new Entry("a"),
                new Entry("pen"),
                new Entry("an"),
                new Entry("apple"),
                new Entry("applepen"),
                new Entry("pineapple"),
                new Entry("pineapplepen"),
                new Entry("PPAP")
        };
        for (Entry entry : entries){
            cluster.put(entry);
        }
//        findEntries(cluster,entries);
        cluster.addServer(new Server("192.168.0.6"));
//
        findEntries(cluster,entries);

    }

    private static Cluster createCluster(){
        Cluster c = new Cluster();
        c.addServer(new Server("international"));
        c.addServer(new Server("china"));
        c.addServer(new Server("japan"));
        c.addServer(new Server("Amarica"));
        c.addServer(new Server("samsung"));
        return c;
    }
    private static void findEntries(Cluster c, Entry[] entries) {
        for (Entry e : entries) {
            if (e == c.get(e)) {
                System.out.println("重新找到了entry:" + e + " server: " + c.getServer(e));
            } else {
                System.out.println("entry已失效:" + e);
            }
        }
    }
}
