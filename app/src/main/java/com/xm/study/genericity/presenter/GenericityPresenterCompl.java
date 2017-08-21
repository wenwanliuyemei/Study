package com.xm.study.genericity.presenter;

import android.content.Context;
import android.util.Log;

import com.xm.study.genericity.model.BaseGenerator;
import com.xm.study.genericity.model.CountedObject;
import com.xm.study.genericity.model.DogCompl;
import com.xm.study.genericity.model.Life;
import com.xm.study.genericity.model.LinkedStackCompl;
import com.xm.study.genericity.model.RandomListCompl;
import com.xm.study.genericity.model.TwoTuple;
import com.xm.study.genericity.model.coffee.Coffee;
import com.xm.study.genericity.model.coffee.CoffeeGeneratorCompl;
import com.xm.study.genericity.model.complexmodel.Store;
import com.xm.study.genericity.model.fibonacci.FibonacciGeneratorCompl;
import com.xm.study.genericity.model.fibonacci.IterableFibonacci;
import com.xm.study.genericity.model.innerclass.Customer;
import com.xm.study.genericity.model.innerclass.Teller;
import com.xm.study.genericity.model.interfacee.IGenerator;
import com.xm.study.genericity.model.method.GenericMethods;
import com.xm.study.genericity.model.method.GenericVarargs;
import com.xm.study.genericity.model.method.MethodGenerators;
import com.xm.study.genericity.model.method.New;
import com.xm.study.genericity.model.method.SetNew;
import com.xm.study.genericity.model.method.TupleNewTest;
import com.xm.study.genericity.model.method.Watercolors;
import com.xm.study.genericity.view.IGenericityView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * Created by zhangxiumei on 2017/1/5.
 */

public class GenericityPresenterCompl implements IGenericityPresenter {

    private final String TAG = this.getClass().getSimpleName();
    private Context mContext;
    private IGenericityView mIGenericityView;

    public GenericityPresenterCompl(Context context, IGenericityView iGenericityView) {
        this.mContext = context;
        mIGenericityView = iGenericityView;
    }

    static void f(Map<String, List<String>> stringListMap) {
    }

    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    @Override
    public void getAnimal() {
        Life<DogCompl> dogCompl0 = new Life<DogCompl>(new DogCompl("dog0", 0));
        DogCompl dogCompl1 = dogCompl0.getT();
        dogCompl1.setName("dog1");
        dogCompl1.setAge(1);
        //setName---old name=dog0,new name=dog1
        //setAge---old age=0,new age=1
        mIGenericityView.getAnimalDone();
    }

    @Override
    public void getTwoTuple(Object o, Object o2) {
        Log.e(TAG, "getTwoTuple");
        mIGenericityView.getTwoTupleDone(new TwoTuple<Object, Object>(o, o2));
    }

    @Override
    public void getLinkedStackCompl() {
        LinkedStackCompl<String> stringLinkedStackCompl = new LinkedStackCompl<String>();
        for (String s : "Phasers or stun!".split(" ")) {
            stringLinkedStackCompl.push(s);
        }
        String s2;
        while ((s2 = stringLinkedStackCompl.pop()) != null) {
            Log.e(TAG, "s2=" + s2);
        }
        //s2=stun!
        //s2=or
        //s2=Phasers
        mIGenericityView.getLinkedStackComplDone();
        //LinkedStackCompl:  push---top1.item=null
        //LinkedStackCompl: push---top1.next=null
        //NodeCompl: NodeCompl---item=Phasers
        //NodeCompl: NodeCompl---next=com.xm.study.genericity.model.NodeCompl@34ef40a1
        //LinkedStackCompl: push---top2.item=Phasers
        //LinkedStackCompl: push---top2.next=com.xm.study.genericity.model.NodeCompl@34ef40a1
        //LinkedStackCompl: push---item=Phasers
        //LinkedStackCompl: push---top1.item=Phasers
        //LinkedStackCompl: push---top1.next=com.xm.study.genericity.model.NodeCompl@34ef40a1
        //NodeCompl: NodeCompl---item=or
        //NodeCompl: NodeCompl---next=com.xm.study.genericity.model.NodeCompl@d15c2c6
        //LinkedStackCompl: push---top2.item=or
        //LinkedStackCompl: push---top2.next=com.xm.study.genericity.model.NodeCompl@d15c2c6
        //LinkedStackCompl: push---item=or
        //LinkedStackCompl: push---top1.item=or
        //LinkedStackCompl: push---top1.next=com.xm.study.genericity.model.NodeCompl@d15c2c6
        //NodeCompl: NodeCompl---item=stun!
        //NodeCompl: NodeCompl---next=com.xm.study.genericity.model.NodeCompl@1ec07287
        //LinkedStackCompl: push---top2.item=stun!
        //LinkedStackCompl: push---top2.next=com.xm.study.genericity.model.NodeCompl@1ec07287
        //LinkedStackCompl: push---item=stun!
        //LinkedStackCompl: pop---result=stun!
        //LinkedStackCompl: pop---top.item=or
        //LinkedStackCompl: pop---top.next=com.xm.study.genericity.model.NodeCompl@d15c2c6
        //GenericityPresenterCompl: s2=stun!
        //LinkedStackCompl: pop---result=or
        //LinkedStackCompl: pop---top.item=Phasers
        //LinkedStackCompl: pop---top.next=com.xm.study.genericity.model.NodeCompl@34ef40a1
        //GenericityPresenterCompl: s2=or
        //LinkedStackCompl: pop---result=Phasers
        //LinkedStackCompl: pop---top.item=null
        //LinkedStackCompl: pop---top.next=null
        //GenericityPresenterCompl: s2=Phasers
        //LinkedStackCompl: pop---result=null
        //LinkedStackCompl: pop---top.item=null
        //LinkedStackCompl: pop---top.next=null
        //GenericityActivity: getLinkedStackComplDone
    }

