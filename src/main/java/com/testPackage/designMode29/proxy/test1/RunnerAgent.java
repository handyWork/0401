package com.testPackage.designMode29.proxy.test1;

/**
 * 代理类     代理跑步者
 *   静态代理模式
 * （装饰者模式其实和代理类差不多只不过区别是   代理类对被代理对象有控制权可以控制其执行与不执行   而装饰者模式中  只能给其增加一层装饰不能对其进行控制  只有加强他）
 * 代理模式中，代理类对被代理的对象有控制权，决定其执行或者不执行。而装饰模式中，装饰类对代理对象没有控制权，只能为其增加一层装饰，以加强被装饰对象的功能
 */
public class RunnerAgent implements IRunner {

    private Runner runner;

    public RunnerAgent(Runner runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        if(true){
            System.out.println("代理人安排运动员进行跑步");
            runner.run();
        }else {
            System.out.println("代理人有事情不安排运行员跑步了");
        }

    }
}
