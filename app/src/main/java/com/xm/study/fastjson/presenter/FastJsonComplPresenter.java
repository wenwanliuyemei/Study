package com.xm.study.fastjson.presenter;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.xm.study.base.IView;
import com.xm.study.base.ComplPresenter;
import com.xm.study.fastjson.model.schoolman.Student;
import com.xm.study.fastjson.model.schoolman.Teacher;
import com.xm.study.fastjson.view.IFastJsonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiumei on 2017/5/3.
 */

public class FastJsonComplPresenter extends ComplPresenter implements IFastJsonPresenter {

    public FastJsonComplPresenter(Context context, IView iView) {
        super(context, iView);
    }

    @Override
    public void student2Json() {
        Student student = new Student(0, "Aaron", 24);
        Log.e(TAG, "student2Json--student=" + JSON.toJSONString(student));
        //student2Json={"age":24,"id":0,"name":"Aaron"}
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 5; i++) {
            Student stu = new Student(i, "Student" + i, 18 + i);
            students.add(stu);
        }
        Log.e(TAG, "student2Json--students=" + JSON.toJSONString(students));
        //student2Json--students=[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},
        // {"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"},{"age":22,"id":4,"name":"Student4"}]
        ((IFastJsonView) iView).student2Json();
    }

    @Override
    public void teacher2Json() {
        List<Teacher> teaList = new ArrayList<Teacher>();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Teacher teacher = new Teacher(i, "Teacher " + i);
            List<Student> stus = new ArrayList<Student>();
            for (int j = 0; j < 4; j++) {
                Student s = new Student(j, "Student" + j, 18 + j);
                stus.add(s);
            }
            teacher.setListStudents(stus);
            teaList.add(teacher);
        }
        String jsonTeach = JSON.toJSONString(teaList);
        Log.e(TAG, "teacher2Json--teaList= " + jsonTeach);
        //teacher2Json--teaList=
        //[{"id":0,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 0"},
        //{"id":1,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 1"},
        //{"id":2,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 2"},
        //{"id":3,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 3"},
        //{"id":4,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 4"},
        //{"id":5,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 5"},
        //{"id":6,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 6"},
        //{"id":7,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 7"},
        //{"id":8,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 8"},
        //{"id":9,"listStudents":[{"age":18,"id":0,"name":"Student0"},{"age":19,"id":1,"name":"Student1"},{"age":20,"id":2,"name":"Student2"},{"age":21,"id":3,"name":"Student3"}],"name":"Teacher 9"}]
        ((IFastJsonView) iView).teacher2Json();
    }
}
