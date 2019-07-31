package com.testPackage.threadTest;

/**
 * 模拟多个线程同时进行取款操作
 */
public  class qukuan {

    public static void main(String[] args) {
        //创建一个公共账户
        Account account = new Account("account-c",5000.0);

        //创建线程对同一个账户取款
        processor processor = new processor(account);
        Thread thread = new Thread(processor);
        Thread thread1 = new Thread(processor);
        thread.start();
        thread1.start();


    }

    /**
     * 划款线程
     */
    static  class  processor implements Runnable{
        //账户
        Account account;

        public processor(Account account) {
            this.account = account;
        }

        @Override
        public  void run() {
            //放在方法上也是一样的效果
            synchronized (this) {
                System.out.println(Thread.currentThread().getName());
                account.withdraw(1000.0);
                System.out.println("取款1000.0成功，余额：" + account.getMoney());
            }
        }
    }

    /**
     * 创建一个账户
     */
    static  class Account{
          private String act;
          private Double money;

        public Account(String act, Double money) {
            this.act = act;
            this.money = money;
        }

        public String getAct() {
            return act;
        }

        public void setAct(String act) {
            this.act = act;
        }

        public Double getMoney() {
            return money;
        }

        public void setMoney(Double money) {
            this.money = money;
        }

        /**
         * 取钱方法
         * @param withdrawMoney
         */
        public  void withdraw(Double withdrawMoney){
            Double balance = money - withdrawMoney;
            try {
                //  网络延迟1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setMoney(balance);
        }

    }

}
