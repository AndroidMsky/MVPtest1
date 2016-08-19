package com.msky.mvptest.Model.Imp;

import com.msky.mvptest.Model.Bean.Person;
import com.msky.mvptest.Model.Inf.IGetPersonCallBack;
import com.msky.mvptest.Model.Inf.IPersonModel;

/**
 * Created by AIRY on 18/8/2016.
 */

public class PersonModel implements IPersonModel {
    Person person;


    private IGetPersonCallBack getPersonCallBack;
    @Override
    public void setName(String name) {

    }

    @Override
    public void setSex(String sex) {

    }

    @Override
    public void getById(Person person,int id, IGetPersonCallBack getPersonCallBack) {
        this.getPersonCallBack=getPersonCallBack;
        this.person=person;


        /*
        * 这里可以进行网络请求网络请求可以放在LoadModel包中，请求结束后可以调用success回调更新ui
        * */

        this.person.setName(id*2+" Tom");
        this.person.setSex(id%2==0?"Man":"Woman");
        getPersonCallBack.success();



    }


}
