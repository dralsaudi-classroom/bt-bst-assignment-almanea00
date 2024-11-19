package com.example.project;

public class TreeUser {
    public static <T> int countLeaves(BT<T> bt) {
		if(bt.empty())
			return 0;
		
		bt.find(Relative.Root);
		return countLeafRec(bt);
    	
    }
    public static <T> int countLeafRec(BT<T> bt) {
		if(bt.isLeaf())
			return 1;
		
		int counter = 0;
		if(bt.find(Relative.LeftChild)) {
			counter += countLeafRec(bt);
			bt.find(Relative.Parent);
		}
		if(bt.find(Relative.RightChild)) {
			counter += countLeafRec(bt);
			bt.find(Relative.Parent);
		}
		return counter;
    }
}