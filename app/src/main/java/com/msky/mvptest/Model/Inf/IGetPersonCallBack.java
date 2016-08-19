package com.msky.mvptest.Model.Inf;

import com.msky.mvptest.Model.Bean.Person;

/**
 * Created by AIRY on 18/8/2016.
 */

public interface IGetPersonCallBack
{
    Person success();
    String error();

}
