# MVPtest1


想必大家都知道MVC和MVP，MVVM。今天就来探讨一下MVP在安卓中的设计和实现。
首先谈一个需求。
你的boss说，小明去给我写一个程序很简单我提供Person ID 你给我拿出Person的姓名和性别之类的信息。小明忙问boss“老大这个ID和Person是如何关联的是从服务器接口取还是从本地数据库取还是有什么其他规则？”boss说哦等我接个电话，像是老婆打来的。小明呆呆的等着boss接完电话，boss看起来没那么开心，boss说如何关联id和person吗？这个问题业务那边还没确定下来，你先去吧功能实现，怎么取到时候我再告诉你。
小明心中一万个XX马飞过，需求没搞清就让我写代码发火。于是小明想起了当年在软件学院老师经常说需求是很可怕的东西，小明也想到当年将设计模式的老师，小明也想起来当年考试背诵的一段课文，依赖倒置原则，开闭原则，接口隔离原则等等一大串。小明知道有一种代码有一种模式能很好的应对需求的变化。于是小明查阅各种资料采取了MVP模式编写自己的代码。就这样小明的MVP之旅开始了。

图1.1
如图1.1 View和Presenter双向持有，Presenter持有Model对象注意是单向的，View和Model不会互相有瓜葛。这三个箭头也就是我们今天的梦之鬼索。若果问我，在MVP和MVC两种设计模式中对安卓的影响我肯定要说是Activity。因为Activity在俩中模式中的角色发生了改变。在MVC中Activity扮演controller的角色负责控制，吧xml等划为view。个人觉得这样很牵强很难受因为毕竟大多用系统的view用的xml不是java代码对项目结构的影响很大，你会发现其实你的View很少。好吐槽结束，那么说MVP Activity扮演了View觉得负责视图，将庞大的业务逻辑抽出到Presenter中。就像小明遇到的奇葩需求，不知道Presenter中的逻辑到底如何去写，那么好，我们要拿出我们的圣经，依赖倒置原则，依赖抽象而不依赖具体实现。那么我们只需新建一个接口来声明Presenter应该做什么，至于如何去做再说吧。大家有没有注意到这时候我们的代码设计和小明所处的环境达成了一直，没错这就面向对象语言的特质，世间万物皆对象，没错给我一个程序我能抽象整个世界。于是小明弄出了如下的UML图来设计出项目。



终于放出来大招。直接干掉了boss。boss你不是很屌吗？如何获取person信息还不知道？好只要实现iPersonPresenter接口的一切逻辑我都可以。只需新建一个新的PersonPerson实现类。然后修改一处代码，完成依赖注入。那么无论boss如何无理小明只需简单的修改程序代码依旧美丽。
public class MainActivity extends AppCompatActivity implements iPersonView {

    private TextView textView;
    private iPersonPresenter personPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //依赖注入适应各种逻辑
        personPresenter=new PersonPresenter(this);
        textView=(TextView)findViewById(R.id.textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personPresenter.getPersonByID();
            }
        });




    }

    @Override
    public void setPersoninformation(String s) {
        textView.setText(s);
    }

    @Override
    public int getid() {
        return 1110;
    }
}
项目结构如图。

小明很开心，终于学会了MVP设计模式，以后再也不怕改代码了。不过有人要吐槽了，你这样多建立了这么多类不是很复杂吗？我一个Activity全部解决所有问题，我想说Code is Art这不仅仅是科学也是艺术，有人在问接口的意义，我曾看见过有个最简单的说法。你的手机充电器问什么要有Usb接口，为的就是所有有USB接口的设备都可以与你的手机连接，这也应征了刚刚说过世间万物皆对象，没错给我一个程序我能抽象整个世界。手机接口也是就我们程序的接口，只要符合这个接口那么都可以来使用。


项目github源代码https://github.com/AndroidMsky/MVPtest1

欢迎加安卓开发交流群：308372687

博主原创未经允许不许转载。


