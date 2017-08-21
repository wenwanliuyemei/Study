package com.xm.study.datastructure.model.set;

/**
 * 作者：xm on 2017/3/21 17:22
 * 描述：按成绩大小排列对象
 */
public class TreeSetStudent implements Comparable {

    private String name;
    private int codeEnglish = 0;

    public TreeSetStudent(String name, int codeEnglish) {
        this.name = name;
        this.codeEnglish = codeEnglish;
    }

    @Override
    public int compareTo(Object student) {
        TreeSetStudent treeSetStudent = (TreeSetStudent) student;
        //按成绩大小排列对象
        //树集中不容许存在2个大小相等的节点，不过可以这样处理
        int code = this.codeEnglish - treeSetStudent.codeEnglish;
        if (code == 0) {
            return 1;
        } else {
            return (this.codeEnglish - treeSetStudent.codeEnglish);
        }
    }
}
