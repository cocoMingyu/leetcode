package graph;

/**
 * @ Author : kn
 * @ Description :208. 实现 Trie (前缀树)
 * 中等
 * 相关标签
 * 相关企业
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 */
public class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        //26颗子树
        children=new Trie[26];
        isEnd=false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            //当前字母没有对应节点，创建一个新的节点
            if (node.children[index]==null){
                node.children[index]=new Trie();
            }
            //重置node，将当前节点指向下一个节点
            node=node.children[index];
        }
        //循环结束，将多级树的最后一个节点标记为结束
        node.isEnd=true;
    }

    public boolean search(String word) {
        Trie trie = startPrefix(word);
        return trie!=null&& trie.isEnd;
    }

    public Trie startPrefix(String prefix) {
        Trie node = this;
        for (int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i) - 'a';
            node = node.children[index];
            if (node==null){
                return null;
            }
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return startPrefix(prefix)!=null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        boolean case1 = trie.search("ab");
        boolean case2 = trie.startsWith("a");
        boolean case3 = trie.search("a");
        trie.insert("abc");
        boolean case4 = trie.search("abc");
        boolean case5 = trie.startsWith("ab");
        boolean case6 = trie.startsWith("ac");

        System.out.println();
    }
}
