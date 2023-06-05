package dataStructure;

import java.util.*;

/**
 * LRU缓存，
 * 什么是LRU缓存？本质上是缓存，着重考察缓存淘汰的设计。
 *
 */
public class LRUCache146 {
    Map<Integer,Integer> cache = new HashMap<>();
    LinkedList<Integer> lk = new LinkedList();
    int cap=0;

    public static void main(String[] args) {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1,2);
        System.out.println(m);

        Iterator<Map.Entry<Integer, Integer>> iterator = m.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();//没有next，iterator会失败的。。
            iterator.remove();//You haven't called next() on your Iterator, so it's not referring to the
            // first item yet. You can't remove the item that isn't specified yet.
            // Call next() to advance to the first item first, then call remove().
        }
        System.out.println(m);
        LRUCache146 lRUCache = new LRUCache146(2);
        lRUCache.put2(1, 1); // 缓存是 {1=1}
        lRUCache.put2(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get2(1);    // 返回 1
        lRUCache.put2(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get2(2);    // 返回 -1 (未找到)
        lRUCache.put2(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get2(1);    // 返回 -1 (未找到)
        lRUCache.get2(3);    // 返回 3
        lRUCache.get2(4);    // 返回 4

    }

    /**
     *  * 思路一：使用队列+map来实现，
     *  * 1、put逻辑：
     *      1.1 key已存在：调整key到队列头部位置（先删除，再插入）
     *      1.2 key不存在：
     *          1.2.1 列表元素==容量，队列已满，删除队尾元素及对应map，插入新元素到头部位置及map。
     *          1.2.2 队列未满，插入新元素到头部位置及map
     *  * 2、get逻辑：
     *      2.1 如果map.get(key)存在，返回map.get(key)，并调整key位置至头部。
     *      2.2 如果map.get(key)不存在，返回-1。
     *
     *   复杂度：put或get是O(n)
     * @param capacity
     */
//    public LRUCache146(int capacity) {
//        cap=capacity;
//    }

    public int get(int key) {
        int val = cache.get(key)==null?-1: cache.get(key);
        if(val!=-1){//如果缓存中存在，才需要重新调整到头部去。
            lk.removeFirstOccurrence(key);
            lk.addFirst(key);
        }
        return val;//返回是int，需判空 ！！！
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){//如果存在key，先删除，再插入。
            lk.removeFirstOccurrence(key);
            lk.addFirst(key);
            cache.put(key,value);
            return;
        }

        if(lk.size()==cap){//队列满，淘汰队尾元素
            int k = lk.getLast();
            lk.removeLast();
            cache.remove(k);
            cache.put(key,value);
            lk.addFirst(key);
        } else {
            cache.put(key,value);
            lk.addFirst(key);
        }
    }

    /**
     * 思路二：使用linkedhashmap，linkedhashmap可保证访问顺序。
     * 两个设计难点，
     * 1、如何保证访问顺序： linkedhashmap 底层使用双向链表实现，初始化时accessOrder定义为true即可
     * 2、如何设计淘汰策略？ 使用一个容量字段，每次put时，比较当前元素个数和容量，如果已经超出容量，则需要淘汰。
     * @param key
     * @param value
     */
    private LinkedHashMap<Integer,Integer> cache2=new LinkedHashMap<>();
    public void put2(int key,int value){
        if(cache2.containsKey(key)){
            cache2.put(key,value);
            return;
        }
        if(cap==cache2.size()){//队列满了，淘汰key，第一个key是最久未被访问的key
//            Iterator<Map.Entry<Integer, Integer>> iterator = cache2.entrySet().iterator();
//            while (iterator.hasNext()){
//                iterator.next();//需要先移动next，iterator才会指向第一个item
//                iterator.remove();
//                break;
//            }
            cache2.remove(cache2.keySet().iterator().next());//remove 第一个key即可
            cache2.put(key,value);
        }else {
            cache2.put(key,value);
        }
        System.out.println(cache2);
    }

    public int get2(int key) {
        Integer val = cache2.get(key);
        if(val==null){
            val=-1;
        }
        System.out.println(val);
        return val;
    }
    public LRUCache146(int capacity) {
        cache2=new LinkedHashMap<>(capacity,0.75f,true);//accessOrder为true时，保证的访问顺序；capacity是容量，超过容量会扩容，而不是删除
        cap=capacity;
    }
    
}