    @Override
    public void getRandomList() {
        RandomListCompl<String> randomListCompl = new RandomListCompl<>();
        for (String s : ("The quick brown fox jumped over" + "the lazy brown dog").split(" ")) {
            randomListCompl.add(s);
        }
        for (int i = 0; i < 10; i++) {
            Log.e(TAG, "random--select()=" + randomListCompl.
                    select());
            //random--select()=brown、random--select()=dog、random--select()=jumped
        }
        mIGenericityView.getRandomListDone();
    }

    @Override
    public void getCoffee() {
        CoffeeGeneratorCompl coffeeGeneratorCompl = new CoffeeGeneratorCompl();
        for (int i = 0; i < 5; i++) {
            Log.e(TAG, "coffeeGeneratorCompl.next()=" + coffeeGeneratorCompl.next());
        }
        for (Coffee coffee : new CoffeeGeneratorCompl(5)) {
            Log.e(TAG, "coffee=" + coffee);
        }
        mIGenericityView.getCoffeeDone();
    }

    @Override
    public void getFibonacci() {
        FibonacciGeneratorCompl fibonacciGeneratorCompl = new FibonacciGeneratorCompl();
        for (int i = 0; i < 18; i++) {
            Log.e(TAG, "fibonacciGeneratorCompl.next()=" + fibonacciGeneratorCompl.next());
        }
        //1、1、2、3、5、8、13、21、34、55、89、144、233、377、610、987、1597、2584
        mIGenericityView.getFibonacciDone();
    }

    @Override
    public void getIterableFibonacci() {
        for (int i : new IterableFibonacci(18)) {
            Log.e(TAG, "i=" + i);
        }
        mIGenericityView.getIterableFibonacciDone();
    }

    @Override
    public void getGenericMethod() {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f("");
        genericMethods.f(1);
        genericMethods.f(1.0);
        genericMethods.f(1.0f);
        genericMethods.f("a");
        genericMethods.f(genericMethods);
        //java.lang.String、java.lang.Integer、
        // java.lang.Double、java.lang.Float、
        // java.lang.String、com.xm.study.genericity.model.method.GenericMethods
        mIGenericityView.getGenericMethodDone();
    }

    @Override
    public void getGenericMethodNew() {
        Map<String, List<String>> stringListMap = New.map();
        List<String> stringList = New.list();
        LinkedList<String> stringLinkedList = New.linkedList();
        Set<String> stringSet = New.hashSet();
        Queue<String> stringQueue = New.queue();
        f(New.<String, List<String>>map());
        f(this.<String, List<String>>map());
        mIGenericityView.getGenericMethodNewDone();
    }

    @Override
    public void getGenericVarargs() {
        List<String> stringList = GenericVarargs.makeList("A");
        Log.e(TAG, "stringList=" + stringList);
        //stringList=[A]
        stringList = GenericVarargs.makeList("A", "B", "C");
        Log.e(TAG, "stringList=" + stringList);
        //stringList=[A, B, C]
        stringList = GenericVarargs.makeList("ABCDEFGHIJKLMN".split(""));
        Log.e(TAG, "stringList=" + stringList);
        //stringList=[, A, B, C, D, E, F, G, H, I, J, K, L, M, N]
        mIGenericityView.getGenericVarargsDone();
    }

    @Override
    public void getMethodGenerators() {
        Collection<Coffee> coffeeCollection = MethodGenerators.fill(new ArrayList<Coffee>(),
                new CoffeeGeneratorCompl(), 4);
        for (Coffee coffee : coffeeCollection) {
            Log.e(TAG, "coffee=" + coffee);
        }
        //coffee=AmericanoCoffee 0、coffee=LatteCoffee 1、coffee=AmericanoCoffee 2、coffee=MochaCoffee 3
        Collection<Integer> integerCollection = MethodGenerators.fill(new ArrayList<Integer>(),
                new FibonacciGeneratorCompl(), 12);
        for (int i : integerCollection) {
            Log.e(TAG, "i=" + i);
        }
        // i=1、1、2、3、5、8、13、21、34、55、89、144
        mIGenericityView.getMethodGeneratorsDone();
    }

