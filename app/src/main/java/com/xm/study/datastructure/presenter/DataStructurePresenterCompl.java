package com.xm.study.datastructure.presenter;

import android.content.Context;
import android.util.Log;

import com.xm.study.datastructure.model.set.TreeSetStudent;
import com.xm.study.datastructure.model.string.ForCircleCompare;
import com.xm.study.datastructure.model.string.FormatOutput;
import com.xm.study.datastructure.model.string.FormatOutputFormatter;
import com.xm.study.datastructure.model.string.FormatSpecifier;
import com.xm.study.datastructure.model.string.HexOutput;
import com.xm.study.datastructure.model.string.MemoryAddress;
import com.xm.study.datastructure.utils.StringUtils;
import com.xm.study.datastructure.view.IDataStructureView;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;

/**
 * 作者：xm on 2017/2/6 17:21
 * 描述：
 */
public class DataStructurePresenterCompl implements IDataStructurePresenter {

    private final String TAG = this.getClass().getSimpleName();
    private Context context;
    private IDataStructureView mIDataStructureView;

    public DataStructurePresenterCompl(Context context, IDataStructureView iDataStructureView) {
        this.context = context;
        mIDataStructureView = iDataStructureView;
    }

    @Override
    public void upCase() {
        String q = "howdy";
        Log.e(TAG, "q=" + q);// q=howdy
        String qq = StringUtils.upcase(q);
        Log.e(TAG, "qq=" + qq);//qq=HOWDY
        Log.e(TAG, "q" + q);//qhowdy
        mIDataStructureView.upCaseDone();
    }

    @Override
    public void forCircleCompare(String[] strings) {
        ForCircleCompare.stringForCircle(strings);
        ForCircleCompare.stringBuilderForCircle(strings);
        ForCircleCompare.stringBufferForCircle(strings);
        mIDataStructureView.forCircleCompareDone();
    }

    @Override
    public void memoryAddress() {
        List<MemoryAddress> memoryAddressList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            memoryAddressList.add(new MemoryAddress());
        }
        Log.e(TAG, "memoryAddressList=" + memoryAddressList);
        //memoryAddressList=[
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@4170ae08,
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@41659668,
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@416f4a70,
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@41703358,
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@41672a30,
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@4165c8d0,
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@416f53f8,
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@417055b0,
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@4165b770,
        // MemoryAddress=com.xm.study.datastructure.model.string.MemoryAddress@416ccb98]
        mIDataStructureView.memoryAddressDone();
    }

    @Override
    public void formatOutput() {
        FormatOutput.printf(10, 10.22d);
        FormatOutput.printf(10.2f, 10.22d);
        FormatOutput.format(10, 10.22f);
        FormatOutput.format(10.5f, 10.22d);
        mIDataStructureView.formatOutputDone();
        //I/System.out: printf:[10 10.220000]
        //I/System.out: printf:[10.200000 10.220000]
        //I/System.out: format:[10 10.220000]
        // E/format: format:[10 10.220000]
        //I/System.out: format:[10.500000 10.220000]
        // E/format: format:[10.500000 10.220000]
    }

    @Override
    public void formatOutputFormatter() {
        FormatOutputFormatter tommy = new FormatOutputFormatter("Tommy", new Formatter(System.out));
        PrintStream printStream = System.out;
        FormatOutputFormatter terry = new FormatOutputFormatter("Terry", new Formatter(printStream));
        tommy.move(0, 0f);
        tommy.move(4, 8);
        terry.move(2, 5);
        terry.move(3, 3.6f);
        //I/System.out: Tommy The FormatOutputFormatter is at(0,0.000000)
        //I/System.out: Tommy The FormatOutputFormatter is at(4,8)
        //I/System.out: Terry The FormatOutputFormatter is at(2,5)
        //I/System.out: Terry The FormatOutputFormatter is at(3,3.600000)
        mIDataStructureView.formatOutputFormatterDone();
    }

    @Override
    public void formatSpeciifier() {
        FormatSpecifier formatSpecifier = new FormatSpecifier();
        formatSpecifier.printTitle();
        formatSpecifier.print("Jack's Magic Beans", 4, 4.25);
        formatSpecifier.print("Princess Peas", 3, 5.1);
        formatSpecifier.print("Three Bears Porridge", 1, 14.29);
        formatSpecifier.printTotal();
        mIDataStructureView.formatSpeciifierDone();
    }

    @Override
    public void hexOutput(byte[] data) {
        Log.e(TAG, HexOutput.format(data));
        mIDataStructureView.hexOutputDone();
    }

    @Override
    public void treeSetStudent() {
        //TreeSet(Comparator cmparator)创建一个树集，
        // 通过参数cmparator规定树集的节点怎样排序。
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object student1, Object student2) {
                TreeSetStudent treeSetStudent1 = (TreeSetStudent) student1;
                TreeSetStudent treeSetStudent2 = (TreeSetStudent) student2;
                return treeSetStudent1.compareTo(treeSetStudent2);
            }
        });

        TreeSetStudent treeSetStudent1 = new TreeSetStudent("a", 90);
        TreeSetStudent treeSetStudent2 = new TreeSetStudent("b", 70);
        TreeSetStudent treeSetStudent3 = new TreeSetStudent("c", 65);
        TreeSetStudent treeSetStudent4 = new TreeSetStudent("d", 95);
        TreeSetStudent treeSetStudent5 = new TreeSetStudent("d", 95);
        treeSet.add(treeSetStudent1);
        treeSet.add(treeSetStudent2);
        treeSet.add(treeSetStudent3);
        treeSet.add(treeSetStudent4);
        treeSet.add(treeSetStudent5);
        Log.e(TAG, "treeSet=" + treeSet.toString());
        mIDataStructureView.treeSetStudentDone();
    }

    @Override
    public void treeTable() {
        String[] keys = {"语文", "数学", "英语", "政治"};
        String[] values = {"88", "99", "96", "92"};
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < keys.length; i++) {
            hashtable.put(keys[i], values[i]);
        }
        Enumeration enumeration1 = hashtable.keys();
        Object object;
        while (enumeration1.hasMoreElements()) {
            object = enumeration1.nextElement();
            Log.e(TAG, "treeTable--object=" + object);
        }
        mIDataStructureView.treeTableDone();
    }
}
