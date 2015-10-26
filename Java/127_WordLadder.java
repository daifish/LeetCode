/*************************************************************************
    > File Name: 127_WordLadder.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 一 10/26 14:13:14 2015
    java中的数据类型，可分为两类： 
1.基本数据类型，也称原始数据类型。byte,short,char,int,long,float,double,boolean 
  他们之间的比较，应用双等号（==）,比较的是他们的值。 
2.复合数据类型(类) 
  当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址，所以，除非是同一个new出来的对象，他们的比较后的结果为true，否则比较后结果为false。 JAVA当中所有的类都是继承于Object这个基类的，在Object中的基类中定义了一个equals的方法，这个方法的初始行为是比较对象的内存地 址，但在一些类库当中这个方法被覆盖掉了，如String,Integer,Date在这些类当中equals有其自身的实现，而不再是比较类在堆内存中的存放地址了。
  对于复合数据类型之间进行equals比较，在没有覆写equals方法的情况下，他们之间的比较还是基于他们在内存中的存放位置的地址值的，因为Object的equals方法也是用双等号（==）进行比较的，所以比较后的结果跟双等号（==）的结果相同。
 ************************************************************************/
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList.size() == 0) {
            return 0;
        }
        
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        
        wordQueue.add(beginWord);
        distanceQueue.add(1);
        
        while (!wordQueue.isEmpty()) {
            String curWord = wordQueue.pop();
            Integer curDistance = distanceQueue.pop();
            if (curWord.equals(endWord)) {
                return curDistance;
            }
            
            for (int i = 0; i < curWord.length(); i ++) {
                char[] curArr = curWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c ++) {
                    curArr[i] = c;
                    String newWord = new String(curArr);
                    if (wordList.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(curDistance + 1);
                        wordList.remove(newWord);
                    }
                }
            }
        }
        
        return 0;
    }
}