    @Override
    public void getBaseGenerator() {
        IGenerator<Coffee> iGenerator = BaseGenerator.create(Coffee.class);
        for (int i = 0; i < 5; i++) {
            Log.e(TAG, "getBaseGenerator=" + iGenerator.next());
        }
        //getBaseGenerator=Coffee 4、getBaseGenerator=Coffee 5、getBaseGenerator=Coffee 6、getBaseGenerator=Coffee 7、getBaseGenerator=Coffee 8
        mIGenericityView.getBaseGeneratorDone();
    }

    @Override
    public void getTupleNew() {
        TwoTuple<String, Integer> twoTuple = TupleNewTest.twoTuple();
        Log.e(TAG, "twoTuple=" + twoTuple);//twoTuple=(one,1)
        Log.e(TAG, "twoTuple2=" + TupleNewTest.twoTuple2());//twoTuple2=(two,2)
        Log.e(TAG, "threeTuple=" + TupleNewTest.threeTuple());//threeTuple=(Coffee 9,three,3)
        TwoTuple<String, Integer> twoTuple2 = TupleNewTest.twoTuple2();
        Log.e(TAG, "twoTuple2=" + twoTuple2);//twoTuple2=(two,2)
        mIGenericityView.getTupleNewDone();
    }

    @Override
    public void getWatercolors() {
        //ZINE, LEMON_YELLOW, MEDIUM_YELLOW, DEEP_YELLOW,ORANGE, BRILLIAN_RED, CRIMSON
        Set<Watercolors> watercolorsSet1 = EnumSet.range(Watercolors.ZINE, Watercolors.ORANGE);
        Set<Watercolors> watercolorsSet2 = EnumSet.range(Watercolors.MEDIUM_YELLOW, Watercolors.CRIMSON);
        Log.e(TAG, "watercolorsSet1=" + watercolorsSet1);//watercolorsSet1=[ZINE, LEMON_YELLOW, MEDIUM_YELLOW, DEEP_YELLOW, ORANGE]
        Log.e(TAG, "watercolorsSet2" + watercolorsSet2);//watercolorsSet2[MEDIUM_YELLOW, DEEP_YELLOW, ORANGE, BRILLIAN_RED, CRIMSON]
        Log.e(TAG, "union=" + SetNew.union(watercolorsSet1, watercolorsSet2));//union=[LEMON_YELLOW, ZINE, BRILLIAN_RED, ORANGE, MEDIUM_YELLOW, DEEP_YELLOW, CRIMSON]
        Set<Watercolors> subWatercolorsSet = SetNew.intersection(watercolorsSet1, watercolorsSet2);
        Log.e(TAG, "intersection=" + subWatercolorsSet);//intersection=[ORANGE, MEDIUM_YELLOW, DEEP_YELLOW]
        Log.e(TAG, "difference1=" + SetNew.difference(watercolorsSet1, subWatercolorsSet));//difference1=[LEMON_YELLOW, ZINE]
        Log.e(TAG, "difference1=" + SetNew.difference(watercolorsSet2, subWatercolorsSet));//difference1=[BRILLIAN_RED, CRIMSON]
        Log.e(TAG, "complement=" + SetNew.complement(watercolorsSet1, watercolorsSet2));//complement=[LEMON_YELLOW, ZINE, BRILLIAN_RED, CRIMSON]
        mIGenericityView.getWatercolorsDone();
    }

    @Override
    public void getSetNew(Class superSet, Class subSet) {
        Log.e(TAG, superSet.getSimpleName() + " extends " + subSet.getSimpleName());//Set extends Collection
        Set<String> stringSet = SetNew.difference(SetNew.methodSet(superSet), SetNew.methodSet(subSet));
        stringSet.removeAll(object);
        Log.e(TAG, "stringSet=" + stringSet);// stringSet=[]
        SetNew.interfaces(superSet);//Interfaces in Set:[Collection]
        mIGenericityView.getSetNewDone();
    }

    @Override
    public void innerClass() {
        Random random=new Random(47);
        Queue<Customer> customerQueue=new LinkedList<Customer>();
        MethodGenerators.fill(customerQueue,Customer.generator(),15);
        List<Teller> tellerList=new ArrayList<>();
        MethodGenerators.fill(tellerList,Teller.generator,4);
        for (Customer customer:customerQueue){
            serve(tellerList.get(random.nextInt(tellerList.size())),customer);
        }
        mIGenericityView.innerClassDone();
    }

    @Override
    public void complexmodel() {
        Log.e(TAG,""+(new Store(14,5,10)));
        mIGenericityView.complexmodelDone();
    }

    public static Set<String> object = SetNew.methodSet(Object.class);

    static {
        object.add("clone");
    }

    public void serve(Teller teller,Customer customer){
        Log.e(TAG,teller+" serve "+customer);
    }
}
