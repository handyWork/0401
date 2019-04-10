package com.testPackage.Responsibility;

public class MyHandler extends  AbstractHandler implements  Handler {
    private String name;
    Boolean flag = true;

    public MyHandler(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void operator() {
        System.err.println(name+"deal!");
        //暂时先这样
        if(getHandler() != null){
            getHandler().operator();
            if(this.getName().equals("h2")){
                System.out.println(name+"deal!");
                return;
            }
        }



    }


    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");
        h1.setHandler(h2);
        h2.setHandler(h3);
        System.err.println(h1.getHandler().equals(h2));

        h1.operator();
    }
}
