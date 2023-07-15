package com.ak.Tries;

//A trie (derived from retrieval) is a multiway tree data structure used for storing strings over an alphabet.
// It is used to store a large amount of strings. The pattern matching can be done efficiently using tries.
//Trie is also known as digital tree or prefix tree. Refer to this article for more detailed information.
//If we store keys in a binary search tree, a well-balanced BST will need time proportional to M * log N, where M is the maximum string length and N is the number of keys in the tree


public class Tries {
      public static void insert(String str,Node root){
//          Every character of the input key is inserted as an individual Trie node. Note that the children is an array of pointers (or references) to next-level trie nodes.
//          The key character acts as an index to the array children.
//          If the input key is new or an extension of the existing key, construct non-existing nodes of the key, and mark the end of the word for the last node.
//          If the input key is a prefix of the existing key in Trie, Simply mark the last node of the key as the end of a word.

          Node current = root;
          for (int i = 0; i < str.length(); i++) {
              int index = str.charAt(i) - 'a';
              if (current.children[index] == null) {
                  current.children[index] = new Node();
              }
              current = current.children[index];
          }
          current.isTerminal = true;
      }

      public static boolean search(String str,Node root){
          //it will return true if the trie contains the corresponding key else false
          Node current = root;
          for (int i = 0; i < str.length(); i++) {
              int index = str.charAt(i) - 'a';
              if (current.children[index] == null)
                  return false;

              current = current.children[index];
          }
          return current.isTerminal;
      }

      public static boolean isEmpty(Node root){
          for (int i = 0; i < 26; i++)
              if (root.children[i] != null)
                  return false;
          return true;
      }

      public static Node delete(Node node , String key , int i){
          //if trie is empty return null
          if(node==null) return null;

          if(i==key.length()){
              node.isTerminal=false;
              if (isEmpty(node)){
                  node=null;
              }
              return node;
          }

          int index=key.charAt(i)-'a';
          node.children[index]=delete(node.children[index],key,i+1);

          if (isEmpty(node) && !node.isTerminal){
              node=null;
          }
          return node;

      }

    public static void main(String[] args) {

       Node root=new Node();
       insert("ambar",root);
       insert("bat",root);
       insert("bad",root);
       insert("zoo",root);
       insert("ram",root);

        System.out.println(search("ambar",root));
        System.out.println(search("akhbar",root));
        System.out.println(search("zoo",root));
        delete(root,"zoo",0);
        System.out.println(search("zoo",root));
    }
}
