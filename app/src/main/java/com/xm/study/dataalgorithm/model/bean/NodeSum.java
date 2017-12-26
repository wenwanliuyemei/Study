package com.xm.study.dataalgorithm.model.bean;

/**
 * @author: xm on 2017/12/26.
 * @describe:
 */

public class NodeSum implements Comparable<NodeSum> {

    public int val;
    public int idx;

    public NodeSum() {
    }

    public NodeSum(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(NodeSum o) {
        if (o == null) {
            return -1;
        }
        return this.val - o.val;
    }
}
