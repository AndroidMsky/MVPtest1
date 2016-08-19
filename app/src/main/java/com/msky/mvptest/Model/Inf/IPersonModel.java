package com.msky.mvptest.Model.Inf;

import com.msky.mvptest.Model.Bean.Person;

/**
 * Created by AIRY on 18/8/2016.
 */

public interface IPersonModel {

    void setName(String name);
    void setSex(String sex);

    //输入空person 回调接口，用户id 来获取要的person
    void getById(Person person,int id,IGetPersonCallBack getPersonCallBack);


}
