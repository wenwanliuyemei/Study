package com.xm.study.dataalgorithm.view;

import com.xm.study.dataalgorithm.model.bintree.BinTreeNode;

import java.util.List;

/**
 * Created by zhangxiumei on 2017/3/13.
 */

public interface IDataAlgorithmView {

    void insertSortDone();

    void bubbleSort1Done();

    void bubbleSort2Done();

    void quickSortDone();

    void selectionSortDone();

    void shellSortDone();

    void sequentialSortDone();

    void binTreeSortDone();

    void isSameTreeDone(boolean isSameTree);

    void isSymmetricDone(boolean isSymmetric);

    void levelOrderDone(String text);

    void zigzagLevelOrderDone(String text);

    void maxDepthDone(int depth);

    void countOneInBinaryDone();

    void maxSumDone();
}
