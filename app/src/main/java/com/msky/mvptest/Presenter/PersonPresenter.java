package com.msky.mvptest.Presenter;

import com.msky.mvptest.Model.Bean.Person;
import com.msky.mvptest.Model.Imp.PersonModel;
import com.msky.mvptest.Model.Inf.IGetPersonCallBack;
import com.msky.mvptest.Model.Inf.IPersonModel;
import com.msky.mvptest.View.iPersonView;

/**
 * Created by AIRY on 18/8/2016.
 */

public class PersonPresenter implements iPersonPresenter{
    private iPersonView mpersonView;
    private IPersonModel personModel=new PersonModel();

    public PersonPresenter(iPersonView view)
    {


        mpersonView=view;



    }


    private int getid(){

        return mpersonView.getid();
    }


    /*
    * 这里是我们的业务逻辑，比如我们是通过获取到id来取得整个PERSON的信息。
    * */
    @Override
    public void getPersonByID(){

        final Person person=new Person();


        /*
        * 用id去model里获取整个信息然后通过回调传给view
        * */
        personModel.getById(person, getid(), new IGetPersonCallBack() {
            @Override
            public Person success() {

                mpersonView.setPersoninformation
                        ("姓名"+person.getName()+"SEx"+person.getSex());
                return null;
            }

            @Override
            public String error() {
                mpersonView.setPersoninformation
                        ("ERROER");
                return null;
            }
        });





    }




}
