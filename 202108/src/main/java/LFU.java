import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @ClassName LFU
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/239:09
 * @Version 1.0
 */
public class LFU {

    Map<Integer, Node> cache;  // 存储缓存的内容

    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    //linkedHashSet可以保证以插入的先后顺序对原本无序的 HashSet 进行迭代
    int size;//当前已用空间
    int capacity;//容量
    int min; // 存储当前最小频次

    public LFU(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;

    }

    class Node {
        int key;
        int value;
        int freq = 1;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //更新一次频次
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    //频次相同，则应该去除最久未使用
    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;

    }


}
